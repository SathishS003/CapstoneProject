@pdfDownload
Feature: Checking on account statement pdf Download 
Background:
 Given I am on the Home Page
 And I click on Sign in
 When Enter crt username "username" and password "password"
 And I click the login button
 And click Online Banking menu
 Scenario: To  Verfiy that the account Statement can be downloaded
  When user navigate to Statements & Documents
  Then user select an account and a date range
  And click on Download PDF button
  And user clicks on Keep in the download permission
  Then the user should verify the downloaded PDF file in the download section 