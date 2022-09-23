package com.bootcamp.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.creditcard.entities.CreditCard;


@Repository
public interface ICreditCardRepository extends JpaRepository<CreditCard, Integer>{

}
