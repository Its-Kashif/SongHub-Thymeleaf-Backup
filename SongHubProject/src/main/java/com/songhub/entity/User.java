package com.songhub.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id;
	
	@jakarta.validation.constraints.NotEmpty(message = "Username cannot be empty")
	private String username;
	@jakarta.validation.constraints.NotEmpty(message="email cannot be empty")
	private String email;
	@jakarta.validation.constraints.NotEmpty(message="email cannot be empty")
	private String password;
	private String phone_number;
	private String gender;
	private String role;
	private String address;
	private boolean premium;

	public User() {
		super();
	}

	public User(int user_id,String username, String email, String password, String phone_number, String gender, String role,
			String address, boolean premium) {
		super();
		this.user_id =user_id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
		this.gender = gender;
		this.role = role;
		this.address = address;
		this.premium= premium;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	@Override
	public String toString() {
		return "User [user_id="+user_id +" username=" + username + ", email=" + email + ", password=" + password + ", phone_number="
				+ phone_number + ", gender=" + gender + ", role=" + role + ", address=" + address +" premium"+premium+ "]";
	}

}
