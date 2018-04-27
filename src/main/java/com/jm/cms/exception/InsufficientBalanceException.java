package com.jm.cms.exception;

public class InsufficientBalanceException extends Exception {

	/**
	 * Constructor for InsufficientBalance.
	 **/
	public InsufficientBalanceException(){
		super();
	}

	public InsufficientBalanceException(String message, Throwable cause) {
		super(message,cause);

	}

	public InsufficientBalanceException(Throwable cause) {
		super(cause);

	}

	public InsufficientBalanceException(String message) {
		super(message);

	}
}



