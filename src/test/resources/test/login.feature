Feature: Boutiques test

  Scenario: Valid login
    Given go to login page
    And enter email and password
      | email         | password   |
      | test@test.com | test123456 |

