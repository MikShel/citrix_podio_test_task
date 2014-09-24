Feature: Sign in
  In order to use the system
  Any registered user
  Should be able to log in

  Scenario Outline: Login Success and Failure
    Given I try to login with "<type>" credentials
    Then I should see that I logged in "<status>"

  Examples:
    | type		| status		|
    | valid		| successfully		|
    | invalid	| unsuccessfully	|




