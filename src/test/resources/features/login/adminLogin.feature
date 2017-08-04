Feature: login page

  As an Admin
  I want to see the login page as expected
  So that I can login into my account

  Background:
    Given I am on the Login page

  @login
  Scenario Outline: Admin logging with blank details
    When I enter userName as "<userName>", password as "<passWord>"
    And I select login
    Then I should see required "<validation messages>"
    Examples:
      | userName | passWord | validation messages      |
      |          | somepwd  | Username cannot be empty |
      | someuser |          | Password cannot be empty |

  @login
  Scenario Outline: Admin logging with invalid credentials
    When I enter userName as "<userName>", password as "<passWord>"
    And I select login
    Then I should be redirected to the retryLogin page
    And I should see invalid "<messages>"
    Examples:
      | userName | passWord | messages            |
      | invalid  | admin    | Invalid Credentials |
      | admin    | invalid  | Invalid Credentials |

  @login
  Scenario: Admin logging with valid credentials
    When I login with below credentials
      | Admin | GSj7rJWA |
    And I select login
    Then I should be on the dashboard page