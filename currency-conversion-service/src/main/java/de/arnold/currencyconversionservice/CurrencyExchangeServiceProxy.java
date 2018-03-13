package de.arnold.currencyconversionservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//FeignClient(name="currency-exchange-service")
@FeignClient(name="NETFLIX-ZUUL-API-GATEWAY")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {


	//@GetMapping(path = "currency/exchange", produces = "application/json")
	@GetMapping(path = "currency-exchange-service/currency/exchange", produces = "application/json")
	public CurrencyConvertionBean retrieveExchangeValue(@RequestParam("from") String from, @RequestParam("to") String to);
}
