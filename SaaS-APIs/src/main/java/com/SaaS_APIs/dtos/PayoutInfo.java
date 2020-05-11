package com.SaaS_APIs.dtos;

import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
"payoutType",
"baseCurrency",
"nameOnAccount",
"bankAccountType",
"bankAccountClass",
"bankName",
"bankId",
"country",
"state",
"city",
"address",
"zip",
"bankAccountId",
"minimalPayoutAmount"
})

public class PayoutInfo {
	
	@JsonProperty("payoutType")
	private String payoutType;
	@JsonProperty("baseCurrency")
	private String baseCurrency;
	@JsonProperty("nameOnAccount")
	private String nameOnAccount;
	@JsonProperty("bankAccountType")
	private String bankAccountType;
	@JsonProperty("bankAccountClass")
	private String bankAccountClass;
	@JsonProperty("bankName")
	private String bankName;
	@JsonProperty("bankId")
	private String bankId;
	@JsonProperty("country")
	private String country;
	@JsonProperty("state")
	private String state;
	@JsonProperty("city")
	private String city;
	@JsonProperty("address")
	private String address;
	@JsonProperty("zip")
	private String zip;
	@JsonProperty("bankAccountId")
	private String bankAccountId;
	@JsonProperty("minimalPayoutAmount")
	private Integer minimalPayoutAmount;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("payoutType")
	public String getPayoutType() {
	return payoutType;
	}

	@JsonProperty("payoutType")
	public void setPayoutType(String payoutType) {
	this.payoutType = payoutType;
	}

	@JsonProperty("baseCurrency")
	public String getBaseCurrency() {
	return baseCurrency;
	}

	@JsonProperty("baseCurrency")
	public void setBaseCurrency(String baseCurrency) {
	this.baseCurrency = baseCurrency;
	}

	@JsonProperty("nameOnAccount")
	public String getNameOnAccount() {
	return nameOnAccount;
	}

	@JsonProperty("nameOnAccount")
	public void setNameOnAccount(String nameOnAccount) {
	this.nameOnAccount = nameOnAccount;
	}

	@JsonProperty("bankAccountType")
	public String getBankAccountType() {
	return bankAccountType;
	}

	@JsonProperty("bankAccountType")
	public void setBankAccountType(String bankAccountType) {
	this.bankAccountType = bankAccountType;
	}

	@JsonProperty("bankAccountClass")
	public String getBankAccountClass() {
	return bankAccountClass;
	}

	@JsonProperty("bankAccountClass")
	public void setBankAccountClass(String bankAccountClass) {
	this.bankAccountClass = bankAccountClass;
	}

	@JsonProperty("bankName")
	public String getBankName() {
	return bankName;
	}

	@JsonProperty("bankName")
	public void setBankName(String bankName) {
	this.bankName = bankName;
	}

	@JsonProperty("bankId")
	public String getBankId() {
	return bankId;
	}

	@JsonProperty("bankId")
	public void setBankId(String bankId) {
	this.bankId = bankId;
	}

	@JsonProperty("country")
	public String getCountry() {
	return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
	this.country = country;
	}

	@JsonProperty("state")
	public String getState() {
	return state;
	}

	@JsonProperty("state")
	public void setState(String state) {
	this.state = state;
	}

	@JsonProperty("city")
	public String getCity() {
	return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
	this.city = city;
	}

	@JsonProperty("address")
	public String getAddress() {
	return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
	this.address = address;
	}

	@JsonProperty("zip")
	public String getZip() {
	return zip;
	}

	@JsonProperty("zip")
	public void setZip(String zip) {
	this.zip = zip;
	}

	@JsonProperty("bankAccountId")
	public String getBankAccountId() {
	return bankAccountId;
	}

	@JsonProperty("bankAccountId")
	public void setBankAccountId(String bankAccountId) {
	this.bankAccountId = bankAccountId;
	}

	@JsonProperty("minimalPayoutAmount")
	public Integer getMinimalPayoutAmount() {
	return minimalPayoutAmount;
	}

	@JsonProperty("minimalPayoutAmount")
	public void setMinimalPayoutAmount(Integer minimalPayoutAmount) {
	this.minimalPayoutAmount = minimalPayoutAmount;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

}
