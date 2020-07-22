package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.hrms.testbase.BaseClass;
import com.hrms.utiles.CommonMethods;

public class EmployeeList extends CommonMethods {

	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td")
	public List<WebElement> resultTable;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[4]")
	public WebElement empLNameDisplayed;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[3]")
	public WebElement firstName;
	
	public EmployeeList() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
