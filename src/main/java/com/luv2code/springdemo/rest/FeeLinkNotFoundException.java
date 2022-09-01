package com.luv2code.springdemo.rest;

public class FeeLinkNotFoundException extends RuntimeException {

	public FeeLinkNotFoundException() {
		
	}

	public FeeLinkNotFoundException(String message) {
		super(message);
		
	}

	public FeeLinkNotFoundException(Throwable cause) {
		super(cause);
		
	}

	public FeeLinkNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public FeeLinkNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
