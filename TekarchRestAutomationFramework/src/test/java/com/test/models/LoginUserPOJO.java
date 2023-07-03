package com.test.models;

public class LoginUserPOJO {

	public LoginUserPOJO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
