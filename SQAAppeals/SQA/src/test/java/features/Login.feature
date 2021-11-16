#Author: your.email@your.domain.com

Feature: Login to SQA Portal

  @RegTest
  Scenario: Login with valid credentials
    Given the user has access to SQA Portal
    When the user enters his valid credentials
    Then the user can view the services  
    
    @RegTest
  Scenario: Login with In-valid credentials
    Given the user has access to SQA Portal
    When the user enters his Invalid credentials
    Then the user cannot login to the site