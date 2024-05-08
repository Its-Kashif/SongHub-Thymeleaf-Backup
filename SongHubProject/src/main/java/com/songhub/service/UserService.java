package com.songhub.service;

import com.songhub.entity.User;

public interface UserService {

	void saveUser(User user);

	boolean validateCredential(String email, String password);

    String getRole(String email);
    
    //This method is called by payment controller
	User getUser(String mail);

	//This method is called by payment controller
	void updateUser(User user);

	boolean isPremium(String email);

}
