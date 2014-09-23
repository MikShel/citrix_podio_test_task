Feature: Sign in
  In order to use the system
  Any registered user
  Should be able to log in
  @Tests
  Scenario: I should be able to log in
    Given I sign in as "nick@fd.com"
    Then I should see landing page
