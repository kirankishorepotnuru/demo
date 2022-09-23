package com.bootcamp.creditcard.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.creditcard.entities.Customer;
import com.bootcamp.creditcard.entities.Payment;
import com.bootcamp.creditcard.entities.Transaction;
import com.bootcamp.creditcard.exceptions.CustomerIdNotFoundException;
import com.bootcamp.creditcard.exceptions.TransactionIdNotFoundException;
import com.bootcamp.creditcard.repository.CustomerRepository;
import com.bootcamp.creditcard.repository.IPaymentRepository;
import com.bootcamp.creditcard.repository.TransactionRepository;

@Transactional
@Service
public class ITransactionServicesImpl implements ITransactionService{

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired 
	CustomerRepository customerRepository;
	
	@Autowired
	IPaymentRepository paymentRepository;
	
	@Override
	public String addTransactionByCustomerId(Transaction transaction, int custId) {
		if(customerRepository.findById(custId).get() != null)
		{
			Customer oldCustomer = customerRepository.findById(custId).get();
		
			Payment newPayment = new Payment();
			newPayment.setPaymentMethod(transaction.getPaymentMethod());
			newPayment.setDueAmount(transaction.getAmount());
			newPayment.setTransaction(transaction);
			transaction.setCustomer(oldCustomer);
			transaction.setPayment(newPayment);
			Transaction newtransaction = transactionRepository.save(transaction);
			
			return "successfully transaction added for customerid "+custId+"transaction id is "+newtransaction.getTransId();
		}
		else
			throw new CustomerIdNotFoundException("Customer is not found for id:"+custId);
	}

	@Override
	public String removeTransaction(int transactionId) {
		if(transactionRepository.findById(transactionId) != null)
		{
			return "Successfully Transaction removed"+transactionId;
		}
		else
			throw new TransactionIdNotFoundException("Customer is not found for id:"+transactionId);
	}


	@Override
	public Transaction updateTransaction(int transactionId, Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Transaction> getTransaction(int transactionId) {
		return transactionRepository.findById(transactionId);
	}

	@Override
	public List<Transaction> getAllTransactions(int customerId) {
		if((customerRepository.findById(customerId)).get() != null)
		{
			List<Transaction> transaction = (List<Transaction>)transactionRepository.findAll();
			return transaction;
		}
		else
			throw new CustomerIdNotFoundException("Customer is not found for id:"+customerId);
	}
	
	@Override
	public List<Transaction> getTransactionsEveryMonth(int customerId, LocalDate month)
	{
		if((customerRepository.findById(customerId)).get() != null)
		{
			month.getDayOfMonth();
		}
		return null;
	}

}
