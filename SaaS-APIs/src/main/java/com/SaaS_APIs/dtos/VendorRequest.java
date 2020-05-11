package com.SaaS_APIs.dtos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
"email",
"firstName",
"lastName",
"phone",
"address",
"city",
"country",
"state",
"zip",
"vendorUrl",
"defaultPayoutCurrency",
"vendorPrincipal",
"vendorAgreement",
"payoutInfo",
"ipnUrl"
})

public class VendorRequest {

	@JsonProperty("email")
	private String email;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("address")
	private String address;
	@JsonProperty("city")
	private String city;
	@JsonProperty("country")
	private String country;
	@JsonProperty("state")
	private String state;
	@JsonProperty("zip")
	private String zip;
	@JsonProperty("vendorUrl")
	private String vendorUrl;
	@JsonProperty("defaultPayoutCurrency")
	private String defaultPayoutCurrency;
	@JsonProperty("vendorPrincipal")
	private VendorPrincipal vendorPrincipal;
	@JsonProperty("vendorAgreement")
	private VendorAgreement vendorAgreement;
	@JsonProperty("payoutInfo")
	private List<PayoutInfo> payoutInfo = null;
	@JsonProperty("ipnUrl")
	private String ipnUrl;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("email")
	public String getEmail() {
	return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
	this.email = email;
	}

	@JsonProperty("firstName")
	public String getFirstName() {
	return firstName;
	}

	@JsonProperty("firstName")
	public void setFirstName(String firstName) {
	this.firstName = firstName;
	}

	@JsonProperty("lastName")
	public String getLastName() {
	return lastName;
	}

	@JsonProperty("lastName")
	public void setLastName(String lastName) {
	this.lastName = lastName;
	}

	@JsonProperty("phone")
	public String getPhone() {
	return phone;
	}

	@JsonProperty("phone")
	public void setPhone(String phone) {
	this.phone = phone;
	}

	@JsonProperty("address")
	public String getAddress() {
	return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
	this.address = address;
	}

	@JsonProperty("city")
	public String getCity() {
	return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
	this.city = city;
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

	@JsonProperty("zip")
	public String getZip() {
	return zip;
	}

	@JsonProperty("zip")
	public void setZip(String zip) {
	this.zip = zip;
	}

	@JsonProperty("vendorUrl")
	public String getVendorUrl() {
	return vendorUrl;
	}

	@JsonProperty("vendorUrl")
	public void setVendorUrl(String vendorUrl) {
	this.vendorUrl = vendorUrl;
	}

	@JsonProperty("defaultPayoutCurrency")
	public String getDefaultPayoutCurrency() {
	return defaultPayoutCurrency;
	}

	@JsonProperty("defaultPayoutCurrency")
	public void setDefaultPayoutCurrency(String defaultPayoutCurrency) {
	this.defaultPayoutCurrency = defaultPayoutCurrency;
	}

	@JsonProperty("vendorPrincipal")
	public VendorPrincipal getVendorPrincipal() {
	return vendorPrincipal;
	}

	@JsonProperty("vendorPrincipal")
	public void setVendorPrincipal(VendorPrincipal vendorPrincipal) {
	this.vendorPrincipal = vendorPrincipal;
	}

	@JsonProperty("vendorAgreement")
	public VendorAgreement getVendorAgreement() {
	return vendorAgreement;
	}

	@JsonProperty("vendorAgreement")
	public void setVendorAgreement(VendorAgreement vendorAgreement) {
	this.vendorAgreement = vendorAgreement;
	}

	@JsonProperty("payoutInfo")
	public List<PayoutInfo> getPayoutInfo() {
	return payoutInfo;
	}

	@JsonProperty("payoutInfo")
	public void setPayoutInfo(List<PayoutInfo> payoutInfo) {
	this.payoutInfo = payoutInfo;
	}

	@JsonProperty("ipnUrl")
	public String getIpnUrl() {
	return ipnUrl;
	}

	@JsonProperty("ipnUrl")
	public void setIpnUrl(String ipnUrl) {
	this.ipnUrl = ipnUrl;
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
