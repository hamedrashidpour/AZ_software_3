@tag2
  Feature: Multiplication

    Scenario: multiple to integer numbers
      Given two input values and Multiplication operator, 10 2 "*"
      When i multiply first value by second value
      Then i expect the result to be 20

    Scenario Outline: multiple to integer numbers
      Given two input values and Multiplication operator, <value1> <value2> <operator>
      When i multiply first value by second value
      Then i expect the result to be <result>
      Examples:
        | value1 | value2 | operator | result |
        | 10     | 2      | "*"      | 20     |
        | 0      | 2      | "*"      | 0      |
        | 100     | 0     | "*"      | 0     |
        | -10     | 2      | "*"      | -20     |
        | 10     | -2      | "*"      | -20     |
        | -10     | -2      | "*"      | 20     |
