@tag3
  Feature: Power

    Scenario: power an integer value to another integer value
      Given two input values and power operator, 10 2 "^"
      When i power first value to second value
      Then i expect the result to be 100
    Scenario Outline: power an integer value to another integer value
      Given two input values and power operator, <value1> <value2> <operator>
      When i power first value to second value
      Then i expect the result to be <result>
      Examples:
        | value1 | value2 | operator | result |
        | 10     | 2      | "^"      | 100    |
        | 0     | 0      | "^"      | 1    |
        | 0     | 2      | "^"      | 0    |
        | 10     | 0      | "^"      | 1    |
        | 10     | -2      | "^"      | 0.01    |
        | -10     | 2      | "^"      | 100    |
        | -10     | -2      | "^"      | 0.01    |
        | -10     | 1      | "^"      | -10    |
        | 10     | 1      | "^"      | 10    |
        | 10     | -1      | "^"      | 0.1    |
        | -10     | -1      | "^"      | -0.1    |
