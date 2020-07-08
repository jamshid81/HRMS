package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class PersonalDetailsPageElements {

	@FindBy(id = "personal_cmbNation")
	public WebElement nationalityDD;

	@FindBy(name = "personal[optGender]")
	public List<WebElement> genderRadioGroup;

	@FindBy(xpath = "//div[@id='pdMainContainer']/div[1]/h1")
	public WebElement PersonalDetails;

	@FindBy(id = "personal_txtEmployeeId")
	public WebElement employeeId;
	@FindBy(id="btnSave")
	public WebElement editBtn;
	
	@FindBy(id="personal_txtLicenNo")
	public WebElement driverLicense;
	@FindBy(id="personal_txtLicExpDate")
	public WebElement driverExpiryDate;
	@FindBy(id="personal_txtNICNo")
	public WebElement EmpSsn;
	
	@FindBy(id="personal_txtSINNo")
	public WebElement EmpSIN;
	
	@FindBy(xpath="//input[@id='personal_chkSmokeFlag']")
	public WebElement SmokerBtn;
	
	@FindBy(id="personal_cmbMarital")
	public WebElement marritalState;
	
	@FindBy(id="personal_DOB")
	public WebElement DoB;
	
	@FindBy(id="personal_txtMilitarySer")
	public WebElement militaryService;
	
	@FindBy (id="personal_txtEmpNickName")
	public WebElement nickName;
	
	@FindBy(id="personal_optGender_1")
	public WebElement maleRadioBtn;
	
	 @FindBy(xpath="//div[@class='inner']/form/fieldset/ol/li/label")
	 public List<WebElement> empPDElements;

	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
