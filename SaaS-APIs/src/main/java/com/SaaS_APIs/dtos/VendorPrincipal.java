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
"firstName",
"lastName",
"address",
"city",
"country",
"zip",
"dob",
"personalIdentificationNumber",
"driverLicenseNumber",
"email"
})

public class VendorPrincipal {
	

@JsonProperty("firstName")
private String firstName;
@JsonProperty("lastName")
private String lastName;
@JsonProperty("address")
private String address;
@JsonProperty("city")
private String city;
@JsonProperty("country")
private String country;
@JsonProperty("zip")
private String zip;
@JsonProperty("dob")
private String dob;
@JsonProperty("personalIdentificationNumber")
private String personalIdentificationNumber;
@JsonProperty("driverLicenseNumber")
private String driverLicenseNumber;
@JsonProperty("email")
private String email;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

@JsonProperty("zip")
public String getZip() {
return zip;
}

@JsonProperty("zip")
public void setZip(String zip) {
this.zip = zip;
}

@JsonProperty("dob")
public String getDob() {
return dob;
}

@JsonProperty("dob")
public void setDob(String dob) {
this.dob = dob;
}

@JsonProperty("personalIdentificationNumber")
public String getPersonalIdentificationNumber() {
return personalIdentificationNumber;
}

@JsonProperty("personalIdentificationNumber")
public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
this.personalIdentificationNumber = personalIdentificationNumber;
}

@JsonProperty("driverLicenseNumber")
public String getDriverLicenseNumber() {
return driverLicenseNumber;
}

@JsonProperty("driverLicenseNumber")
public void setDriverLicenseNumber(String driverLicenseNumber) {
this.driverLicenseNumber = driverLicenseNumber;
}

@JsonProperty("email")
public String getEmail() {
return email;
}

@JsonProperty("email")
public void setEmail(String email) {
this.email = email;
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
