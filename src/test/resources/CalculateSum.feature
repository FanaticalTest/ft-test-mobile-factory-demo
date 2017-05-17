Feature: Calculate sum of 2 values

  Scenario: Happy path - Sum two values
    When a user is typing the first value "5"
    And a user is typing the second value "4"
    Then the user should see the sum equal to "9"