Feature: Calculate sum of 2 values

  @Id=001 @Device=IosSimulator
  Scenario Outline: Happy path - Sum two values
    When a user is typing the first value "<FirstValue>"
    And a user is typing the second value "<SecondValue>"
    Then a user should see the sum equal to "<SumValue>"
    Examples:
      | FirstValue | SecondValue | SumValue |
      | 5          | 4           | 9        |
      | -2         | -4          | -6       |
      | -5         | 4           | -1       |

  @Id=002 @Device=IosSimulator
  Scenario: User tap Show alert and close it
    When a user is tapping Show alert
    And a user is tapping on OK
    Then a user should see the link "show alert"

  @Id=003 @Device=IosSimulator
  Scenario: User use the slider and set a value
    When a user move the slider to the value "0.2"
    Then the value returned is "0.2"