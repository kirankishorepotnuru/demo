package com.bootcamp.creditcard.exceptions;

import java.net.http.HttpResponse.ResponseInfo;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AccountIdNotFoundException.class)
	public String handlingMethod(AccountIdNotFoundException a)
	{
		return "AccountIdNotFoundException"+":"+a.getMessage();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handlerMethodForException(MethodArgumentNotValidException ex)
	{
		Map<String,String> errorMessage=new LinkedHashMap<>();
		List<ObjectError> list=ex.getAllErrors();
		list.forEach(obj->{
			FieldError ferr=(FieldError)obj;
			String fname=ferr.getField();
			String msg=ferr.getDefaultMessage();
			errorMessage.put(fname, msg);
		});
		return errorMessage;
		
	}
	
	@ExceptionHandler(CustomerIdNotFoundException.class)
	public String handlingMethodForId(CustomerIdNotFoundException eId)
	{
		return "IdNotFoundException"+":"+eId.getMessage();
	}	
	
	@ExceptionHandler(CustomerNameNotFoundException.class)
	public String handlingMethodForName(CustomerNameNotFoundException eName)
	{
		return "NameNotFoundException"+":"+eName.getMessage();
	
	}
	
	@ExceptionHandler(CreditCardIdNotFoundException.class)
	public String handlingMethodForCreditCardForId(CreditCardIdNotFoundException eCreditId)
	{
		return "IdNotFoundException"+" : "+eCreditId.getMessage();
	}
	
	@ExceptionHandler(PaymentIdNotFoundException.class)
	public String handlingMethodForPaymentForId(PaymentIdNotFoundException ePaymentId)
	{
		return "IdNotFoundException"+" : "+ePaymentId.getMessage();
	}
	
	@ExceptionHandler(StatementIdNotFoundException.class)
	public String handlingMethodForStatementForId(StatementIdNotFoundException eStatementId)
	{
		return "IdNotFoundException"+" : "+eStatementId.getMessage();
	}
	

	@ExceptionHandler(TransactionIdNotFoundException.class)
	public String handlingMethodForTransactionForId(TransactionIdNotFoundException eTransactionId)
	{
		return "IdNotFoundException"+" : "+eTransactionId.getMessage();
	}
	
	
}
