package com.AleGla.utils;

import org.apache.logging.log4j.LogManager;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import com.AleGla.exception.ApiException;
import com.fasterxml.jackson.core.JsonProcessingException;


public class BadResponse {

	public static String exceptionResponse(JSONObject json, HttpStatus http, ApiException ex) throws JsonProcessingException {
		json.put("ErrorCode", ex.getCode());
		json.put("Status", http.value());
		json.put("ErrorMessage", ex.getErrorMessage());		
		LogManager.getLogger().info(json);
		return json.toString();
	}
}
