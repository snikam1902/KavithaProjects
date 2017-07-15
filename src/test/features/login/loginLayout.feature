Feature: Login UI Layout
  As an Admin
  I want to see the login page as expected
  So that I can login into my account

  Background:
    Given I am on the Login page

  Scenario: Login Layout
    Then I should see the page as per the design

    # is it images or names
  Scenario Outline: Login Page social networking links
    Then I should see "<image-links>" as per the design
    When I click on the  "<image-links>"
    Then "<page>" should be open
    Examples:
      | image-links | page     |
      | linkedin    | linkedin |
      | facebook    | facebook |
      | twitter     | twitter  |
      | youtube     | youtue   |