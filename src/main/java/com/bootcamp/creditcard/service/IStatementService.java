package com.bootcamp.creditcard.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bootcamp.creditcard.entities.Statement;
import com.bootcamp.creditcard.entities.Transaction;


@Service
public interface IStatementService {

	public String removeStatement(int statementId);
	public Statement updateStatement(int statementId, Statement statement);
	public Optional<Statement> getStatement(int statementId);
	public List<Statement> getAllStatements(int customerId);
	public Statement generateStatementByCustomerId(int customerid, int month, int year);
	public List<Statement> getBilledStatement(int customerId, LocalDate startingDate, LocalDate endingDate);
	public List<Transaction> getUnBilledStatement(int customerId);


}
