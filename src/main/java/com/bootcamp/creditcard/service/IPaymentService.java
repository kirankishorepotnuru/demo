package com.bootcamp.creditcard.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bootcamp.creditcard.entities.Payment;



@Service
public interface IPaymentService {
	public String addPaymentByStatementId(Payment payment, int statementId);
	public Payment removePayment(int paymentId);
	public Payment updatePayment(int paymentId, Payment payment);
	public Optional<Payment> getPayment(int paymentId);

}
