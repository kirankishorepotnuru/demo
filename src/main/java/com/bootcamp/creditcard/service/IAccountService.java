package com.bootcamp.creditcard.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.bootcamp.creditcard.entities.Account;

@Service
public interface IAccountService {
	
	//public String addAccount(int CustomerId,Account account);
	public String addAccount(Account account);
	public String removeAccount(int id);
	public Account updateAccount(int id,Account account);
	public Optional<Account> getAccount(int id);
	public List<Account> getAllAccounts();
	//public List<Account> getAccountsByBankName(String accountName);
	//public Optional<Account> getAccountById(long accountId);

}
