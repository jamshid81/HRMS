package com.hrms.steps;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.hrms.utiles.CommonMethods;
import com.hrms.utiles.DBUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DbAndUiNameValidition extends CommonMethods {

	String UIname;

	@Then("user verifies table is displayed")
	public void user_verifies_table_is_displayed() {
		empList.firstName.isDisplayed();
		UIname = empList.firstName.getText();
		System.out.println("From UI: " + UIname);
		Assert.assertTrue("FistName is not displayed", empList.firstName.isDisplayed());

	}

	@And("user get firstName {string} from table and user get firstName from db and Validate")
	public void user_get_firstName_from_table_and_user_get_firstName_from_db_and_Validate(String firstName) {
		
		String expected = firstName;
		String dfirstName = null;

		// Getting data from DataBase
//		DBUtils.getConnection();
		String sqlQuery = "select emp_firstname from hs_hr_employees where employee_id = 730462";
		List<Map<String, String>> mapOfData = DBUtils.storeDataFromDB(sqlQuery);
		System.out.println("Map="+mapOfData);

		
		if(UIname.contains(expected)) {
			UIname = UIname.replaceAll("\\s.*", "").trim();
			
		}
		
		System.out.println("Only FirstName = " + UIname);
		
		for (Map<String, String> data : mapOfData) {
			for (Entry<String, String> entry : data.entrySet()) {
				String dbColName= entry.getKey();
				dfirstName = entry.getValue();
				System.out.println("dfirstName = "+dfirstName);
				if (dfirstName.contentEquals(UIname)){
					break;
				}
			}
		Assert.assertEquals("LastName missmatch", UIname, dfirstName);
		}
		DBUtils.closeConnection();
	}

}
