@newEmployee
Feature: creating an Employee by Admin
  As an Admin
  I want to see Add Employee option
  So that I can create new employees

  Background:
    Given I logged in
    And I am on the Dashboard page
    And I expand the PIM module on the left hand side panel

  Scenario: PIM module contains Add Employee link
    Then I should see Configuration, Employee List, Add Employee, Bulk Update and Reports links

  Scenario: Employee List page
    When I select Employee List link
    Then I should be on the employee list page
    And I should see the employee list
    And I should see plus button on top right corner of the page

  Scenario: showing Add Employee overlay using Add Employee link
    When I click Add Employee link under the PIM menu
    Then I should see Add Employee overlay
    And default employee id should be displayed


  Scenario: showing Add Employee overlaying using plus button
    When I select Employee List link
    And I select plus button
    Then I should see Add Employee overlay

  Scenario Outline: Creating an employee with valid data
    When I click Add Employee link under the PIM menu
    When I fill the form with following details
      | firstName       | <firstName>  |
      | middleName      | <middleName> |
      | lastName        | <lastName>   |
      | location        | <location>   |
    And I click save button
    Then new employee should be saved
    And "<firstName>" and "<lastName>" should be displayed in the employee list page as links.

    Examples:
      |firstName	|middleName   |lastName 	|location|
      |emp1 		|emp1 middle  |emp1 last    |location|
     # |emp2         |             |emp2 last    |location|

    # assuming that 1000 doesnt exists
  Scenario: editing the default employee id to valid value
    Given I am on the Add Employee overlay
    When I fill the form with following details
      | firstName       | first      |
      | middleName      | middle     |
      | lastName        | last       |
      | location        | location   |
    And I edit the default employee id as "1000"
    And I click save button
    Then new employee should be saved
    And "1000" employee id should be displayed in the employee list page

  Scenario: editing the default employee id to an existing value
    Given I am on the Add Employee overlay
    When I fill the form with following details
      | firstName       | first      |
      | middleName      | middle     |
      | lastName        | last       |
      | location        | location   |
    And I edit the default employee id as "10"
    And I click save button
    Then I should see error message that employee id already exists

    # I need to know the open file window options
  Scenario: adding photograph within the accepted limit
    Given I am on the Add Employee overlay
    When I fill the form with following details
      | firstName       | first      |
      | middleName      | middle     |
      | lastName        | last       |
      | location        | location   |
    And I click Add Photograph button
    And I select an image of the size 1mb from the open window
    Then image should be shown in the Add Employee window

  Scenario: adding photograph over the accepted size limit
    Given I am on the Add Employee overlay
    When I fill the form with following details
      | firstName       | first      |
      | middleName      | middle     |
      | lastName        | last       |
      | location        | location   |
    And I click Add Photograph button
    And I select an image of the size 2mb from the open window
    Then I should see error message that image is big

  Scenario: adding photograph over the accepted size limit
    Given I am on the Add Employee overlay
    When I fill the form with following details
      | firstName       | first      |
      | middleName      | middle     |
      | lastName        | last       |
      | location        | location   |
    And I click Add Photograph button
    And I select an image of the size 2mb from the open window
    Then I should see error message that image is big

  Scenario: cancelling the Add Employee overlay
    Given I am on the Add Employee overlay
    When I click ESC button
    Then Add Employee window should be closed
    And I should be on the employee list page

  Scenario: cancelling the Add Employee overlay
    Given I am on the Add Employee overlay
    When I Cancel button
    Then Add Employee window should be closed
    And I should be on the employee list page

  Scenario: cancelling the Add Employee overlay
    Given I am on the Add Employee overlay
    When I click any where outside the Add Employee overlay
    Then Add Employee window should be closed
    And I should be on the employee list page

