package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.EmployeeSearchPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;

//initializes all pages class and stores references in static varibales
//that will called/used in test classes
public class PageInitializer extends BaseClass{

	public static LoginPageElements login;
	public static AddEmployeePageElements addEmp;
	public static DashboardPageElements dashboard;
	public static PersonalDetailsPageElements pdetailsPage;
	public static EmployeeSearchPageElements searchEmp;
	
	public static void initialize() {
		
		login=new LoginPageElements();
		dashboard=new DashboardPageElements();
		addEmp=new AddEmployeePageElements();
		pdetailsPage=new PersonalDetailsPageElements();
		searchEmp=new EmployeeSearchPageElements();
	}
}
