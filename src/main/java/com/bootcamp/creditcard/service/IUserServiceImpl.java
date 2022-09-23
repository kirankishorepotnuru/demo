package com.bootcamp.creditcard.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.creditcard.entities.User;
import com.bootcamp.creditcard.repository.CustomerRepository;
import com.bootcamp.creditcard.repository.IUserRepository;

@Transactional
@Service
public class IUserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepo;
	
	@Autowired
	CustomerRepository custRepo;
	
	@Override
	public String register(User user) {
	    User obj=userRepo.save(user);
		return "Successfully registered";
	}

	@Override
	public User changePassword(int id, String password) {
		User obj=userRepo.findById(id).get();
		obj.setPassword(password);
		return obj;
	}


	@Override
	public boolean signOut(User user) {
		Optional<User> checkUser = userRepo.findById(user.getUserId());
		if(checkUser.isPresent())
		{
			User dbUser = checkUser.get();
			if(user.getPassword().equals(dbUser.getPassword()) && user.getRole().equals(dbUser.getRole()))
			{
				return user.isActive();
			}
		}
		return false;

	}

	@Override
	public boolean signIn(User user) {
		Optional<User> checkUser = userRepo.findById(user.getUserId());
		if(checkUser.isPresent())
		{
			User dbUser = checkUser.get();
			if(user.getPassword().equals(dbUser.getPassword()) && user.getRole().equals(dbUser.getRole()))
			{
				user.setActive(true);
				return user.isActive();
			}
		}
		return false;
	}

	

	

}
