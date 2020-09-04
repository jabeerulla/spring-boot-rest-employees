package com.employees.exception;

import java.util.Date;

public class ExceptionResponse {
	private String uri;
	private String message;
	private String httpCode;
	private String httpCodeMessage;
	private Date timestamp;

	public ExceptionResponse(String uri, String message, String httpCode, String httpCodeMessage, Date timestamp) {
		this.uri = uri;
		this.message = message;
		this.httpCode = httpCode;
		this.httpCodeMessage = httpCodeMessage;
		this.timestamp = timestamp;
	}

	public String getUri() {
		return uri;
	}

	public String getMessage() {
		return message;
	}

	public String getHttpCode() {
		return httpCode;
	}

	public String getHttpCodeMessage() {
		return httpCodeMessage;
	}

	public Date getTimestamp() {
		return timestamp;
	}

}
