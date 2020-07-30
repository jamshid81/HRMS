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

import com.hrms.API.utils.PayloadConstant;

//import org.apache.hc.core5.http.ContentTyp;
/**
 * This @FixMethodOrder(MethodSorters.NAME_ASCENDING) will excecut @Test
 * annotation in ascending alphabetical order
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExamples {
	public static String employeeID;
	
	/**
	 * Rest Assured given - preparing the request when - making the call to the
	 * endpoint then - validating
	 */
	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	/**
	 * Setting baseURI for all calls
	 */
	static String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTU4ODUxMjUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTkyODMyNSwidXNlcklkIjoiNTA4In0.hptb-q43mI1Qo0jB1D2F4AwHJ0bOiSR2EnoONCteNQ0";

	/**
	 * JWT required for all request - expires every 12 hours
	 */
	

	public void simpleTest() {

		/**
		 * Preparing/getOneEmployee.php request (given)
		 */

		RequestSpecification getOneEmpReuest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", "21760A").log().all();

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
						+ "  \"emp_middle_name\": \"TestMiddleName\",\r\n" + "  \"emp_gender\": \"F\",\r\n"
						+ "  \"emp_birthday\": \"2000-07-11\",\r\n" + "  \"emp_status\": \"Employee\",\r\n"
						+ "  \"emp_job_title\": \"Cloud Architect\"\r\n" + "}");
		/**
		 * Storing response into createEmployeeResponse
		 */
		Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");

		/**
		 * Printing response using prettyPrint() method
		 */
		createEmployeeResponse.prettyPrint();

		/**
		 * jsonPath() to view response body which lets us get the employee ID We store
		 * employee ID as a global variable so that we may we use it with our other
		 * calls
		 * 
		 */

		employeeID = createEmployeeResponse.body().jsonPath().getString("Employee[0].employee_id");

		/** optional to print employee ID */
		System.out.println(employeeID);

		/**
		 * Verifying response status code is 201
		 */
		createEmployeeResponse.then().assertThat().statusCode(201);

		/**
		 * Verifying message using equalTo() method - manually import static package
		 * import static org.hamcrest.Matchers.*;
		 */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));

		/**
		 * Verifying created first name
		 */
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("TestFirstName"));

		/**
		 * Verifying server using then().header()
		 */
		createEmployeeResponse.then().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");

		/**
		 * Verifying Content-Type using assertThat().header()
		 */
		createEmployeeResponse.then().assertThat().header("Content-Type", "application/json");

	}
	@Test
	public void bGETcreatedEmployee() {

		/**
		 * Preparing request for /getOneEmployee.php Using log().all() to see all
		 * information being sent with request
		 */
		RequestSpecification getCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID); //.log().all();

		/**
		 * Making call to retrieve created employee
		 */
		Response getCreatedEmployeeResponse = getCreatedEmployeeRequest.when().get("/getOneEmployee.php");

		/**
		 * Printing response using prettyPrint()
		 */
		String response = getCreatedEmployeeResponse.prettyPrint();

		/**
		 * Storing response employeeID into empID which will be used for verification
		 * against stored global employee ID
		 */
		String empID = getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");

		/**
		 * matching exact employeeID's
		 */
		boolean verifyingEmpoyeeIDsMatch = empID.contentEquals(employeeID);
		System.out.println("Employee ID's match: " + verifyingEmpoyeeIDsMatch);

		/**
		 * Asserting employee ID's match
		 */
		Assert.assertTrue(verifyingEmpoyeeIDsMatch);

		/**
		 * Verifying status code is 200
		 */
		getCreatedEmployeeResponse.then().assertThat().statusCode(200);

		/**
		 * Using JsonPath class to retrieve values from response as a String
		 */

		JsonPath js = new JsonPath(response);
		
		String empId = js.getString("employee[0].employee_id");
		String firstname = js.getString("employee[0].emp_firstname");
		String lastname = js.getString("employee[0].emp_lastname");
		String middlename = js.getString("employee[0].emp_middle_name");
		String gender = js.getString("employee[0].emp_gender");
		String empDoB = js.getString("employee[0].emp_birthday");
		String empStatus = js.getString("employee[0].emp_status");
		String jobTitle = js.getString("employee[0].emp_job_title");
		System.err.println("----------printing Values that were Stored as Strings---------");
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(gender);
		System.out.println(jobTitle);
		System.out.println(empDoB);

		/** Verifying employee ID's match */
		Assert.assertTrue(empID.contentEquals(employeeID));
		// Second way of asserting
		Assert.assertEquals(employeeID, empID);

		/** Verifying expected first name matches actual first name */
		Assert.assertTrue(firstname.contentEquals("TestFirstName"));

		/** Verifying expected middle name matches actual middle name */
		Assert.assertTrue(middlename.contentEquals("TestMiddleName"));

		/** Verifying expected last name matches actual last name */
		Assert.assertTrue(lastname.contentEquals("TestLastName"));

		/** Verifying expected birth date matches actual birth date */
		Assert.assertTrue(empDoB.contentEquals("2000-07-11"));

		/** Verifying expected gender matches actual gender */
		Assert.assertTrue(gender.contentEquals("Female"));

		/** Verifying expected job title matches expected job title */
		Assert.assertTrue(jobTitle.contentEquals("Cloud Architect"));

		/** Verifying expected employee status matches actual employee status */
		Assert.assertTrue(empStatus.contentEquals("Employee"));

	}
	@Test
	public void cGETallEmployees() {

		/**
		 * Preparing /getAllEmployees.php request
		 */
		RequestSpecification getAllEmployeesRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token);

		/**
		 * Storing response into getAllEmployeesResponse
		 */
		Response getAllEmployeesResponse = getAllEmployeesRequest.when().get("/getAllEmployees.php");

		/**
		 * Printing all employees
		 */
		// getAllEmployeesResponse.prettyPrint();

		String allEmployees = getAllEmployeesResponse.body().asString();

		/**
		 * The below will pass but incorrect
		 */
		// allEmployees.contains(employeeID);
		/**
		 * ----------- DO RESEARCH ------------
		 */
		// allEmployees.matches(employeeID);

		JsonPath js = new JsonPath(allEmployees);

		/**
		 * Retrieving size of Employees list
		 */
		int sizeOfList = js.getInt("Employees.size()");

		System.out.println(sizeOfList);

		/**
		 * Print out all employee ID's
		 */

//		for (int i = 0; i < sizeOfList; i++) {
//
			/**
			 * Printing all employee IDs
			 */
//			String allEmployeeIDs = js.getString("Employees[" + i + "].employee_id");
//			// System.out.println(allEmployeeIDs);
//
			/**
			 * If statement inside for loop to find stored employee ID and break the loop
			 * when found 
			 */
//
//			if (allEmployeeIDs.contentEquals(employeeID)) {
//
//				System.out.println("Employee ID: " + employeeID + " is present in body");
//				String employeeFirstName = js.getString("Employees[" + i + "].emp_firstname");
//				System.out.println(employeeFirstName);
//				
//				
//				break;
//
//			}
//
//		}

	}

	@Test
	public void dPUTupdateCreatedEmployee() {
		
		/**
		 * Preparing request to update created employee
		 * calling static method updateCtreatedEmpBody() from HardcodedConstants class
		 */

		RequestSpecification updateCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).body(PayloadConstant.updateCreatedEmpBody());

		/**
		 * Storing response into updateCreatedEmployeeResponse
		 */
		Response updateCreatedEmployeeResponse = updateCreatedEmployeeRequest.when().put("/updateEmployee.php");

		/**
		 * Storing response into a String
		 */
	String response = updateCreatedEmployeeResponse.prettyPrint();
		
		/**
		 * Asserting using hamcrest matchers equalTo() method to verify employee is updated
		 */
		updateCreatedEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
		
		/**
		 * Retrieving response body employee ID using jsontPath()
		 */
		String empID = updateCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		
		/**
		 * Asserting that response body employee ID matches globally stored employee ID 
		 */
		Assert.assertTrue(empID.contentEquals(employeeID));
		
	}
	
	@Test 
	public void eGetUpdatedEmployee() {
		/**
		 * Prepering request to get updated employee
		 */
		RequestSpecification getUpdatedEmployeeRequest = given().header("Content-Type","application/json").header("Authorization", token).queryParam("employee_id", employeeID);
		/**
		 * storing response into updatedEmployeeResonse
		 */
		Response getUpdatedEmployeeResponse = getUpdatedEmployeeRequest.when().get("/getOneEmployee.php");
		/**
		 * printing response
		 */
		//getUpdatedEmployeeResponse.prettyPrint();
		
		getUpdatedEmployeeResponse.then().assertThat().body("employee[0].emp_firstname", equalTo("TestFirstName"));
		/**
		 * Verifying response employee ID is equal to globally stored employee ID
		 */
		getUpdatedEmployeeResponse.then().assertThat().body("employee[0].employee_id", equalTo(employeeID));
		
	}
	@Test
	public void fPATCHpartiallyUpdateEmployee() {
		
		RequestSpecification partiallyUpdatingEmployeeRequest = given().header("Content-Type","application/json").header("Authorization", token).body("{\n" + 
				"  \"employee_id\": \""+ employeeID +"\",\n" + 
				"  \"emp_firstname\": \"TestPartiallyUpdatedFirstName\"\n" + 
				"}");
		
	Response partiallyUpdatingEmployeeResponse = partiallyUpdatingEmployeeRequest.when().patch("/updatePartialEmplyeesDetails.php");
		
	partiallyUpdatingEmployeeResponse.prettyPrint();
	
	partiallyUpdatingEmployeeResponse.then().assertThat().statusCode(201);
		
	partiallyUpdatingEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
	
	}
	@Test
	public void gDELETEemployee() {
		
	RequestSpecification deleteEmployeeRequest = given().header("Content-Type","application/json").header("Authorization", token).queryParam("employee_id", employeeID);
		
	Response deleteEmployeeResponse = deleteEmployeeRequest.when().delete("/deleteEmployee.php");
	
	deleteEmployeeResponse.prettyPrint();
	
	deleteEmployeeResponse.then().assertThat().body("message", equalTo("Entry deleted"));
	
	}

}
