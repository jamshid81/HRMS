package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utiles.CommonMethods;

public class AddEmployeePageElements extends CommonMethods {

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "lastName")
	public WebElement lastName;

	@FindBy(id = "middleName")
	public WebElement middleName;

	@FindBy(xpath = "//h1[text()='Personal Details']")
	public WebElement pDetails;

	@FindBy(id = "personal_txtEmployeeId")
	public WebElement personalId;

	@FindBy(id = "employeeId")
	public WebElement employeeId;

	@FindBy(id = "chkLogin")
	public WebElement checkboxLoginDetails;
	
	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmpBtn;
	@FindBy(xpath="//div[@id='profile-pic']/h1")
	public WebElement nameTag;
	
	@FindBy(xpath = "//a[text()='730462']")
	public WebElement EmppersonalInfo;
	
	@FindBy(id = "user_name")
	public WebElement username;

	@FindBy(id = "user_password")
	public WebElement password;

	@FindBy(id = "re_password")
	public WebElement confirmPassword;

	@FindBy(id = "btnSave")
	public WebElement saveBtn;

	public AddEmployeePageElements() {
		PageFactory.initElements(driver, this);
	}

}
