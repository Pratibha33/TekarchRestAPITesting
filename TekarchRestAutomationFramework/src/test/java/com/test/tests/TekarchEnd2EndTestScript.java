package com.test.tests;


import java.util.List;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.utils.ExtentReportsUtility;
import com.test.utils.Log4JUtility;
import com.test.helpers.UserServiceHelper;
import com.test.models.UserPOJO;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TekarchEnd2EndTestScript extends UserServiceHelper {
	private static String token;
	protected static Log4JUtility logObject = Log4JUtility.getInstance();
	protected static Logger log;
	protected ExtentReportsUtility report = ExtentReportsUtility.getInstance();
	/*
	 * login test--extract the token create user test--- getAllusers test--- first
	 * record--extract the user id and id update test-- delete test--
	 */
	@BeforeClass
	public static void setBaseUri() {
		RestAssured.baseURI = getBaseURI();
		log = logObject.getLogger();
		
	}

	@Test(priority = 1)
	public static void login() {
		token = getToken();
		log.info("Token generated");

	}

	@Test(priority = 2, enabled = false)
	public static void getUsers() {
		List<UserPOJO> userList = getUserData(token);

	}

	@Test(priority = 3)
	public static void addUsers() {
		Response response = addUserData();
		verifyStatusCode(response, 200);
		log.info("User added");
	}

	@Test(priority = 4)
	public static void updateUser() {

		Response res = updateUserData();
		System.out.println("***********/updateData Response***********************");
		
		res.prettyPrint();
		verifyStatusCode(res, 401);

		verifyStatusMessage(res,"you are not having permission to edit data"); //Update not permitted on Tekarch api
		log.info("Update user test passed");
	}

	@Test(priority = 5)
	public static void deleteUser() {
		Response res = deleteUserData();
		System.out.println("***********/deleteData Response***********************");
		res.prettyPrint();
		verifyStatusCode(res, 200);
		verifyStatusMessage(res,"success");
		log.info("Delete useSuccessr test passed");
	}

	//Data to get all accounts that I created in the past so they exist under my userID
	@Test(priority = 6, enabled = false)
	public void getAllAccountNoForUser() {
		RestAssured.baseURI = getBaseURI();
		token = getToken();
		getUserForId();

	}

}
