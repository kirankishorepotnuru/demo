package com.bootcamp.creditcard.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.creditcard.entities.CreditCard;
import com.bootcamp.creditcard.exceptions.CreditCardIdNotFoundException;
import com.bootcamp.creditcard.response.ResponseInfo;
import com.bootcamp.creditcard.service.ICreditCardService;

@RestController
public class CreditCardController {
	
	@Autowired
	ICreditCardService creditCardService;
	
	@PostMapping("/creditCards")
	public ResponseEntity<ResponseInfo> addCreditCard(@Valid @RequestBody CreditCard creditCard,HttpServletRequest request)
	{
		String message = creditCardService.addCreditCard(creditCard);
		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),message,request.getRequestURI());
		ResponseEntity<ResponseInfo> responseEntity=new ResponseEntity<>(responseInfo,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@DeleteMapping("/creditCards/{creditCardId}")
	public String removeCreditCard(@PathVariable("creditCardId") int creditCardId)
	{
		Optional<CreditCard> creditCardList = creditCardService.getCreditCard(creditCardId);
		if(creditCardList.isPresent())
		{
			creditCardService.removeCreditCard(creditCardId);
			return "Credit Card Remove Successfully of id "+creditCardId;
		}
		else
		{
			throw new CreditCardIdNotFoundException("CreditCard is not found for id: "+creditCardId);
		}
	}
	
	@GetMapping("/creditCards")
	public List<CreditCard> getAllCreditCards()
	{
		return creditCardService.getAllCreditCards();
	}
	
	@GetMapping("/creditCards/{creditCardId}")
	public CreditCard getCreditCard(@PathVariable("creditCardId") int creditCardId)
	{
		Optional<CreditCard> creditCard = creditCardService.getCreditCard(creditCardId);
	    if(creditCard.isPresent())
	    {
	    	return creditCard.get();
	    }
	    else
	    {
	    	throw new CreditCardIdNotFoundException("CreditCard is not found for id: "+creditCardId);
	    }	
	}
	
	
	@PutMapping("/creditCards/{creditCardId}")
	public CreditCard updateCreditCard(@PathVariable("creditCardId") int creditCardId,@Valid @RequestBody CreditCard creditCard)
	{
		CreditCard newCreditCard = creditCardService.updateCreditCard(creditCardId, creditCard);
		if(newCreditCard!=null)
		{
			return newCreditCard;
		}
		else
		{
			throw new CreditCardIdNotFoundException("CusCreditCard is not found for id: "+newCreditCard.getCreditcardId());
		}
	}
}
