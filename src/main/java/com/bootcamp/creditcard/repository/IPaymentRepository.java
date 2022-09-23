package com.bootcamp.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.creditcard.entities.Payment;

@Repository("paymentRepository")
public interface IPaymentRepository extends JpaRepository<Payment, Integer> 
{

}
