package com.bootcamp.creditcard.exceptions;

public class TransactionIdNotFoundException extends RuntimeException {
	public TransactionIdNotFoundException(String message)
	{
		super(message);
	}

}
