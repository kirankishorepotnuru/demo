package com.bootcamp.creditcard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.creditcard.entities.Statement;


@Repository
public interface IStatementRepository extends JpaRepository<Statement, Integer>{
	@Query("select t from Statement t where t.customer.userId = :customerId")
	public List<Statement> getStatementByCustomerId(@Param("customerId") int customerId);

} 
