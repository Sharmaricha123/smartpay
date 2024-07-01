package com.smartpay.response;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"Status", "Details"})
@Generated("jsonschema2pojo")
public class TwoFactorResponse {
	
	@JsonProperty("Status")
	private String Status;
	
	@JsonProperty("Details")
	private String Details;

	public TwoFactorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TwoFactorResponse(String status, String details) {
		super();
		Status = status;
		Details = details;
	}

	@JsonProperty("Status")
	public String getStatus() {
		return Status;
	}

	@JsonProperty("Status")
	public void setStatus(String status) {
		Status = status;
	}

	@JsonProperty("Details")
	public String getDetails() {
		return Details;
	}

	@JsonProperty("Details")
	public void setDetails(String details) {
		Details = details;
	}
	
	

}
