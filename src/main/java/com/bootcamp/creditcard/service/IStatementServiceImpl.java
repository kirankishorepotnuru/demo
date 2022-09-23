package com.bootcamp.creditcard.service;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.creditcard.entities.Customer;
import com.bootcamp.creditcard.entities.Statement;
import com.bootcamp.creditcard.entities.Transaction;
import com.bootcamp.creditcard.exceptions.CustomerIdNotFoundException;
import com.bootcamp.creditcard.exceptions.StatementIdNotFoundException;
import com.bootcamp.creditcard.repository.CustomerRepository;
import com.bootcamp.creditcard.repository.IStatementRepository;
import com.bootcamp.creditcard.repository.TransactionRepository;


@Transactional
@Service
public class IStatementServiceImpl implements IStatementService {
	
	@Autowired
	IStatementRepository statementrepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public Statement generateStatementByCustomerId(int customerid, int month, int year) {	
		if(customerRepository.findById(customerid).get() != null)
		{
			List<Transaction> oldTransactions = transactionRepository.getTransactionByCustomerId(customerid);
			Customer oldCustomer = customerRepository.findById(customerid).get();
			Statement newStatement = new Statement();
			LocalDate billingDate = LocalDate.of(year, month, 15);
			newStatement.setBillingDate(billingDate); 
			LocalDate tempDueDate = billingDate.plusDays(45);
			newStatement.setDuedate(tempDueDate);			
			double totalAmount = 0;
			for (Transaction transaction : oldTransactions) 
			{
				if(transaction.getTranDate().getMonth() == billingDate.getMonth())
				{
					totalAmount += transaction.getAmount();
				}
			}
			newStatement.setDueAmount(totalAmount);
			newStatement.setCustomer(oldCustomer);
			statementrepository.save(newStatement);
//			Customer oldCustomer = customerRepository.findById(customerid).get();
//			Statement newStatement = statementrepository.save(statement);
//			newStatement.setCustomer(oldCustomer);
			//return "successfully statement generated for customerid "+customerid;
			return newStatement;
		}
		else
			throw new CustomerIdNotFoundException("Customer is not found for id:"+customerid);
	}

	@Override
	public Statement updateStatement(int stateId, Statement state) {
//		Statement newStatement = statementrepo.findById(stateId).get();
//		newStatement.setDueAmmount(Statement.getDueAmmount());
//		newStatement.setBillingDate(Statement.getBillingDate());
//		newStatement.setDuedate(Statement.getduedate());
//		newStatement.setCustomer(Statement.getCustomer());
//		statementrepo.save(newStatement);
//		return newStatement;
		return null;
	}

	@Override
	public Optional<Statement> getStatement(int statementId) {
		return statementrepository.findById(statementId);
	}

	@Override
	public List<Statement> getAllStatements(int customerId) {
		
		if((customerRepository.findById(customerId)).get() != null)
		{
			List<Statement> statement = (List<Statement>)statementrepository.findAll();
			return statement;
		}
		else
			throw new CustomerIdNotFoundException("Customer is not found for id:"+customerId);
	}
	@Override
	public String removeStatement(int stateId) {
//		statementrepo.deleteById(stateId);
//		return "Successfully removed creditCard details by id";
		return null;
	}

	@Override
	public List<Statement> getBilledStatement(int customerId, LocalDate startingDate, LocalDate endingDate)
	{
		if((customerRepository.findById(customerId)).get() != null)
		{
			List<Statement> allStatements = statementrepository.getStatementByCustomerId(customerId);
			List<Statement> billedStatements = new ArrayList<Statement>();
			
			for (Statement statement : allStatements) {
				if(statement.getBillingDate().isAfter(startingDate) && statement.getBillingDate().isBefore(endingDate))
				{
					billedStatements.add(statement);
				}
			}
			return billedStatements;
			
		}
		else
			throw new CustomerIdNotFoundException("Customer is not found for id:"+customerId);
	}

	@Override
	public List<Transaction> getUnBilledStatement(int customerId)
	{
		if((customerRepository.findById(customerId)).get() != null)
		{
			List<Transaction> allTransactions = transactionRepository.getTransactionByCustomerId(customerId);
			List<Transaction> unBilledTransactions = new ArrayList<Transaction>();
			LocalDate currentDate = LocalDate.now();
			LocalDate startingDate = LocalDate.of(currentDate.getYear(), currentDate.getMonthValue(), 15);
			for (Transaction transaction : allTransactions) {
				if(transaction.getTranDate().isAfter(startingDate) && transaction.getTranDate().isBefore(currentDate))
				{
					unBilledTransactions.add(transaction);
				}
			}
			return unBilledTransactions;
		}
		else
			throw new CustomerIdNotFoundException("Customer is not found for id:"+customerId);
	}

}
