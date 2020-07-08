package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.utiles.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;


public class InvalidCredintialLogIn extends CommonMethods {
	@When("I enter invalid username and password and see error message")
	public void i_enter_invalid_username_and_password_and_see_error_message(DataTable dataTable) {
	   List<Map<String,String>> loginMap=dataTable.asMaps();
	   
	   for(Map<String,String>map:loginMap) {
		   sendText(login.username,map.get("UserName"));
		  sendText(login.password, map.get("Password"));
		  
		   click(login.loginBtn);
		   Assert.assertEquals("ErrorMessages mismatch",  map.get("ErrorMessage"), login.errorMsg.getText());
		
		   
	   }
	}



}
