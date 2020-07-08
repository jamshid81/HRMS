#Author: ahmad.j.Salih@gmail.com
Feature: Dashboard

  @smoke
  Scenario: Dashboard menue view for Admain
    When user is logged in with valid Admin credintials
    Then user see dashboard menu is displayed
      | Admin | PIM | Leave | Time | Recruitment | Performance | Dashboard | Directory |
