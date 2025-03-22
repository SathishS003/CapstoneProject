@FundTransfer
Feature: User Login and Fund Transfer functionality 
Background:
 Given I am on the Home Page
 And I click on Sign in
 When Enter crt username "username" and password "password"
 And I click the login button
 And click Online Banking menu
 Scenario: Successful Fund Transfer
     Then click on Account summary
     Then click on Transfer fund menu
     And click From and To Accounts
     And Enter a valid Amount "200" 
     Then click continue
     And Successfully transaction in displayed
Scenario: Fund transfer with insufficient balance
     Then click on Account summary
     Then click on Transfer fund menu
     And click From and To Accounts
     And Enter a more than Amount "80000" 
     Then click continue
     And  "Insufficent funds" should be displayed
Scenario: Fund transfer with negative amount
Then click on Account summary
And click on Transfer fund menu
And click From and To Accounts
Then Enter a negative Amount "-300"
Then click continue
And  "Invalid amount entered" should be displayed
 