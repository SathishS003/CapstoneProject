@Logout
Feature: User Login and Logout Functionality
Background:
 Given I am on the Home Page
 And I click on Sign in
 When Enter crt username "username" and password "password"
 And I click the login button
 Then I should be redirected to the dashboard
 Scenario: To check user can logout successfully
 When The user clicks on the Logout button
    Then The user should be redirected to the login page
Scenario: To ensure session expire after logout
And The user logs out of the application
    When The user clicks the Back button in the browser
    Then The user should not be able to access the previous page