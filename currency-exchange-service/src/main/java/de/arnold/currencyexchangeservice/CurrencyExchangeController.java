package de.arnold.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Environment environment;

	@Autowired
	private ExchangeValueRespoitory repository;

	@GetMapping(path = "currency/exchange", produces = "application/json")
	public ExchangeValue retrieveExchangeValue(@RequestParam String from, @RequestParam String to) {
		ExchangeValue exchange = repository.findByFromAndTo(from, to);
		exchange.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		LOG.info("{}", exchange);
		return exchange;
	}
}
