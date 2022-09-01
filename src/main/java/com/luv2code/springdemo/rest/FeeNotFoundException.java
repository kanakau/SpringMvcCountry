package com.luv2code.springdemo.rest;

public class FeeNotFoundException extends RuntimeException {

	public FeeNotFoundException() {
		
	}

	public FeeNotFoundException(String message) {
		super(message);
		
	}

	public FeeNotFoundException(Throwable cause) {
		super(cause);
		
	}

	public FeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public FeeNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
