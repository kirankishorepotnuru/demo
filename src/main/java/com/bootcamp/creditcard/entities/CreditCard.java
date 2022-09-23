package com.bootcamp.creditcard.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CreditCard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int creditcardId;
	
	@NotEmpty(message="cardName Should Not Be Empty")
	private String cardName;
	
	@NotEmpty(message="cardType Should Not Be Empty")
	private String cardType;
	
	@NotEmpty(message="cardNumber Should Not Be Empty")
	private String cardNumber;
	
	@Temporal(TemporalType.DATE)
	private Date expireDate = new Date(System.currentTimeMillis());
	
	@NotEmpty(message="bankName Should Not Be Empty")
	private String bankName;
	
	@OneToOne(mappedBy = "creditCard")
	@JsonIgnore
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	public int getCreditcardId() {
		return creditcardId;
	}
	public void setCreditcardId(int creditcardId) {
		this.creditcardId = creditcardId;
	}
}
