package com.bootcamp.creditcard.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transId;
	@NotEmpty(message="cardNumber Should Not Be Empty")
	private String cardNumber;

	private LocalDate tranDate;
	
	@NotEmpty(message="status Should Not Be Empty")
	private String status;
	@Min(50)
	private double amount;
	@NotEmpty(message="paymentMethod Should Not Be Empty")
	private String paymentMethod;
	@NotEmpty(message="description Should Not Be Empty")
	private String description;
	@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "foreign_transactionId")
	@JsonIgnore
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foreign_paymentId")
	private Payment payment;

	public LocalDate getTranDate() {
		return tranDate;
	}

	public void setTranDate(LocalDate tranDate) {
		this.tranDate = tranDate;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
