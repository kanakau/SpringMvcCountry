package com.luv2code.springdemo.dto;

import java.sql.Date;

import com.luv2code.springdemo.entity.Country;
import com.luv2code.springdemo.entity.Fee;

public class FeeLinkTo {
	
	private int feeLinkId;
	private Country country;
	private int countryId;
	private Fee fee;
	private int amount;
	private String toDate;
	private String fromDate;
	private String countryCode;
	private String countryName;
	private int feeId; 

	public int getFeeLinkId() {
		return feeLinkId;
	}
	public void setFeeLinkId(int feeLinkId) {
		this.feeLinkId = feeLinkId;
	}
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Fee getFee() {
		return fee;
	}
	public void setFee(Fee fee) {
		this.fee = fee;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getFeeId() {
		return feeId;
	}
	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}
	
	
}
