Feature: ManagePost
  In order to use the system
  Any registered user
  Should be able to manage posts in Active stream

  Background:
    Given I work with the system

  @test
  Scenario Outline: Create post in active stream
    Given I create status post with "<attach>" attachment for "<space>"
    Then The post should appear in stream with "<attach>"

  Examples: possible attachments for Employee Network space
    | attach    | space            |
    | link	    | Employee Network |
    | question	| Employee Network |
    | no        | Employee Network |




