package de.arnold.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConvertionBean {

	private long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal requestedQuantity;
	private BigDecimal totalCalculatedAmount;
	private int port;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getRequestedQuantity() {
		return requestedQuantity;
	}

	public void setRequestedQuantity(BigDecimal requestedQuantity) {
		this.requestedQuantity = requestedQuantity;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public CurrencyConvertionBean(long id, String from, String to, BigDecimal conversionMulitple,
			BigDecimal requestedQuantity, BigDecimal totalCalculatedAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMulitple;
		this.requestedQuantity = requestedQuantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.port = port;
	}

	public CurrencyConvertionBean() {
		super();
	}

	@Override
	public String toString() {
		return "CurrencyConvertionBean [id=" + id + ", from=" + from + ", to=" + to + ", conversionMulitple="
				+ conversionMultiple + ", requestedQuantity=" + requestedQuantity + ", totalCalculatedAmount="
				+ totalCalculatedAmount + ", port=" + port + "]";
	}
	
}
