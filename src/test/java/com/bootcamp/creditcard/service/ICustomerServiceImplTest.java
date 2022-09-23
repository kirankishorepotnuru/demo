package com.bootcamp.creditcard.service;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.bootcamp.creditcard.entities.Customer;
import com.bootcamp.creditcard.repository.CustomerRepository;

@SpringBootTest
public class ICustomerServiceImplTest {
	@Mock
	CustomerRepository customerRepository;
	
	@Test
	void testGetAllCustomers() {
		List<Customer> actual = new ArrayList<>();
		when(customerRepository.findAll()).thenReturn(actual);
		assertIterableEquals(new ArrayList<Customer>(), actual);
	}
}
