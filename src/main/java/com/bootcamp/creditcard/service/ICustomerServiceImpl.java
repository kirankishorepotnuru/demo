package com.bootcamp.creditcard.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.creditcard.entities.Addresses;
import com.bootcamp.creditcard.entities.Customer;
import com.bootcamp.creditcard.entities.Transaction;
import com.bootcamp.creditcard.repository.AddressRepository;
import com.bootcamp.creditcard.repository.CustomerRepository;
import com.bootcamp.creditcard.repository.TransactionRepository;

@Transactional
@Service("customerService")
public class ICustomerServiceImpl implements ICustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public String addCustomer(Customer customer) {
		Customer newCustomer = customerRepository.save(customer);
		return "Successfully added customer "+newCustomer.getUserId();
	}
	
	@Override
	public String removeCustomer(int custId) {
		customerRepository.deleteById(custId);
		return "Successfully removed customer details by id";
	}
	
	@Override
	public String removeCustomerByName(String custName) {
		customerRepository.deleteByName(custName);
		return "Successfully removed customer details by name";
	}

	@Override
	public Customer updateCustomer(int custId, Customer customer) {
		Customer newCustomer = customerRepository.findById(custId).get();
		newCustomer.setName(customer.getName());
		newCustomer.setEmail(customer.getEmail());
		newCustomer.setContactNo(customer.getContactNo());
		customerRepository.save(newCustomer);
		return newCustomer;
	}

	@Override
	public Optional<Customer> getCustomer(int custId) {
		return customerRepository.findById(custId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Addresses updateCustomerAddress(int custId, Addresses address) {
		Customer oldCustomer = customerRepository.findById(custId).get();
		Addresses addressReference = oldCustomer.getAddresses(); 
		addressReference.setArea(address.getArea());
		addressReference.setCity(address.getCity());
		addressReference.setDoorNo(address.getDoorNo());
		addressReference.setPincode(address.getPincode());
		addressReference.setState(address.getState());
		addressReference.setStreet(address.getStreet());
		addressRepository.save(addressReference);
		return addressReference;
	}

	@Override
	public Optional<Customer> getCustomerByName(String custName) {
		Optional<Customer> customerName =  customerRepository.findByName(custName);
		if(customerName.isPresent())
		   return customerName;
		else
			return null;
	}

//	@Override
//	public String addTransactionByCustomerId(Transaction transaction, int custId) {
//		Customer oldCustomer = customerRepository.findById(custId).get();
//		Transaction newtransaction = transactionRepository.save(transaction);
//		newtransaction.setCustomer(oldCustomer);
////		newtransaction.setCardNumber(transaction.getCardNumber());
////		newtransaction.setAmount(transaction.getAmount());
////		newtransaction.setDescription(transaction.getDescription());
////		newtransaction.setPaymentMethod(transaction.getPaymentMethod());
////		newtransaction.setStatus(transaction.getStatus());
////		transactionRepository.save(newtransaction);
////		customerRepository.saveTransactions(newtransaction, custId);
//		return "successfully transaction added for customerid "+custId;
//	}
}
