package com.test.models;

public class DeleteUserPOJO {

	public DeleteUserPOJO(String id, String userid) {

		super();
		this.id = id;
		this.userid = userid;
	}

	public String getId() {
		return id;
	}

	public String getUserid() {
		return userid;
	}

	private String id;
	private String userid;

}
