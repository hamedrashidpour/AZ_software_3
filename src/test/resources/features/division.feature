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
        | 8      | 2      | "/"      | 4    |
        | 100      | 5      | "/"      | 20    |
        | 0     | 8      | "/"      | 0   |
        | 2000      | 100      | "/"      | 20    |
        | 1      | 1      | "/"      | 1    |

    Scenario: Division of to negative integer numbers
      Given two input values and operator, -10 2 "/"
      When i Divide first value by second value
      Then i expect the result to be -5

    Scenario Outline: Division of to negative integer numbers
      Given two input values and operator, <value1> <value2> <operator>
      When i Divide first value by second value
      Then i expect the result to be <result>
      Examples:
        | value1 | value2 | operator | result |
        | -10    | 2      | "/"      | -5     |
        | 0    | -2      | "/"      | 0     |
        | -10    | -2      | "/"      | 5     |
        | 10    | -2      | "/"      | -5     |

    Scenario: Division by Zero
      Given two input values and operator, -10 0 "/"
      When i Divide first value by second value
      Then i expect the result to be "cant divide by zero"




