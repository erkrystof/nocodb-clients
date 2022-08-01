package io.krystof.nocodb.clients.exceptions;

public class GenericNocoDbClientException extends RuntimeException {

	public GenericNocoDbClientException() {
		super();
	}

	public GenericNocoDbClientException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GenericNocoDbClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenericNocoDbClientException(String message) {
		super(message);
	}

	public GenericNocoDbClientException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = -2764370941217308324L;

}
