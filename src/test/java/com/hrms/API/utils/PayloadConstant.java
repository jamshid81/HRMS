package com.hrms.API.utils;

import org.json.JSONObject;

import com.hrms.API.steps.practice.HardCodedExamples;

public class PayloadConstant {

	public static String createEmployeeBody() {
		String creatEmployeeBody = "{\r\n" + "  \"emp_firstname\": \"TestFirstName\",\r\n"
				+ "  \"emp_lastname\": \"TestLastName\",\r\n" + "  \"emp_middle_name\": \"TestMiddleName\",\r\n"
				+ "  \"emp_gender\": \"M\",\r\n" + "  \"emp_birthday\": \"1981-07-11\",\r\n"
				+ "  \"emp_status\": \"Employee\",\r\n" + "  \"emp_job_title\": \"Cloud Consultant\"\r\n" + "}";

		return creatEmployeeBody;
	}

	/**
	 * Creating payload using JSONObject and returning it as a String
	 * 
	 * @return
	 */

	public static String creatEmployeePayload() {
		JSONObject obj = new JSONObject();

		obj.put("emp_firstname", "TestFirstName");
		obj.put("emp_lastname", "TestLastName");
		obj.put("emp_middle_name", "TestMiddleName");
		obj.put("emp_gender", "M");
		obj.put("emp_birthday", "1981-07-11");
		obj.put("emp_status", "Employee");
		obj.put("emp_job_title", "Cloud Consultant");

		return obj.toString();
	}

	/**
	 * Created method to return payload - to reduce messy code
	 * 
	 * @return
	 */
	public static String updateCreatedEmpBody() {

		String updateBody = "{\r\n" + "            \"employee_id\": \"" + HardCodedExamples.employeeID + "\",\r\n"
				+ "            \"emp_firstname\": \"TestFirstName\",\r\n"
				+ "            \"emp_middle_name\": \"TestUpdatedMiddleName\",\r\n"
				+ "            \"emp_lastname\": \"TestLastName\",\r\n"
				+ "            \"emp_birthday\": \"1981-07-11\",\r\n" + "            \"emp_gender\": \"M\",\r\n"
				+ "            \"emp_job_title\": \"Cloud Consultant\",\r\n"
				+ "            \"emp_status\": \"Employee\"\r\n" + "        }";

		return updateBody;
	}

}
