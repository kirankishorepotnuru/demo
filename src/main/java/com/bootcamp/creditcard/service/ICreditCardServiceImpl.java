package com.bootcamp.creditcard.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.creditcard.entities.CreditCard;
import com.bootcamp.creditcard.repository.ICreditCardRepository;

@Transactional
@Service
public class ICreditCardServiceImpl implements ICreditCardService{

	@Autowired
	ICreditCardRepository creditCardRepository;
	
	@Override
	public String addCreditCard(CreditCard creditCard) {
		CreditCard newCreditCard = creditCardRepository.save(creditCard);
		return "Successfully added new CreditCard "+newCreditCard.getCreditcardId();
	}

	@Override
	public String removeCreditCard(int creditCardId) {
		creditCardRepository.deleteById(creditCardId);
		return "Successfully removed creditCard details by id";
	}

	@Override
	public CreditCard updateCreditCard(int creditCardId, CreditCard CreditCard) {
		CreditCard newCreditCard = creditCardRepository.findById(creditCardId).get();
		newCreditCard.setBankName(CreditCard.getBankName());
		newCreditCard.setCardName(CreditCard.getCardName());
		newCreditCard.setCardNumber(CreditCard.getCardNumber());
		newCreditCard.setCardType(CreditCard.getCardType());
		creditCardRepository.save(newCreditCard);
		return newCreditCard;
	}

	@Override
	public Optional<CreditCard> getCreditCard(int creditCardId) {
		return creditCardRepository.findById(creditCardId);
	}

	@Override
	public List<CreditCard> getAllCreditCards() {
		List<CreditCard> creditCard = (List<CreditCard>)creditCardRepository.findAll();
		return creditCard;
	}
	

}
