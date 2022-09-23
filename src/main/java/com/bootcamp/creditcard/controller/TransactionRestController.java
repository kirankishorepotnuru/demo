package com.bootcamp.creditcard.controller;

import java.util.List;
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

import com.bootcamp.creditcard.entities.Transaction;
import com.bootcamp.creditcard.exceptions.TransactionIdNotFoundException;
import com.bootcamp.creditcard.response.ResponseInfo;
import com.bootcamp.creditcard.service.ICustomerService;
import com.bootcamp.creditcard.service.ITransactionService;

@RestController
public class TransactionRestController {
	
	@Autowired
	ITransactionService transactionService;

	
	@PostMapping("/transactions/{customerId}")
	public ResponseEntity<ResponseInfo> addTransaction(@PathVariable("customerId") int customerId, @Valid @RequestBody Transaction transaction,HttpServletRequest request)
	{
		String message = transactionService.addTransactionByCustomerId(transaction,customerId);
		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),message,request.getRequestURI());
		ResponseEntity<ResponseInfo> responseEntity=new ResponseEntity<>(responseInfo,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/transactions/bycustomerid/{customerId}")
	public List<Transaction> getTransactions(@PathVariable("customerId") int customerId)
	{
		return transactionService.getAllTransactions(customerId);
	}
	
	@GetMapping("/transactions/{transactionId}")
	public Transaction getTransaction(@PathVariable("transactionId") int transId)
	{
		Optional<Transaction> transaction = transactionService.getTransaction(transId);
		if(transaction.isPresent())
		{
			return transaction.get();
		}
		else
		{
			throw new TransactionIdNotFoundException("transaction is not found for id:"+transId);
		}
	}

}
