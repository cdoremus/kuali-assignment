package org.kuali.assignment.elevator;

public class ElevatorValidationException extends Exception {

	private static final long serialVersionUID = 1L;

	public ElevatorValidationException() {
		super();
	}

	public ElevatorValidationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ElevatorValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ElevatorValidationException(String message) {
		super(message);
	}

	public ElevatorValidationException(Throwable cause) {
		super(cause);
	}

	
}
