package org.kuali.assignment.elevator;

public class ElevatorPersistenceException extends RuntimeException {

	public ElevatorPersistenceException() {
	}

	public ElevatorPersistenceException(String message) {
		super(message);
	}

	public ElevatorPersistenceException(Throwable cause) {
		super(cause);
	}

	public ElevatorPersistenceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ElevatorPersistenceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
