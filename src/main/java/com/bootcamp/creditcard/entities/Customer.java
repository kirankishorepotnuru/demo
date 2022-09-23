package com.bootcamp.creditcard.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.web.util.pattern.PatternParseException.PatternMessage;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	@Id
	private int userId;

	@NotEmpty(message="name Should Not Be Empty")
	private String name;

	@NotEmpty(message="email Should Not Be Empty")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email;

	@NotEmpty(message="contactNo Should Not Be Empty")
	private String contactNo;

	private LocalDate dob;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foreign_addressId")
	private Addresses addresses;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foreign_userId")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foreign_creditcardId")
	private CreditCard creditCard;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foreign_accountId")
	private Account account;
	
    @OneToMany(targetEntity = Transaction.class,cascade = CascadeType.ALL)
    @JoinColumn(name="foreign_transactionId", referencedColumnName = "userId")
	private List<Transaction> transactions;
    
    
    @OneToMany(targetEntity = Statement.class,cascade = CascadeType.ALL)
    @JoinColumn(name="foreign_statementId", referencedColumnName = "userId")
	private List<Statement> statements;

	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public Addresses getAddresses() {
		return addresses;
	}

	public void setAddresses(Addresses address) {
		this.addresses = address;
	}
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}	
}
