package com.collabera.jump.exceptions;

import java.util.Date;

public class ExceptionResponse {

	private String message;
	private String details;

	private Date timestamp;
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	

	public Date getTimestamp() {
		return timestamp;
	}

	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(String message, String details) {
		super();
		this.message = message;
		this.details = details;
		this.timestamp = new Date();
	}
	
	

}
