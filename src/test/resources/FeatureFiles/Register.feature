Feature: Validate the Register functionality for e2eHiring application

        @register 
      Scenario: Verification of Register functionality 
Given I launch application
Then I click on Register
Then I enter first name 
Then I enter last name 
Then I open new TAB enter URl  
Then I enter New emailid
Then I enter New password "Abhi@123"
Then I click on Register button