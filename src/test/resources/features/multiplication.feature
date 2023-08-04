@tag2
  Feature: Multiplication

    Scenario: multiple to integer numbers
      Given two input values and Multiplication operator, 10 2 "*"
      When i multiply first value by second value
      Then i expect the result to be 20
