Feature: Login functionality for opencart E-com application

  As a user, user should be able to login to app
  so that, he/she can access their account related features and their orders

  Background:
    Given  User on open cart login page

  Scenario: Successful login with valid credentials
    Given User entered a valid username and valid password
    When  User clicks on login button
    Then  User should be logged in successfully

  Scenario Outline:  Unsuccessful login with invalid credentials or empty credentials
    Given User has entered invalid "<username>" and "<password>"
    When User clicks on login button
    Then User should see an error message
    Examples:
    |       username       |      password            |
    | invalid123@gmail.com |      invalid             |
    |       abcdwdwq       |    Dummy100@gmail.com    |
    | Dummy100@gmail.com   |      password            |
    |                      |                          |
