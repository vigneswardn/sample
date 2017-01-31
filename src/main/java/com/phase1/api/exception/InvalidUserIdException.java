package com.phase1.api.exception;

public class InvalidUserIdException extends LoginException {

	public InvalidUserIdException() {
		super();
	}

	public InvalidUserIdException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidUserIdException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidUserIdException(String message) {
		super(message);
	}

	public InvalidUserIdException(Throwable cause) {
		super(cause);
	}

}
