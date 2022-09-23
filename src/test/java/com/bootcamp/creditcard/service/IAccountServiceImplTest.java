package com.bootcamp.creditcard.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bootcamp.creditcard.entities.Account;
import com.bootcamp.creditcard.repository.IAccountRepository;

@SpringBootTest
class IAccountServiceImplTest {
	
	@Mock
	IAccountRepository repository;

    @Test
	void testGetAllAccounts() {
		List<Account> actual=new ArrayList<>();
		when(repository.findAll()).thenReturn(actual);
		
		assertIterableEquals(new ArrayList<Account>(),actual);
		
	}

}
