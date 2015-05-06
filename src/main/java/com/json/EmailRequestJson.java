package com.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonPOJOBuilder
public class EmailRequestJson {
	
	@JsonProperty(value = "to", required = true)
	private String to;
	
	@JsonProperty(value = "from", required = true)
	private String from;
	
	@JsonProperty(value = "subject", required = true)
	private String subject;
	
	@JsonProperty(value = "body", required = true)
	private String body;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	
	

}
