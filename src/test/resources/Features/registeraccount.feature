Feature: New user Registration

  A new user can come to app and create an account

  Background: User is on OpenCart Register page

    Scenario: Existing user is trying to register an account
      Given User is OpenCart Registration page
      When  User enters a Firstname
      When  User enters a Lastname
      And   User enters Existing email
      And   User enters Random Telephone number
      And   User enters Password
      And   User enters Password Confirm
      And   User agreed to the privacy policy
      And   User clicks on continue button
      Then  User should see an error message AccountExist