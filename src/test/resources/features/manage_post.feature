Feature: ManagePost
  In order to use the system
  Any registered user
  Should be able to manage posts in Active stream

  Background:
    Given I work with the system


  Scenario Outline: Create post in active stream
    Given I create status post with "<attach>" attachment for "<space>"
    Then The post should appear in stream with "<attach>"

  Examples:
    | attach    | space            |
    | link	    | Employee Network |
    | question	| Employee Network |
    | no        | Employee Network |


  Scenario Outline: Manage workspace
    Given I want to create status post for "<space>"
    And I "<action>" "<space>"
    Then The post should appear in stream with "no"
    And The workspace of the post should be "<space>"


  Examples:
    | space     |action         |
    | Employee Network | choose |
    | Projects	| choose |
    | New Workspace| ceate |


  Scenario Outline: Add comment to the post
    Given I create status post with "no" attachment for "Employee Network"
    And The post should appear in stream with "no"
    And I add comment with "<attach>"
    Then Comment should appear in active stream with "<attach>" attachment

  Examples:
    | attach    |
    | link	    |
    | question	|
    | file      |
    | no        |




