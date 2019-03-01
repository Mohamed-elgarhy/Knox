package com.konux.interview.assignment.exceptions;

public class InvalidArgumentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 165788999L;
	
	private Integer errorCode;
	

	public InvalidArgumentException() {
		super();
	}

	public InvalidArgumentException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InvalidArgumentException(String message, Throwable cause, Integer errorCode) {
		super(message, cause);
		this.errorCode=errorCode;
	}

	public InvalidArgumentException(String message, Integer errorCode) {
		super(message);
		this.errorCode=errorCode;
	}

	public InvalidArgumentException(Throwable cause) {
		super(cause);
	}

	public Integer getErrorCode() {
		return errorCode;
	}
	
	

}
