package com.bootcamp.creditcard.exceptions;

public class AccountIdNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountIdNotFoundException(String message)
	{
		super(message);
	}

}
