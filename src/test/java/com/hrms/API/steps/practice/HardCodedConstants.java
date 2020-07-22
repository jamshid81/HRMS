package com.hrms.API.steps.practice;

public class HardCodedConstants {

	public static String updateCreatedEmpBody() {
		String updateBody ="{\r\n" + 
				"  \"employee_id\": \""+HardCodedExamples.employeeID+"\",\r\n" + 
				"  \"emp_firstname\": \"syntaxUpdatedFirstName\",\r\n" + 
				"  \"emp_lastname\": \"syntaxUpdatedLastName\",\r\n" + 
				"  \"emp_middle_name\": \"syntaxUpdatedMiddleName\",\r\n" + 
				"  \"emp_gender\": \"F\",\r\n" + 
				"  \"emp_birthday\": \"2000-07-11\",\r\n" + 
				"  \"emp_status\": \"Employee\",\r\n" + 
				"  \"emp_job_title\": \"Cloud Consultant\"\r\n" + 
				"}";
		return updateBody;
	}
	
	
}
