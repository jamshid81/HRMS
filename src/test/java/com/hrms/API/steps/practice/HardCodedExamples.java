package com.hrms.API.steps.practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
/**RestAssured static packages above need to be typed*/
import org.junit.Assert;
import org.junit.Test;

import org.junit.*;
import org.junit.runners.MethodSorters;

//import org.apache.hc.core5.http.ContentTyp;
/**
 * This @FixMethodOrder(MethodSorters.NAME_ASCENDING) will excecut @Test
 * annotation in ascending alphabetical order
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExamples {
	/**
	 * Rest Assured given - preparing the request when - making the call to the
	 * endpoint then - validating
	 */
	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	/**
	 * Setting baseURI for all calls
	 */
	static String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUxNjk0OTYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTIxMjY5NiwidXNlcklkIjoiNjQ1In0.c6XWJ6xODKra3ZERzp47TTTtD9btUjpOn3ROxQjGYUU";

	/**
	 * JWT required for all request - expires every 12 hours
	 */
	static String employeeID;

	public void simpleTest() {

		/**
		 * Preparing/geOneEmployee.php request (given)
		 */

		RequestSpecification getOneEmpReuest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", "16534A").log().all();

		/**
		 * Making call to get endpoint and Storing response (when)
		 */
		Response getOneEmpResponse = getOneEmpReuest.when().get("/getOneEmployee.php");

		/**
		 * Two ways to print response prettyPrint() method converts JSON object into
		 * string and prints - no need to SOP
		 */
		getOneEmpResponse.prettyPrint();

//		2nd way is as follows
//		String response = getOneEmpResponse.body().asString();
//		System.out.println(response);

		/**
		 * Verifying response statu scode is 200 (then)
		 */
		getOneEmpResponse.then().assertThat().statusCode(200);

	}

	@Test
	public void aPostCreatEmp() {

		RequestSpecification createEmployeeRequest = given().header("Content-Type", "application/json")
				.headers("Authorization", token)
				.body("{\r\n" + "  \"emp_firstname\": \"TestFirstName\",\r\n"
						+ "  \"emp_lastname\": \"TestLastName\",\r\n"
						+ "  \"emp_middle_name\": \"syntaxMiddleName\",\r\n" + "  \"emp_gender\": \"F\",\r\n"
						+ "  \"emp_birthday\": \"2000-07-11\",\r\n" + "  \"emp_status\": \"Employee\",\r\n"
						+ "  \"emp_job_title\": \"Cloud Architect\"\r\n" + "}");
		Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");

		createEmployeeResponse.prettyPrint();

		/**
		 * jsonPath() to view response body which let us get the employee ID bellow line
		 * is to retrieve the employee ID which initialize the the static varible
		 * employee id during runtime
		 */
		employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
		/**
		 * optinal to print employee id
		 */
		System.out.println(employeeID);
		/**
		 * Verifying response status code is 201
		 */
		createEmployeeResponse.then().assertThat().statusCode(201);
		/**
		 * Verifying message using equalsTo() method - manually import static package
		 * import static org.hamcrest.Matchers.*;
		 */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));

		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("TestFirstName"));

		createEmployeeResponse.then().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");

		createEmployeeResponse.then().assertThat().header("Content-Type", "application/json");

	}

	@Test
	public void bGETcreateEmployee() {
		RequestSpecification getCreateEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID).log().all();
		/**
		 * making call to retrieve created employee
		 */

		Response getcreateEmployeeResponse = getCreateEmployeeRequest.when().get("/getOneEmployee.php");
		String response = getcreateEmployeeResponse.prettyPrint();
		String empID = getcreateEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		boolean verifyingEmployeeIDsMatch = empID.equalsIgnoreCase(employeeID);
		/**
		 * matching exact employeeID
		 */
		Assert.assertTrue(verifyingEmployeeIDsMatch);
		/** verifying status code is 200 */
		getcreateEmployeeResponse.then().assertThat().statusCode(200);

		/**
		 * Using JsonPath class to retrieve valuse from response as a String
		 */
		JsonPath js = new JsonPath(response);

		String empId = js.getString("employee[0].employee_id");
		String firstname = js.getString("employee[0].emp_firstname");
		String lastname = js.getString("employee[0].emp_lastname");
		String middlename = js.getString("employee[0].emp_middle_name");
		String gender = js.getString("employee[0].emp_gender");
		String DoB = js.getString("employee[0].emp_birthday");
		String status = js.getString("employee[0].emp_status");
		String jobTittle = js.getString("employee[0].emp_job_title");
		System.err.println("----------printing Values that were Stored as Strings---------");
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(gender);
		System.out.println(jobTittle);

		Assert.assertTrue(empID.contentEquals(employeeID));

		/**
		 * verifying expected valuses match actual Values
		 */

		Assert.assertTrue(firstname.contentEquals("TestFirstName"));
		/**
		 * verifying expected firstname matchs actual fistname
		 */
		Assert.assertTrue(lastname.contentEquals("TestLastName"));
		/**
		 * verifying expected lastname matchs actual lasttname
		 */
		Assert.assertTrue(middlename.contentEquals("syntaxMiddleName"));
		/**
		 * verifying expected middlename matchs actual middlename
		 */
		Assert.assertTrue(gender.contentEquals("Female"));
		Assert.assertTrue(jobTittle.contentEquals("Cloud Architect"));
		Assert.assertTrue(DoB.contentEquals("2000-07-11"));
		Assert.assertTrue(status.contentEquals("Employee"));
	}

	@Test
	public void cGETallEmployee() {
		RequestSpecification getCreateEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token);

		Response getCreateEmployeeResponse = getCreateEmployeeRequest.when().get("/getAllEmployees.php");

		// getCreateEmployeeResponse.prettyPrint();
		String allEmployees = getCreateEmployeeResponse.body().asString();
		// Howework to research code bellow
		// allEmployees.matches(employeeID);
		
		/** bellow code will return the String cheracters length */
		// System.out.println(allEmployees.length());
		
		JsonPath js = new JsonPath(allEmployees);
		int sizeOfList = js.getInt("Employees.size()");
		System.out.println(sizeOfList);

		/**
		 * print out all employee ID's
		 */
		for (int i = 0; i < sizeOfList; i++) {

			String allEmployeeIDs = js.getString("Employees[" + i + "].employee_id");
			// System.out.println(allEmployeeIDs);

			/**
			 * printing the the created employee firstname 
			 */
			if (allEmployeeIDs.contentEquals(employeeID)) {
				System.out.println("Employee ID: " + employeeID + " is present in body");
				String employeeFirstName = js.getString("Employees[" + i + "].emp_firstname");
				System.err.println(employeeFirstName);

				break;
			}

		}
	}

	@Test
	public void dPUTupdateCreatedEmployee() {
		RequestSpecification updateCreateEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).body(HardCodedConstants.updateCreatedEmpBody());

		Response updateCreateEmployeeResponse = updateCreateEmployeeRequest.when().put("/updateEmployee.php");
		String response = updateCreateEmployeeResponse.prettyPrint();
	}
}
