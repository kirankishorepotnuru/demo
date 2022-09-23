package com.bootcamp.creditcard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.creditcard.entities.Transaction;

@Repository("transactionRespo")
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	@Query("select t from Transaction t where t.customer.userId = :customerId")
	public List<Transaction> getTransactionByCustomerId(@Param("customerId") int customerId);

}
