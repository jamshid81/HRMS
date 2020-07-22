#Author: ahmad.j.salih@gmail.com
Feature: Name validations against DB

 @DBTest
  Scenario: First Name validation against DB
    Given user is logged in with valid Admin credintials
    And user navigate to employee list page
    When user enters valid employee id
    And user click on search button
    Then user verifies table is displayed
    And user get firstName "Ahmad" from table and user get firstName from db and Validate
    
