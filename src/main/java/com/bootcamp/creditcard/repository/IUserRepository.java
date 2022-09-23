package com.bootcamp.creditcard.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.creditcard.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
     Optional<User> findByPassword(String password);
}
