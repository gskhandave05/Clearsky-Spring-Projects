package com.gk.egen.api.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/***
 * 
 * @author gauravkhandave
 *	Date: 08/01/2017
 *	Versoin: 1.0.0
 *	Custom exception handler class
 */

@ResponseStatus(code=HttpStatus.NO_CONTENT)
public class CustomException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomException(String message){
		super(message);		
	}
	
	public CustomException(String message, Throwable cause){
		super(message,cause);
	}

}
