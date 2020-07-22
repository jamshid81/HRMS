package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utiles.CommonMethods;

public class EmployeeSearchPageElements extends CommonMethods {
	@FindBy(id = "menu_pim_viewEmployeeList")
	public WebElement empList;
	
	@FindBy(id = "empsearch_employee_name_empName")
	public WebElement searchByName;
	
	@FindBy(id = "empsearch_id")
	public WebElement searchById;
	
	@FindBy(id="empsearch_employee_name_empName")
	public WebElement empName;
	

	@FindBy(id = "searchBtn")
	public WebElement search;
	
	@FindBy(xpath = "//a[text()='730462']")
	public WebElement empIdDisplayed;
	
	
	@FindBy(xpath = "//h1[text()='Personal Details']")
	public WebElement PersonalInfo;

	public EmployeeSearchPageElements() {
		PageFactory.initElements(driver, this);
	}

}
