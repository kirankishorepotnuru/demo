package com.bootcamp.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.creditcard.entities.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {
	
	//Optional<Account> getAccountByBankName(String accountName);

}
