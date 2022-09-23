package com.bootcamp.creditcard.exceptions;

public class CreditCardIdNotFoundException extends RuntimeException {
	public CreditCardIdNotFoundException(String message) 
	{
		super(message);
	}
}
