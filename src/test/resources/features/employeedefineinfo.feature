#Author: ahmad.j.salih@gmail.com

Feature: Employee Personal detail modification

  @regression
  Scenario: 
    Given user is logged in with valid Admin credintials
    And user navigate to employee list page
    When user enters valid employee id
    And user click on search button
    And user click on emplyee informaion
    Then user should be able to modify employee personal information
      | Drivers License Number | License Expiry Date | SSN Number | SIN Number | Gender | Marital Status | Nationality | Date of Birth | Nick Name | Smoker | Military Service |
      | c52323232              | 2025-Feb-04         |  394955676 |    1212234 |        | Married        | American    | 1990-Jun-05   | Rais      |        | N/A              |
