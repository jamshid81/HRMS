package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.utiles.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps extends CommonMethods {
	@When("user enters employees {string} and {string}")
	public void user_enters_employees_and(String firstname, String lastname) {
		sendText(addEmp.firstName, firstname);
		sendText(addEmp.lastName, lastname);

	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
		click(addEmp.saveBtn);
	}

	@Then("{string} is added successfully")
	public void is_added_successfully(String employee) {
		String actual = addEmp.nameTag.getText();
		String expected = employee;
		Assert.assertEquals("Employee is not added", expected, actual);
	}

	// this method has hardcode
	@When("user enters employees first name and last name")
	public void user_enters_employees_first_name_and_last_name() {
		sendText(addEmp.firstName, "John");
		sendText(addEmp.lastName, "Smith");

	}

	@When("user deletes employee id")
	public void user_deletes_employee_id() {
		addEmp.employeeId.clear();
	}

	@Then("employee is added successfully")
	public void employee_is_added_successfully() {
		addEmp.nameTag.getText();
	}

	@When("user clicks on create login checkbox")
	public void user_clicks_on_create_login_checkbox() {
		click(addEmp.checkboxLoginDetails);
	}

	@When("user enters login credentials")
	public void user_enters_login_credentials() {
		sendText(addEmp.username, "jawadghazyar1873");
		sendText(addEmp.password, "Afghanistan0093$!");
		sendText(addEmp.confirmPassword, "Afghanistan0093$!");

	}

	@When("user enter employees {string}, {string} and {string}")
	public void user_enter_employees_and(String fName, String mName, String lName) {
		sendText(addEmp.firstName, fName);
		sendText(addEmp.middleName, mName);
		sendText(addEmp.lastName, lName);

	}

	@Then("{string}, {string} and {string} is added successfully")
	public void and_is_added_successfully(String fName, String mName, String lName) {
		String expected = fName + " " + mName + " " + lName;
		String actual = addEmp.nameTag.getText();
		Assert.assertEquals("Employee are not added", expected, actual);

	}

	@When("user enters employee details and click on save then employee is added")
	public void user_enters_employee_details_and_click_on_save_then_employee_is_added(DataTable dataTable) {
		
		List<Map<String, String>> employeeList=dataTable.asMaps();
		
		for (Map<String, String>map:employeeList) {
			String firstname=map.get("FirstName");
			String middlename=map.get("MiddleName");
			String lastname=map.get("LastName");
			sendText(addEmp.firstName, firstname);
			sendText(addEmp.middleName, middlename);
			sendText(addEmp.lastName, lastname);
			
			
		}
		
		throw new io.cucumber.java.PendingException();
	}

}
