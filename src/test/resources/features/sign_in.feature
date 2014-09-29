Feature: SignIn
  In order to use the system
  Any registered user
  Should be able to log in
  @Test
  Scenario Outline: Login Success and Failure
    Given I try to login with "<type>" credentials
    Then I should see that I logged in "<status>"

  Examples:
    | type		| status		|
    | valid		| successfully		|
    | invalid	| unsuccessfully	|


  Scenario Outline: Login with Social accounts
    Given I try to login with "<social>" account
    Then I should see that I logged in "<status>"

  Examples:
    | social		| status		|
    | google		| successfully		|
    | facebook	    | successfully	|
    | live	        | successfully	|
    | gotomeeting	| successfully	|

  Scenario: Forget password
    Given I forget my password
    And I restore it
    And I try to login with "restored" account
    Then I should see that I logged in "successfully"





