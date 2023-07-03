package com.test.helpers;

import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.test.constants.EndPoints;
import com.test.models.AddUserPOJO;
import com.test.models.DeleteUserPOJO;
import com.test.models.LoginUserPOJO;
import com.test.models.UpdateUserPOJO;
import com.test.models.UserPOJO;
import com.test.utils.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class UserServiceHelper {
	private static Response response;
	private static String token = null;
	private static Utils prop = new Utils();
	public static Properties load = prop.loadFile();
	public static List<Object> listID2;

	public static String getBaseURI() {

		String baseURI = load.getProperty("tekarch.base.url");
		return baseURI;
	}

	public static Response loginToApplication() {

		// data.setUsername("divyashree@ta.com");
		// data.setPassword("divya@123");

		String uname = load.getProperty("login.userid");
		String pwd = load.getProperty("login.password");
		LoginUserPOJO data = new LoginUserPOJO(uname, pwd); // create a plain old java object :POJO
		System.out.println("Base uri is " + RestAssured.baseURI + EndPoints.LOGIN);
		response = RestAssured.given().contentType(ContentType.JSON).body(data).when()
				.post(EndPoints.LOGIN);
		response.then().statusCode(201).contentType(ContentType.JSON).time(lessThan(5000L));
		return response;
		// extractedToken = res
	}

	public static String getToken() {
		response = loginToApplication();
		token = response.jsonPath().get("[0].token");
		return token;
	}

	public static List<UserPOJO> getUserData(String token) {
		Header header = new Header("token", token);
		response = RestAssured.given().header(header).when().get(EndPoints.GET_DATA);
		listID2 = response.body().jsonPath().getList("findAll{it.userid == 'fMZY0ai5BCbdnZBCj4p4'}.id");
		UserPOJO[] userArray = response.as(UserPOJO[].class);
		List<UserPOJO> list = Arrays.asList(userArray);
		response.then().statusCode(200);
		return list;

	}
	
	public static List<Object> getValidId(Header ob ) {
		Response res = RestAssured.given().contentType(ContentType.JSON).header(ob).when().get("getdata");

		res.then().statusCode(200);
		List<Object> listID2 = res.body().jsonPath().getList("findAll{it.userid == 'fMZY0ai5BCbdnZBCj4p4'}.id");
		return listID2;

	}

	public static Response addUserData() {
		Header header = new Header("token", token);
		AddUserPOJO user = ReusableMethods.getUserDataToAdd();
		response = RestAssured.given().contentType(ContentType.JSON).header(header).body(user).when()
				.post(EndPoints.ADD_DATA);

		return response;
	}

	public static Response updateUserData() {
		Header header = new Header("token", token);
		listID2 = getValidId(header);
		String id = (String) listID2.get(0);
		//Id keeps changing and needs to be passed as a parameter otherwise Update throws 401 code: no permission
		UpdateUserPOJO user = ReusableMethods.getUserDataToUpdate(id);
		response = RestAssured.given().contentType(ContentType.JSON).body(user).header(header).when()
				.put(EndPoints.UPDATE_DATA);

		return response;
	}

	public static Response deleteUserData() {
		Header header = new Header("token", token);
		DeleteUserPOJO deleteUser = ReusableMethods.getUserDataToDelete();
		response = RestAssured.given().contentType(ContentType.JSON).header(header).body(deleteUser)
				.delete(EndPoints.DELETE_DATA);

		return response;
	}

	public int getStatusCode(Response res) {
		return res.getStatusCode();
	}

	public String getContentType(Response res) {
		return res.getContentType();
	}

	public static void verifyStatusCode(Response res, int statCode) {
		res.then().statusCode(statCode);

	}

	public static void verifyStatusMessage(Response res,String message) {
		res.then().body("status", is(message));
	}

	public static void getUserForId() {
		Header ob = new Header("token", token);
		Response res = RestAssured.given().contentType(ContentType.JSON).header(ob).when().get("getdata");

		res.then().statusCode(200);
		List<Object> listID = res.body().jsonPath().getList("findAll{it.userid == 'fMZY0ai5BCbdnZBCj4p4'}.accountno");
		List<Object> listID2 = res.body().jsonPath().getList("findAll{it.userid == 'fMZY0ai5BCbdnZBCj4p4'}.id");
		for (Object str : listID) {
			System.out.println("account no for the userid=fMZY0ai5BCbdnZBCj4p4 are:" + str);
		}

		for (Object str : listID2) {
			System.out.println("id no for the userid=fMZY0ai5BCbdnZBCj4p4 are:" + str);
		}
	}
}
