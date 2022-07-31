package io.krystof.nocodb.clients.exceptions;

public class UnexpectedMultipleRowsException extends RuntimeException {

	public UnexpectedMultipleRowsException() {
		super();
	}

	public UnexpectedMultipleRowsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnexpectedMultipleRowsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnexpectedMultipleRowsException(String message) {
		super(message);
	}

	public UnexpectedMultipleRowsException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = -2764370941217308324L;

}
