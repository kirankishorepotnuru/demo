package com.bootcamp.creditcard.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bootcamp.creditcard.entities.Customer;
import com.bootcamp.creditcard.entities.Transaction;

@Repository("customerRespo")
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Optional<Customer> findByName(String custName);

	void deleteByName(String custName);
	

}
