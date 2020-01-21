package com.example.springbootpoc.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="CUSTOM_DATE")
public class CustomDate {
	
	@Column(name="FUTURE_DATE")
	private String futureDate;
	
	@Column(name="CUST_DATE")
	private String customDate;

	
	public String getFutureDate() {
		return futureDate;
	}
	public void setFutureDate(String futureDate) {
		this.futureDate = futureDate;
	}
	public String getCustomDate() {
		return customDate;
	}
	public void setCustomDate(String customDate) {
		this.customDate = customDate;
	}

}
