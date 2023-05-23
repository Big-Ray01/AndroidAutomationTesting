Feature: As a user i want to do addition on the calculator

  @test
  Scenario: Check that i can add one digit numbers to the calculator
    Given i open the "Calculator" application
    Then i "div" two numbers "989" and "8"
    And i get answer is "123,625"