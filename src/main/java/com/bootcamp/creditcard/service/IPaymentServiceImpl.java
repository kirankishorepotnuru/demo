package com.bootcamp.creditcard.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.creditcard.entities.Payment;
import com.bootcamp.creditcard.entities.Statement;
import com.bootcamp.creditcard.exceptions.CustomerIdNotFoundException;
import com.bootcamp.creditcard.exceptions.StatementIdNotFoundException;
import com.bootcamp.creditcard.repository.CustomerRepository;
import com.bootcamp.creditcard.repository.IPaymentRepository;
import com.bootcamp.creditcard.repository.IStatementRepository;

@Service
@Transactional
public class IPaymentServiceImpl implements IPaymentService{
	
	@Autowired
	IPaymentRepository paymentRepository;
	
	@Autowired
	IStatementRepository statementRepository;


	@Override
	public String addPaymentByStatementId(Payment payment, int statementId) {
//		if(statementRepository.findById(statementId).get() != null)
//		{
//			Payment newPayment = paymentRepository.findById(payment.getPaymentId()).get();
//			Statement oldStatement = statementRepository.findById(statementId).get();
//			newPayment.setPaymentMethod(payment.getPaymentMethod());
//			newPayment.setDueAmount(oldStatement.getDueAmount());
//			paymentRepository.save(newPayment);
//			return "Successfull payment initiated for statement id "+statementId;
//		}
//		else
//			throw new StatementIdNotFoundException("statement is not found for id:"+statementId);
		return null;
	}

	@Override
	public Payment removePayment(int paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment updatePayment(int paymentId, Payment payment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Payment> getPayment(int paymentId) {
		return paymentRepository.findById(paymentId);
	} 

}
