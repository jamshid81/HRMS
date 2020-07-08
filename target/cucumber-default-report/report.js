$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Login.feature");
formatter.feature({
  "name": "login steps",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "valid admin login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "enter valid admin username and password",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.LoginSteps.enter_valid_admin_username_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.LoginSteps.user_click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "admin user is successfully logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.LoginSteps.admin_user_is_successfully_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "valid admin login");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "valid ess login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user enter valid ess \"ahmadsalih\" and \"Syntax123$\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.LoginSteps.user_enter_valid_ess_username_and_password(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.LoginSteps.user_click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "ess user is successfully logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.LoginSteps.ess_user_is_successfully_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png", "valid ess login");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/addEmployee.feature");
formatter.feature({
  "name": "Add new Employee",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is logged in with valid Admin credintials",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_is_logged_in_with_valid_Admin_credintials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigate to employee list page",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_navigate_to_employee_list_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add Employee with first and lastname",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "user enters employees \"John\" and \"Smith\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.user_enters_employees_and(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks save button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.user_clicks_save_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"John Smith\" is added successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.is_added_successfully(java.lang.String)"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: Employee is not added expected:\u003c[John Smith]\u003e but was:\u003c[Personal Details]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:117)\r\n\tat com.hrms.steps.AddEmployeeSteps.is_added_successfully(AddEmployeeSteps.java:31)\r\n\tat ✽.\"John Smith\" is added successfully(file:///C:/Users/jamsh/eclipse-workspace/Hrms/src/test/resources/features/addEmployee.feature:12)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded2.png", "Add Employee with first and lastname");
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is logged in with valid Admin credintials",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_is_logged_in_with_valid_Admin_credintials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigate to employee list page",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_navigate_to_employee_list_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add Employee without employee id",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "user enters employees first name and last name",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.user_enters_employees_first_name_and_last_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user deletes employee id",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.user_deletes_employee_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks save button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.user_clicks_save_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "employee is added successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.employee_is_added_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded3.png", "Add Employee without employee id");
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is logged in with valid Admin credintials",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_is_logged_in_with_valid_Admin_credintials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigate to employee list page",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_navigate_to_employee_list_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "AddEmployee and create Login Credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "user enters employees first name and last name",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.user_enters_employees_first_name_and_last_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on create login checkbox",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.user_clicks_on_create_login_checkbox()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters login credentials",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.user_enters_login_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks save button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.user_clicks_save_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "employee is added successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.employee_is_added_successfully()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//h1[text()\u003d\u0027Personal Details\u0027]\"}\n  (Session info: chrome\u003d83.0.4103.97)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-T8R4K7N\u0027, ip: \u0027192.168.1.254\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_251\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 83.0.4103.97, chrome: {chromedriverVersion: 83.0.4103.39 (ccbf011cb2d2b..., userDataDir: C:\\Users\\jamsh\\AppData\\Loca...}, goog:chromeOptions: {debuggerAddress: localhost:58990}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 07cd8acef3f926a228198bf7116bdb5e\n*** Element info: {Using\u003dxpath, value\u003d//h1[text()\u003d\u0027Personal Details\u0027]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.getText(Unknown Source)\r\n\tat com.hrms.steps.AddEmployeeSteps.employee_is_added_successfully(AddEmployeeSteps.java:49)\r\n\tat ✽.employee is added successfully(file:///C:/Users/jamsh/eclipse-workspace/Hrms/src/test/resources/features/addEmployee.feature:27)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded4.png", "AddEmployee and create Login Credentials");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/dashboard.feature");
formatter.feature({
  "name": "Dashboard",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Dashboard menue view for Admain",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is logged in with valid Admin credintials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_is_logged_in_with_valid_Admin_credintials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user see dashboard menu is displayed",
  "rows": [
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.DashboardMenusSteps.user_see_dashboard_menu_is_displayed(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded5.png", "Dashboard menue view for Admain");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/searchEmployee.feature");
formatter.feature({
  "name": "Employee Search",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search Employee by id",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is logged in with valid Admin credintials",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_is_logged_in_with_valid_Admin_credintials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigate to employee list page",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_navigate_to_employee_list_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters valid employee id",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_enters_valid_employee_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on search button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_click_on_search_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user see employee information is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_see_employee_information_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-T8R4K7N\u0027, ip: \u0027192.168.1.254\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_251\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.getScreenshotAs(RemoteWebDriver.java:295)\r\n\tat com.hrms.utiles.CommonMethods.takeScreenshot(CommonMethods.java:259)\r\n\tat com.hrms.steps.Hooks.end(Hooks.java:23)\r\n",
  "status": "failed"
});
});