package org.springboot.microservices.learn.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date timestamp;
	private String message;
	private String errorCode;
	private String details;
	
	
	
	public ExceptionResponse(Date timestamp, String message, String errorCode, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.errorCode = errorCode;
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessgae() {
		return message;
	}
	public void setMessgae(String messgae) {
		this.message = messgae;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	

}
