package com.bootcamp.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.creditcard.entities.Addresses;

@Repository("addressRespo")
public interface AddressRepository extends JpaRepository<Addresses, Integer> {

}
