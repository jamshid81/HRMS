Feature: Employee Search

  @smoke
  Scenario: Search Employee by id
    Given user is logged in with valid Admin credintials
    When user navigate to employee list page
    And user enters valid employee id
    And user click on search button
    Then user see employee information is displayed

  #@inProgress
  #Scenario: Search Employee by name
    #And user is logged in with valid Admin credintials
    #When user navigate to employee list page
    #And user enters valid employee name
    #And user click on search button
    #Then user see employee information is displayed
