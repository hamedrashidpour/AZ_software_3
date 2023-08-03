@tag
  Feature: Division

    Scenario: Division of two positive integer numbers
      Given two input values and operator, 10 2 "/"
      When i Divide first value by second value
      Then i expect the result to be 5

    Scenario Outline: Division of two positive integer numbers
      Given two input values and operator, <value1> <value2> <operator>
      When i Divide first value by second value
      Then i expect the result to be <arg0>
      Examples:
        | value1 | value2 | operator | arg0 |
        | 56     | 4      | "/"      | 14.0 |

