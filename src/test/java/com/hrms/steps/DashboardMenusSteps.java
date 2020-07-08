package com.hrms.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.hrms.utiles.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;


public class DashboardMenusSteps extends CommonMethods {
	@Then("user see dashboard menu is displayed")
	public void user_see_dashboard_menu_is_displayed(DataTable dataTable) {

		List<String>expectedDashMenu=dataTable.asList();
		List<String> actualDashMenu=new ArrayList<>();
		
		for (WebElement element:dashboard.dashMenu) {
			actualDashMenu.add(element.getText());
		}
			System.out.println(expectedDashMenu);
			System.out.println(actualDashMenu);
			Assert.assertEquals(expectedDashMenu, actualDashMenu);

	    
	}



}
