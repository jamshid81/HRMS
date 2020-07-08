package com.hrms.steps;

import org.junit.Assert;
import com.hrms.utiles.CommonMethods;
import com.hrms.utiles.ConfigsReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonMethods {
	@When("enter valid admin username and password")
	public void enter_valid_admin_username_and_password() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		click(login.loginBtn);
	}

	@Then("admin user is successfully logged in")
	public void admin_user_is_successfully_logged_in() {
		String expected = "Welcome Admin";
		String actual = dashboard.welcome.getText();
		Assert.assertEquals("Welcome message for Admain is not displayed or not correct ", expected, actual);
		System.out.println(actual);
	}

	@When("user enter valid ess {string} and {string}")
	public void user_enter_valid_ess_username_and_password(String username, String password) {
		sendText(login.username, username);
		sendText(login.password, password);
	}

	@Then("ess user is successfully logged in")
	public void ess_user_is_successfully_logged_in() {
		String expected = "Welcome Ahmad";
		String actual = dashboard.welcome.getText();
		Assert.assertEquals("Welcome message for ESS is not displayed or not correct ", expected, actual);
		System.out.println(actual);
	}

	@When("user enters valid username and an invalid password")
	public void user_enters_valid_username_and_an_invalid_password() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "password");

	}

	@Then("Invalid credentials error message is displayed")
	public void invalid_credentials_error_message_is_displayed() {
		String expected = "Invalid credentials";
		String actual = login.errorMsg.getText();
		Assert.assertEquals("Errore message is not displayed or not correct ", expected, actual);
		System.out.println(actual);
	}

	@When("user enters valid username and empty password")
	public void user_enters_valid_username_and_empty_password() {
		sendText(login.username, ConfigsReader.getProperty("username"));
	}

	@Then("password can not be empty error message is displayed")
	public void password_can_not_be_empty_error_message_is_displayed() {
		String expected = "Password cannot be empty";
		String actual = login.errorMsg.getText();
		Assert.assertEquals("Empty password message is not displayed or not correct ", expected, actual);
		System.out.println(actual);
	}

	@When("user leaves username empty and enters valid password")
	public void user_leaves_username_empty_and_enters_valid_password() {
		sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@Then("Username can not be empty error message is displayed")
	public void username_can_not_be_empty_error_message_is_displayed() {
		String expected = "Username cannot be empty";
		String actual = login.errorMsg.getText();
		Assert.assertEquals("Empty username message is not displayed or not correct ", expected, actual);
		System.out.println(actual);
	}
}