package com.bootcamp.creditcard.service;

import org.springframework.stereotype.Service;

import com.bootcamp.creditcard.entities.User;

@Service
public interface IUserService {
	public String register(User user);
//	public boolean signIn(User user);
	public boolean signOut(User user);
	public User changePassword(int id,String password);

	public boolean signIn(User user);

}
