package com.songhub.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songhub.entity.User;
import com.songhub.repository.UserRepository;
import com.songhub.service.UserService;

@Service
public  class UserServiceImplementation implements UserService {
	
	@Autowired
	UserRepository userRepo;

	@Override
	public void saveUser(User user) {
		Optional<User> existingUser=userRepo.findByEmail(user.getEmail());
		if(existingUser.isPresent()) {
			System.out.println("Duplicate Entry");
			
		}
		else {
			userRepo.save(user);
		}
		
	}

	@Override
	public boolean validateCredential(String email, String password) {
		Optional<User> user=userRepo.findByEmail(email);
		if(user.isPresent()) {
			User validUser=user.get();
			if(validUser.getPassword().equals(password)) {
				return true;
			}	
		}
		return false;	
	}

	@Override
	public String getRole(String email) {
		Optional<User> user = userRepo.findByEmail(email);
		return user.get().getRole();
		
	}
	
	
	
//Implementation of the user that called from payment controller 
	@Override
	public User getUser(String mail) {
		
		Optional<User> user=userRepo.findByEmail(mail);
		return user.orElse(null);
	}

//Implementation of the user that called from payment controller 
	@Override
	public void updateUser(User user) {
		userRepo.save(user);
		
	}

	@Override
	public boolean isPremium(String email) {
		Optional<User> user=userRepo.findByEmail(email);
		if(user.isPresent()) {
			User existingUser=user.get();
			return existingUser.isPremium();
		}
		return false;
	}



}
