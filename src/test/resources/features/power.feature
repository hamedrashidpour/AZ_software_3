@tag3
  Feature: Power

    Scenario: power an integer value to another integer value
      Given two input values and power operator, 10 2 "^"
      When i power first value to second value
      Then i expect the result to be 100
