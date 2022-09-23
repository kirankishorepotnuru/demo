package com.bootcamp.creditcard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bootcamp.creditcard.entities.CreditCard;


@Service
public interface ICreditCardService {
	public String addCreditCard(CreditCard creditCard);
	public String removeCreditCard(int creditCardId);
	public CreditCard updateCreditCard(int creditCardId, CreditCard creditCard);
	public Optional<CreditCard> getCreditCard(int creditCardId);
	public List<CreditCard> getAllCreditCards();
}
