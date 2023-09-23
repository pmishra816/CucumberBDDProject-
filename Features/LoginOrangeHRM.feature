Feature: Login to OrangeHRM

  Scenario: Login with Valid User
    Given User launched chrome browser with OrangeHRM Url
    When User enter username and password
    And User clicks on login button
    Then User navigated to main page
    
    
    