package com.hrms.steps;

import java.util.List;
import java.util.Map;

import com.hrms.utiles.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmpPersonalInfoModification extends CommonMethods {
	@When("user click on emplyee informaion")
	public void user_click_on_emplyee_informaion() {
	   click( addEmp.EmppersonalInfo);
	   wait(2);
	}

	@Then("user should be able to modify employee personal information")
	public void user_should_be_able_to_modify_employee_personal_information(DataTable EmpModifyData) {
	  
		List<Map<String,String>> emElementMapList=EmpModifyData.asMaps();
		
		for( Map<String, String>map:emElementMapList) {
			click(pdetailsPage.editBtn);
			sendText(pdetailsPage.driverLicense, map.get("Drivers License Number"));
			sendText(pdetailsPage.driverExpiryDate, map.get("License Expiry Date"));
			sendText(pdetailsPage.EmpSsn,map.get("SSN Number"));
			sendText(pdetailsPage.EmpSIN, map.get("SIN Number"));
			click(pdetailsPage.maleRadioBtn);
			wait(3);
			selectDdValue(pdetailsPage.marritalState,map.get("Marital Status"));
			selectDdValue(pdetailsPage.nationalityDD,map.get("Nationality"));
			sendText(pdetailsPage.DoB,map.get("Date of Birth"));
			
			sendText(pdetailsPage.nickName,map.get("Nick Name"));
			
			waitForClickability(pdetailsPage.SmokerBtn);
			jsClick(pdetailsPage.SmokerBtn);
		
			sendText(pdetailsPage.militaryService, map.get("Military Service"));
			click(pdetailsPage.editBtn);
			//takeScreenshot("peronalDetailsScreenShot");
			
		}
		
		
	}
}
