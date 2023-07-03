package com.test.models;

public class UpdateUserPOJO {
	public UpdateUserPOJO(String accountno, int departmentno, int salary, int pincode, String userid,   String id) {
		super();
		this.accountno = accountno;
		this.departmentno = departmentno;
		this.salary = salary;
		this.pincode = pincode;
		this.userid = userid;
		this.id = id;
	}

	private String accountno;
	private int departmentno;
	private String id;
	private int pincode;
	private int salary;
	private String userid;

	public String getid() {
		return id;
	}

	public String getUserID() {
		return userid;
	}

	public String getAccountNo() {
		return accountno;
	}

	public int getDeptartmentNo() {
		return departmentno;
	}

	public int getSalary() {
		return salary;
	}

	public int getPincode() {
		return pincode;
	}

}
