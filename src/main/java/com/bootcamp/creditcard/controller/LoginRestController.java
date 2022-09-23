package com.bootcamp.creditcard.controller;

import static org.mockito.ArgumentMatchers.booleanThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.creditcard.entities.User;
import com.bootcamp.creditcard.service.IUserService;

@RestController
public class LoginRestController {
	
	@Autowired
	IUserService userService;
	
	@PostMapping("/users")
	public String registerUser(@RequestBody User user)
	{
		return userService.register(user);
	}
	
	@PutMapping("/users/userId/{userId}/password/{password}")
	public User changePassword(@PathVariable("userId") int userId,@PathVariable("password") String password)
	{
		User newUser=userService.changePassword(userId, password);
		if(newUser!=null)
		{
			return newUser;
		}
		else
		{
			return null;
		}
	}
	
	@GetMapping("/users/login")
	public String signIn(@RequestBody User user)
	{
		boolean currentUser = userService.signIn(user);
		if(currentUser)
		{
			return "user logged in";
		}
		else
			return "invalid credentials";
	}
	
	@GetMapping("/users/logout")
	public String signout(@RequestBody User user)
	{
		boolean statusOfCurrentUser = userService.signOut(user);
		if(statusOfCurrentUser)
			return "Successfully Logout";
		else
			return "invalid user";
	}
	
	
}
