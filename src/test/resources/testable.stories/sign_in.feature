Feature: Sign in
  In order to use the system
  Any registered user
  Should be able to log in
  @Tests
  Scenario: I should be able to log in
    Given I sign in as "nick@fd.com"
    Then I should see landing page

  Scenario: Remember email on the login form
    Given I want to remember my login "nick@fd.com" after sign in
    When I sign out from application
    Then I see login page with pre-populated email "nick@fd.com"

  Scenario: I should be able to update my data after first sign-in
    Given I sign in as "fred@fd.com" first time
    When I should see profile pop-up
    And I change my "name" on "Greg"
    Then I can see "Greg" on profile page