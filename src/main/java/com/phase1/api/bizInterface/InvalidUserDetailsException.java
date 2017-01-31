package com.phase1.api.bizInterface;

import com.phase1.api.exception.RegisterException;

public class InvalidUserDetailsException extends RegisterException {

	public InvalidUserDetailsException() {
		super();
	}

	public InvalidUserDetailsException(String message) {
		super(message);
	}

	public InvalidUserDetailsException(Throwable cause) {
		super(cause);
	}

	public InvalidUserDetailsException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidUserDetailsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
