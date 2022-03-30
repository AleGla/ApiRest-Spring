package com.AleGla.exception;


import org.apache.logging.log4j.LogManager;

public class CustomException{

	private String errorMessage;
	private String errorCode;
	private ApiException exception;

	public ApiException isEmptyException() {
			errorMessage = "The Person doesn't exists in the database".toString();
			errorCode = "PEDB-0001".toString();			
			exception = new ApiException(errorMessage, errorCode);
			LogManager.getLogger().info(exception.toString());
			return exception;
		}
	
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

	public ApiException getException() {
		return exception;
	}


	public void setException(ApiException exception) {
		this.exception = exception;
	}


	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
	

	
}
