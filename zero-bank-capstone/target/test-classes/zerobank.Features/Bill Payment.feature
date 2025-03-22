@BillPayment
Feature: User Login and Bill Payment fucntionality
Background:
 Given I am on the Home Page
 And I click on Sign in
 When Enter crt username "username" and password "password"
 And I click the login button
 And click Online Banking menu
 Scenario: successful Bill Payment
   Then click on Account summary
    And  click on Pay Bills
    Then select a Payee
    And Enter a valid amount "200" and "25" date
    Then click on pay button
    And "The payment is successfully submitted" is displayed
Scenario: Scheduling a bill payment for future date
 Then click on Account summary
    And  click on Pay Bills
    Then select a Payee
    And Enter a valid amount "500" and future date "28" on date
    Then click on pay button
    And "The payment is successfully submitted" is displayed
Scenario: Pay bills without entering Amount
 Then click on Account summary
    And  click on Pay Bills
    Then select a Payee
    And Leave the Amount empty and Enter date "28" on date
    Then click on pay button
    And "Amount field cannot be empty" alert is displayed
Scenario: Successfully Add new Payee
 Then click on Account summary
    And  click on Pay Bills
    Then click on add new payee
    Then add name "sathish",address "trichy",accountno "123123123",detatils "add new payee".
    Then click Add button
    And New payee success message is displayed
Scenario: Add payee with missing Details
Then click on Account summary
    And  click on Pay Bills
    Then click on add new payee
    Then add name "sathish",address "",accountno "123123123",detatils "add new payee".
    Then click Add button
    And Error "All fields are required" should be displayed.
