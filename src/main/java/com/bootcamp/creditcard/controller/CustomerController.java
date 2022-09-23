package com.bootcamp.creditcard.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.creditcard.entities.Addresses;
import com.bootcamp.creditcard.entities.Customer;
import com.bootcamp.creditcard.entities.Transaction;
import com.bootcamp.creditcard.exceptions.CustomerIdNotFoundException;
import com.bootcamp.creditcard.exceptions.CustomerNameNotFoundException;
import com.bootcamp.creditcard.response.ResponseInfo;
import com.bootcamp.creditcard.service.ICustomerService;
import com.fasterxml.jackson.annotation.JsonIgnore;

@RestController
public class CustomerController {
	
	@Autowired
	ICustomerService customerService;
	
	@PostMapping("/customers")
	public ResponseEntity<ResponseInfo> addCustomer(@Valid @RequestBody Customer customer,HttpServletRequest request)
	{
		String message = customerService.addCustomer(customer);
		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),message,request.getRequestURI());
		ResponseEntity<ResponseInfo> responseEntity=new ResponseEntity<>(responseInfo,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String removeCustomer(@PathVariable("customerId") int custId)
	{
		Optional<Customer> customerList = customerService.getCustomer(custId);
		if(customerList.isPresent())
		{
			customerService.removeCustomer(custId);
			return "Customer Remove Successfully "+custId;
		}
		else
		{
			throw new CustomerIdNotFoundException("Customer is not found for id: "+custId);
		}
	}
	
	@DeleteMapping("/customers/removecustomer/{customerName}")
	public String removeCustomerByName(@PathVariable("customerName") String customerName)
	{
		Optional<Customer> customerList = customerService.getCustomerByName(customerName);
		if(customerList.isPresent())
		{
			customerService.removeCustomerByName(customerName);
			return "Customer Remove Successfully of "+customerName;
		}
		else
		{
			throw new CustomerIdNotFoundException("Customer is not found for id: "+customerName);
		}
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers()
	{
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") int custId)
	{
		Optional<Customer> customer = customerService.getCustomer(custId);
	    if(customer.isPresent())
	    {
	    	return customer.get();
	    }
	    else
	    {
	    	throw new CustomerIdNotFoundException("Customer is not found for id: "+custId);
	    }	
	}
	
	@PutMapping("/customers/{customerId}")
	public Customer updateCustomer(@PathVariable("customerId") int custId,@Valid @RequestBody Customer customer)
	{
		Customer newCustomer = customerService.updateCustomer(custId, customer);
		if(newCustomer!=null)
		{
			return newCustomer;
		}
		else
		{
			throw new CustomerIdNotFoundException("Customer is not found for id: "+newCustomer.getUserId());
		}
	}
	
	@PutMapping("/addresses/{customerId}")
	public Addresses updateCustomerAddress(@PathVariable("customerId") int custId,@Valid @RequestBody Addresses address)
	{
		Addresses newCustomerAddress = customerService.updateCustomerAddress(custId, address);
		if(newCustomerAddress!=null)
		{
			return newCustomerAddress;
		}
		else
		{
			throw new CustomerIdNotFoundException("Customer is not found for id: "+newCustomerAddress.getAddressId());
		}
	}
	
	@GetMapping("/customers/customername/{customerName}")
	public Optional<Customer> getCustomerByName(@PathVariable("customerName") String custName)
	{
		Optional<Customer> customerList = customerService.getCustomerByName(custName);
	    if(customerList!=null)
	    {
	    	return customerList;
	    }
	    else
	    {
	    	throw new CustomerNameNotFoundException("Customer is not found for name: "+custName);
	    }	
	}
//	
//	@PostMapping("/customers/transactions/{customerId}")
//	public ResponseEntity<ResponseInfo> addTransaction(@PathVariable("customerId") int customerId, @Valid @RequestBody Transaction transaction,HttpServletRequest request)
//	{
//		String message = customerService.addTransactionByCustomerId(transaction,customerId);
//		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),message,request.getRequestURI());
//		ResponseEntity<ResponseInfo> responseEntity=new ResponseEntity<>(responseInfo,HttpStatus.CREATED);
//		return responseEntity;
//	}
//	
	
}
