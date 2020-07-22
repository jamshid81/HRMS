package com.hrms.steps;

import com.hrms.utiles.CommonMethods;
import com.hrms.utiles.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearchSteps extends CommonMethods {

	@Given("user navigate to HRMS")
	public void user_navigate_to_HRMS() {
		setup();
	}

	@Given("user is logged in with valid Admin credintials")
	public void user_is_logged_in_with_valid_Admin_credintials() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
	}

	@When("user navigate to employee list page")
	public void user_navigate_to_employee_list_page() {
		dashboard.navigateToAddEmployee();
	}

	@When("user enters valid employee id")
	public void user_enters_valid_employee_id() {
//		click(searchEmp.empList);
		sendText(searchEmp.searchById, "730462");

	}

	@When("user click on search button")
	public void user_click_on_search_button() {
		click(searchEmp.search);

	}

	@Then("user see employee information is displayed")
	public void user_see_employee_information_is_displayed() {
		jsClick(searchEmp.empIdDisplayed);
		boolean empInfoDisplay = searchEmp.PersonalInfo.isDisplayed();
		if (empInfoDisplay) {
			System.out.println("Test case passed");
		} else {
			System.out.println("Employee information is not displayed, Test case failled");
		}
		tearDown();

	}

	@When("user enters valid employee name")
	public void user_enters_valid_employee_name() {
//		sendText(searchEmp.empName, "Ahmad Jamshid Salih");

	}

}
