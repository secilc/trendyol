Feature: Login test WIP

  Scenario: Valid login
    Given go to login page
    And enter email and password
      | secil.test@mailinator.com | 123456a |

  Scenario: Invalid email
    Given go to login page
    And enter email and password
      | secil.test@mailinator.com | test123456 |

  Scenario: Wrong password
    Given go to login page
    And enter email and password
      | secil.test@mailinator.com | test123456 |