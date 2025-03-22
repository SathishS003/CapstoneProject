@AccountSummary
Feature: User Login and Account Summary Functionality
Background:
 Given I am on the Home Page
 And I click on Sign in
 When Enter crt username "username" and password "password"
 And I click the login button
 Then I should be redirected to the dashboard
Scenario: verify the correctness of account details
    Then click Online Banking menu
    Then click on Account summary
    And Account types and balance is displayed
Scenario: Validate Account types
    Then click Online Banking menu
    Then click on Account summary
    And  Check Account types are displayed
