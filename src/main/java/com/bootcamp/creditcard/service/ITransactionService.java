package com.bootcamp.creditcard.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.bootcamp.creditcard.entities.Transaction;

@Service
public interface ITransactionService {
	public String removeTransaction(int transactionId);
	public Transaction updateTransaction(int transactionId, Transaction transaction);
	public Optional<Transaction> getTransaction(int transactionId);
	public String addTransactionByCustomerId(Transaction transaction, int custId);
	public List<Transaction> getAllTransactions(int customerId);
	public List<Transaction> getTransactionsEveryMonth(int customerId, LocalDate month);

}
