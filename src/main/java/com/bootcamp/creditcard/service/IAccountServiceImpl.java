package com.bootcamp.creditcard.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.creditcard.entities.Account;
import com.bootcamp.creditcard.entities.Customer;
import com.bootcamp.creditcard.exceptions.CustomerIdNotFoundException;
import com.bootcamp.creditcard.repository.CustomerRepository;
import com.bootcamp.creditcard.repository.IAccountRepository;

@Transactional
@Service
public class IAccountServiceImpl implements IAccountService {
    
	@Autowired
	IAccountRepository accountrepo;
	
	@Autowired
	CustomerRepository customerRepository;
	
	/*@Override
	public String addAccount(int customerId,Account account) {
		if(customerRepository.findById(customerId).get() != null)
		{
			Customer oldCustomer = customerRepository.findById(customerId).get();
			Account newAccount = new Account();
			newAccount.setAccountName(account.getAccountName());
			newAccount.setBalance(account.getBalance());
			newAccount.setAccountType(account.getAccountType());
			newAccount.setCustomer(oldCustomer);
		    newAccount=accountrepo.save(account);
		    return "successfully account added for customerId "+customerId+" Account Id Is"+newAccount.getAccountId();
		}
		else
		{
			throw new CustomerIdNotFoundException("Customer is not found for id:"+customerId);
		}
       // accountrepo.save(account);
		//return "successfully added";
	}*/
	@Override
	public String addAccount(Account account) {
		
        accountrepo.save(account);
		return "successfully added";
	}

	@Override
	public String removeAccount(int id) {
        accountrepo.deleteById(id);
		return null;
	}

	@Override
	public Account updateAccount(int id, Account account) {
        Account newAccount = accountrepo.findById(id).get();
      //  newAccount.setAccountId(account.getAccountId());
        newAccount.setAccountName(account.getAccountName());
        newAccount.setBalance(account.getBalance());
        newAccount.setAccountType(account.getAccountType());
		accountrepo.save(newAccount);
		return newAccount;
	}

	@Override
	public Optional<Account> getAccount(int id) {
       return accountrepo.findById(id);
	}

	@Override
	public List<Account> getAllAccounts() {
        //List<Account> yacc=accountrepo.findAll();
		return accountrepo.findAll();
	}

	/*@Override
	public List<Account> getAccountsByBankName(String accountName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Account> getAccountById(long accountId) {
		// TODO Auto-generated method stub
		return accountrepo.findById(accountId);
	}*/

}
