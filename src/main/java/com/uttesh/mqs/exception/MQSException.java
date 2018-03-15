package com.uttesh.mqs.exception;

public class MQSException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MQSException(String message) {
        super(message);
    }
	
	public MQSException(String message, Throwable cause) {
        super(message, cause);
    }
}
