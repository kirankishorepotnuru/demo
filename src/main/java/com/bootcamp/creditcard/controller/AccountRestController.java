package com.bootcamp.creditcard.controller;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.creditcard.entities.Account;
import com.bootcamp.creditcard.exceptions.AccountIdNotFoundException;
import com.bootcamp.creditcard.response.ResponseInfo;
import com.bootcamp.creditcard.service.IAccountService;

@RestController
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class AccountRestController {
	
	@Autowired
	IAccountService accountService;
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts()
	{
		return accountService.getAllAccounts();
	}
	
	@GetMapping("/accounts/{accountId}")
	public Account getAccount(@PathVariable("accountId") int accountId)
	{
		Optional<Account> a=accountService.getAccount(accountId);
		if(a.isPresent())
		{
			return a.get();
		}
		else
		{
			throw new AccountIdNotFoundException("Account is not found for id:"+accountId);
		}
	}
	
	/*@PostMapping("/accounts/customerId/{customerId}")
	public ResponseEntity<ResponseInfo> addAccount(@PathVariable("customerId") int customerId,@Valid @RequestBody Account acc,HttpServletRequest request)
	{
		String message = accountService.addAccount(customerId,acc);
		ResponseInfo ri=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),message,request.getRequestURI());
		ResponseEntity<ResponseInfo> re=new ResponseEntity<>(ri,HttpStatus.CREATED);
		return re;
	}*/
	@PostMapping("/accounts")
	public ResponseEntity<ResponseInfo> addAccount(@Valid @RequestBody Account acc,HttpServletRequest request)
	{
		String message = accountService.addAccount(acc);
		ResponseInfo ri=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),message,request.getRequestURI());
		ResponseEntity<ResponseInfo> re=new ResponseEntity<>(ri,HttpStatus.CREATED);
		return re;
	}
    
	@DeleteMapping("/accounts/{accountId}")
	public String deleteAccount(@PathVariable("accountId") int accountId)
	{
		Optional<Account> a=accountService.getAccount(accountId);
		if(a.isPresent())
		{
			accountService.removeAccount(accountId);
			return "Deleted Successfully";
		}
		else
		{
			throw new AccountIdNotFoundException("Account is not found for id:"+accountId);
		}
	}
	
	@PutMapping("/accounts/{accountId}")
	public Account updateAccount(@PathVariable("accountId") int accountId,@RequestBody Account acc)
	{
		Account a=accountService.updateAccount(accountId, acc);
		if(a!=null)
		{
		return a;
		}
		else
		{
			throw new AccountIdNotFoundException("Account is not found for id:"+accountId);
		}
		
	}
	
}
