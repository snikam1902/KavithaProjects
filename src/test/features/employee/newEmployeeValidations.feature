Feature: validation messages for Add Employee overlay

  As an Admin
  I want to see the notification message
  So that I can correct and proceed further

  Background:
    Given I logged in
    And I am on the DashboardPage
    And PIM menu on the left had side panel is exapanded
    And I click on Add Employee link under the PIM menu

  Scenario Outline: check the blank values for mandatory fields
    When I enter the following details
    | firstName       | <firstName>  |
    | middleName      | <middleName> |
    | lastName        | <lastName>   |
    | location        | <location>   |
    | userName        | <userName>   |
    | password        | <password>   |
    | confirmPwd      | <confirmPwd> |
    When I click Save button
    Then I should get validation message as "<message>"

    Examples:
      |firstName	|middleName   |lastName	        |location	    |userName        |password        |confirmPwd      |message	    |
      |         	|middle       |emp1 lastname	|someLocation	|userName        |password        |confirmPwd      |Required	|
      | emp_first  	|middle       |             	|someLocation	|userName        |password        |confirmPwd      |Required	|
      | emp_first  	|middle       |emp1 lastname	|           	|userName        |password        |confirmPwd      |Required	|
      | emp_first  	|             |emp1 lastname	|someLocation  	|userName        |password        | confirmPwd     |         	|
      | emp_first  	|             |emp1 lastname	|someLocation  	|                |password        | confirmPwd     |Required   	|
      | emp_first  	|             |emp1 lastname	|someLocation  	|userName        |                | confirmPwd     |Required   	|
      | emp_first  	|             |emp1 lastname	|someLocation  	|userName        |password        |                |Required   	|

  Scenario Outline: check the valid values for the login details
    When I enter the following details
      | firstName       | emp_first      |
      | middleName      | middle         |
      | lastName        | emp1_lastname  |
      | location        | someLocation   |
      | userName        | <userName>   |
      | password        | <password>   |
      | confirmPwd      | <confirmPwd> |
      | status          | enabled     |
    When I click Save button
    Then I should get validation message as "<message>"
    Examples:
      |userName        |password        |confirmPwd             |message	                            |
      |use             |password        |confirmPwd     	    |Should have at least 5 characters	    |
      |u*33            |password        |confirmPwd     	    |Should not be more than 32 characters	|
      |userName        |pas             |confirmPwd     	    |Should have at least 4 characters	    |
      |userName        |password        |password        	    |very week                            	|
      |userName        |password        |password        	    |week                               	|
      |userName        |p*33            |confirmPwd     	    |Should not be more than 32 characters	|
      |userName        |password        |confirmPwd     	    |password is not matching           	|