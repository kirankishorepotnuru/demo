package com.bootcamp.creditcard.service;

import org.springframework.stereotype.Service;

import com.bootcamp.creditcard.entities.Addresses;
import com.bootcamp.creditcard.entities.Customer;
import com.bootcamp.creditcard.entities.Transaction;

import java.util.List;
import java.util.Optional;


@Service
public interface ICustomerService {
	public String addCustomer(Customer customer);
	public String removeCustomer(int custId);
	public Customer updateCustomer(int custId, Customer customer);
	public Optional<Customer> getCustomer(int custId);
	public List<Customer> getAllCustomers();
	public Optional<Customer> getCustomerByName(String custName);
	public String removeCustomerByName(String custName);
	public Addresses updateCustomerAddress(int custId, Addresses address);
}