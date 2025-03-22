@LoginFeature
Feature: User Login and Account Summary Functionality
Background:
 Given I am on the Home Page
 And I click on Sign in
Scenario: User login valid credentials
    When Enter crt username "username" and password "password"
    And I click the login button
    Then I should be redirected to the dashboard
    
 Scenario Outline: User login invalid credentials
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should be in the same loginpage

  Examples:
    | username | password |
    | usero1   | pass123  |
    |          |          |

