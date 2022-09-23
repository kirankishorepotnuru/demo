package com.bootcamp.creditcard.controller;

import java.net.http.HttpHeaders;
import java.net.http.HttpClient.Version;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.creditcard.response.ResponseInfo;
import com.bootcamp.creditcard.entities.Statement;
import com.bootcamp.creditcard.entities.Transaction;
import com.bootcamp.creditcard.exceptions.CustomerIdNotFoundException;
import com.bootcamp.creditcard.exceptions.StatementIdNotFoundException;
import com.bootcamp.creditcard.service.IStatementService;


@RestController
public class StatementRestController {
	
	@Autowired
	IStatementService statementService;
//	
//	@PostMapping("/statements/{customerId}/{month}/{year}")
//	public ResponseEntity<ResponseInfo> addStatement(@PathVariable("customerId") int customerId, @PathVariable("month") LocalDate month, @PathVariable("year") LocalDate year, HttpServletRequest request)
//	{
//		String message = statementService.generateStatementByCustomerId(customerId, month, year);
//		ResponseInfo responseInfo=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),message,request.getRequestURI());
//		ResponseEntity<ResponseInfo> responseEntity=new ResponseEntity<>(responseInfo,HttpStatus.CREATED);
//		return responseEntity;
//	}
	
	@GetMapping("/statements/{customerId}/{month}/{year}")
	public Statement generateStatement(@PathVariable("customerId") int customerId, @PathVariable("month") int month, @PathVariable("year") int year)
	{
//		Statement statement =  
		return statementService.generateStatementByCustomerId(customerId, month, year);
//		if(statement.)
//		{
//			return statement.get();
//		}
//		else
//	    {
//	    	throw new StatementIdNotFoundException("statement is not found for id: "+statement.get());
//	    }
		
	}
	
//	
//	@DeleteMapping("/statements/{statementId}")
//	public Statement removeStatement(@PathVariable("statementId") int statementId)
//	{
//		Optional<Statement> statementList = statementservice.getStatement(statementId);
//		if(statementList.isPresent())
//		{
//			statementservice.removeStatement(statementId);
//			return statementList.get();
//		}
//		else
//		{
//			throw new statementIdNotFoundException("CreditCard is not found for id: "+statementId);
//		}
//	}
	
	@GetMapping("/statements/bycustomerid/{customerId}")
	public List<Statement> getAllStatements(@PathVariable("customerId") int customerId)
	{
		return statementService.getAllStatements(customerId);
	}
	
	@GetMapping("/statements/{statementId}")
	public Statement getStatement(@PathVariable("statementId") int statementId)
	{
		Optional<Statement> statement = statementService.getStatement(statementId);
	    if(statement.isPresent())
	    {
	    	return statement.get();
	    }
	    else
	    {
	    	throw new StatementIdNotFoundException("statement is not found for id: "+statementId);
	    }	
	}
	
	@GetMapping("/statements/getBilled/{customerId}/{startingDate}/{endingDate}")
	public List<Statement> getBilledStatement(@PathVariable("customerId") int customerId, @PathVariable("startingDate") String startingDate, @PathVariable("endingDate") String endingDate)
	{
//		return statementService.getBilledStatement(customerId, startingDate, endingDate);
	
		LocalDate newStartingDate = LocalDate.parse(startingDate); 
		LocalDate newEndingDate = LocalDate.parse(endingDate);
		List<Statement> allBilledStatements = statementService.getBilledStatement(customerId, newStartingDate, newEndingDate);
		
		if(allBilledStatements.listIterator()!=null)
		{
			return allBilledStatements;
		}
		else
		{
			throw new CustomerIdNotFoundException("Customer is not found for id: "+ customerId);
		}

	}
	
	@GetMapping("/statements/getUnBilled/{customerId}")
	public List<Transaction> getUnBilledStatement(@PathVariable("customerId") int customerId)
	{
		//return statementService.getUnBilledStatement(customerId);
		List<Transaction> allUnBilledStatements = statementService.getUnBilledStatement(customerId);
		
		if(allUnBilledStatements.listIterator()!=null)
		{
			return allUnBilledStatements;
		}
		else
		{
			throw new CustomerIdNotFoundException("Customer is not found for id: "+ customerId);
		}

	}
	
	
//	@PutMapping("/statements/{statementId}")
//	public Statement updateStatement(@PathVariable("statementId") int statementId,@Valid @RequestBody Statement statement)
//	{
//		Statement newStatement = statementservice.updateStatement(statementId, statement);
//		if(newStatement!=null)
//		{
//			return newStatement;
//		}
//		else
//		{
//			throw new statementIdNotFoundException("statement is not found for id: "+newStatement.getStatementId());
//		}
//	}
	
}
