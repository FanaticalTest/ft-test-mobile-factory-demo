@Project=MobileApp @Feature=CalculateSum @Customer=Ziridis @TestType=Appium @ProjectId=2 @TestSuite=TBD
Feature: Calculate sum of 2 values

  @Id=B.1.1
  Scenario Outline: Happy path - Sum two values
    When a user is typing the first value "<FirstValue>"
    And a user is typing the second value "<SecondValue>"
    Then a user should see the sum equal to "<SumValue>"
    Examples:
      | FirstValue | SecondValue | SumValue |
      | 5          | 4           | 9        |
      | -2         | -4          | -6       |
      | -5         | 4           | -1       |


  @Id=B.1.2
  Scenario: User tap Show alert and close it
    When a user is tapping Show alert
    And a user is tapping on OK
    Then a user should see in the result sum "SumLabel"
