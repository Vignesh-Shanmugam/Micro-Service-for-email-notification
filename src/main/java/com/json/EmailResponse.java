package com.emc.eas.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonPOJOBuilder
public class EmailResponse {
	
	@JsonProperty(value = "staus", required = true)
	private String staus;
	
	@JsonProperty(value = "message", required = true)
	private String message;

	public String getStaus() {
		return staus;
	}

	public void setStaus(String staus) {
		this.staus = staus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
