package com.jm.cms.exception;

public class NotEnoughQuantityException extends Exception {

	/**
	 * Constructor for NotEnoughQuantity.
	 **/
	public NotEnoughQuantityException(){
		super();
	}

	public NotEnoughQuantityException(String message, Throwable cause) {
		super(message,cause);

	}

	public NotEnoughQuantityException(Throwable cause) {
		super(cause);

	}

	public NotEnoughQuantityException(String message) {
		super(message);

	}
}



