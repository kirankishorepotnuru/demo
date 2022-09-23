package com.bootcamp.creditcard.exceptions;

public class CustomerNameNotFoundException extends RuntimeException {
	public CustomerNameNotFoundException(String message) 
	{
		super(message);
	}
}
