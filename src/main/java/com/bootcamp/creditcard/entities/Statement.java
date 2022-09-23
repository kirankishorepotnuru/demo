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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Statement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int statementId;
	//@Min(100)
	private double dueAmount;

	private LocalDate billingDate;

	private LocalDate duedate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foreign_statementId")
	@JsonIgnore
	private Customer customer;	

	public int getStatementId() {
		return statementId;
	}

	public void setStatementId(int statementId) {
		this.statementId = statementId;
	}

	public double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}


	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	public LocalDate getDuedate() {
		return duedate;
	}

	public void setDuedate(LocalDate duedate) {
		this.duedate = duedate;
	}


	

}
