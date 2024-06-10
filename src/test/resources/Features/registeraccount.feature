Feature: New user Registration

  A new user can come to app and create an account

  Background:
  Given User is on OpenCart Register page

  Scenario Outline: Check User Registration flow
    When  User enters firstname "<Firstname>"
    And   User enters lastname "<Lastname>"
    And   User enters an email "<email>"
    And   User enters number "<TelephoneNumber>"
    And   User enters password "<Password>"
    And   User enters confirm password "<PasswordConfirm>"
    And   User agreed to the privacy policy
    And   User clicks on continue button
    Then  Check whether account is created or not

    Examples:
      | Firstname | Lastname | email              | TelephoneNumber | Password | PasswordConfirm |
            #1. Positive - Register with valid Data
      | Dummy     | Dummy    | Dummy213@gmail.com | 39318918        | Password | Password        |

            #2. Try to register by not giving FirstName
      |           | Dummy    | Dummy2000@gmail.com | 39318918        | Password | Password        |

            #3. Try to register by not giving LastName
      | Dummy     |          | Dummy2000@gmail.com | 39318918        | Password | Password        |

            #4. Try to register by not giving email id
      | Dummy     | Dummy    |                    | 39318918        | Password | Password        |

            #5.Try to register by not giving phone
      | Dummy     | Dummy    | Dummy2000@gmail.com |                 | Password | Password        |

            #6. Try to register by not giving Password
      | Dummy     |  Dummy    | Dummy2000@gmail.com | 39318918       |          | Password        |

           #7. Try to register by not giving confirm Password
      | Dummy     |  Dummy    | Dummy2000@gmail.com | 39318918       | Password  |                 |


           #8. Give Nothing and Try to register
      |           |           |                    |                |           |                  |

           #9. Try to register by entering Password and confirm password are not same
      | Dummy     |  Dummy    | Dummy2000@gmail.com | 39318918       | Password  | phs82           |

          #10.Try to register with existing email
      | Dummy     | Dummy    | Dummy100@gmail.com | 39318918        | Password |  Password          |



