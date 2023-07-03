package com.test.models;

public class UserPOJO {

	public UserPOJO(String token, String userid) {
		super();
		this.token = token;
		this.userid = userid;
	}

	private String token;
	private String userid;

	public String getToken() {
		return token;
	}

	public String getUserid() {
		return userid;
	}

}
