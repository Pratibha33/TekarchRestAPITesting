package com.test.models;

public class AddUserPOJO {
	private  String accountno;
	private  String departmentno;

	private  String pincode;
	private  String salary;
	
	public AddUserPOJO(String accountno, String departmentno, String pincode, String salary) {
		super();
		this.accountno = accountno;
		this.departmentno = departmentno;
		this.pincode = pincode;
		this.salary = salary;
	}

	//private static String userid;
	
	/*public  String getUserid() {
		return userid;
	}
	public  void setUserid(String userid) {
		AddUserPOJO.userid = userid;
	}*/
	
	public  String getAccountNo() {
		return accountno;
	}
	
	public  String getDeptartmentNo() {
		return departmentno;
	}
	
	public  String getSalary() {
		return salary;
	}
	
	public  String getPincode() {
		return pincode;
	}

	
	

}
