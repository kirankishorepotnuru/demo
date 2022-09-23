package com.bootcamp.creditcard.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.creditcard.entities.Payment;
import com.bootcamp.creditcard.entities.Statement;
import com.bootcamp.creditcard.exceptions.PaymentIdNotFoundException;
import com.bootcamp.creditcard.exceptions.StatementIdNotFoundException;
import com.bootcamp.creditcard.response.ResponseInfo;
import com.bootcamp.creditcard.service.IPaymentService;

@RestController
public class PaymentRestController {
	
	@Autowired
	IPaymentService paymentService;
	

	
//	
//	@PostMapping("/payments/{statementId}")
//	public ResponseEntity<ResponseInfo> addPayment(@PathVariable("statementId") int statementId, @Valid @RequestBody Payment payment,HttpServletRequest request)
//	{
//		String message = paymentService.addPaymentByStatementId(payment,statementId);
//		ResponseInfo responseInfo=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),message,request.getRequestURI());
//		ResponseEntity<ResponseInfo> responseEntity=new ResponseEntity<>(responseInfo,HttpStatus.CREATED);
//		return responseEntity;
//	}
//	
	@GetMapping("/payments/{paymentId}")
	public Payment getPaymentById(@PathVariable("paymentId") int paymentId)
	{
		Optional<Payment> payment = paymentService.getPayment(paymentId);
	    if(payment.isPresent())
	    {
	    	return payment.get();
	    }
	    else
	    {
	    	throw new PaymentIdNotFoundException("payment is not found for id: "+paymentId);
	    }	
	}
	
}
