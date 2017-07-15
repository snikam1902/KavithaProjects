Feature: Creating an employee with user login details

  As an Admin
  I want to see Add Employee option
  So that I can create new employees

  Background:
    Given I logged in
    And 'Add Employee' is selected from the submenu items under the PIM module in the dashboard
    And I am on Add Employee overlay window

  Scenario: User login details layout for new employee
    When I select the create login details check box
    Then I should see login details sections on the Add Employee overlay
    And I should see the default status as "enabled"

  Scenario: Add valid login details for the new employee
    Given when I select create login details check box on the Add Employee overlay
    When I fill the add employee form with below details:
      |FirstName    |MiddleName     |LastName         |Location |UserName|Password|ConfirmPassword|Status |
      |testEmployee1|testEmp_middle |testEmp_lastName |America  |testEmp1|testEmpl1|testEmp1      |enabled|
    And I click save button
    Then new employee should be created successfully
    And new employee should be shown in the Employee list page.