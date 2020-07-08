Feature: login steps

  @smoke
  Scenario: valid admin login
    When enter valid admin username and password
    And user click on login button
    Then admin user is successfully logged in

  @smoke
  Scenario: valid ess login
    When user enter valid ess "ahmadsalih" and "Syntax123$"
    And user click on login button
    Then ess user is successfully logged in

  @regression
  Scenario: Login with valid username and invalid password
    When user enters valid username and an invalid password
    And user click on login button
    Then Invalid credentials error message is displayed

  @regression
  Scenario: Login with valid username and empty password
    When user enters valid username and empty password
    And user click on login button
    Then password can not be empty error message is displayed

  @regression
  Scenario: Login without username and valid password
    When user leaves username empty and enters valid password
    And user click on login button
    Then Username can not be empty error message is displayed
