package de.arnold.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping(path = "/currency/exchange/converter")
	public CurrencyConvertionBean convertCurrency(@RequestParam String from, @RequestParam String to,
			@RequestParam BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConvertionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency/exchange?from={from}&to={to}", CurrencyConvertionBean.class,
				uriVariables);

		CurrencyConvertionBean response = responseEntity.getBody();
		
		LOG.debug(response.toString());
		return new CurrencyConvertionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
	
	@GetMapping(path = "/currency/exchange/converter-feign")
	public CurrencyConvertionBean convertCurrencyFeign(@RequestParam String from, @RequestParam String to,
			@RequestParam BigDecimal quantity) {

		CurrencyConvertionBean response = proxy.retrieveExchangeValue(from, to);
		
		LOG.info("{}", response);
		
		return new CurrencyConvertionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
}
