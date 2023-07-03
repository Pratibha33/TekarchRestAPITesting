package com.test.helpers;

import com.test.models.AddUserPOJO;
import com.test.models.DeleteUserPOJO;
import com.test.models.UpdateUserPOJO;

public class ReusableMethods {

	public static AddUserPOJO addUser;
	public static UpdateUserPOJO updateUser;
	public static DeleteUserPOJO deleteUser;

	public static AddUserPOJO getUserDataToAdd() {
		addUser = new AddUserPOJO("TA-DATADOG", "3", "333", "411038");

		// addUser.setUserid("fMZY0ai5BCbdnZBCj4p4");
		return addUser;
	}

	public static UpdateUserPOJO getUserDataToUpdate(String id) {

		updateUser = new UpdateUserPOJO("TA-DATADOG", 5,333,411038,"fMZY0ai5BCbdnZBCj4p4",id);
	
		return updateUser;
	}

	public static DeleteUserPOJO getUserDataToDelete() {

		deleteUser = new DeleteUserPOJO("OTWwNW49G4sIeGoQT3G4", "fMZY0ai5BCbdnZBCj4p4");

		return deleteUser;

	}

}
