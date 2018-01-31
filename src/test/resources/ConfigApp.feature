Feature: Application configuration on Real Android device

  @Id=101 @Device=AndroidRealDevice
  Scenario: Display name setup - Happy Path
    Given a user should see the link "General" - AndroidConfigApp
    When a user is taping on "General" menu - AndroidConfigApp
    Then a user should see the link "Display name" - AndroidConfigApp
    When a user is taping on "Display name" menu - AndroidConfigApp
    Then a user should see the textbox with "John Smith" - AndroidConfigApp
    And a user is changing the Display name to "Toto" - AndroidConfigApp
    And a user is taping on "OK" menu - AndroidConfigApp
    When a user should see the link "Display name" - AndroidConfigApp
    Then a user is taping on "Display name" menu - AndroidConfigApp
    And a user should see the textbox with "Toto" - AndroidConfigApp
    When a user is changing the Display name to "John Smith" - AndroidConfigApp
    Then a user is taping on "OK" menu - AndroidConfigApp

  @Id=102 @Device=AndroidRealDevice
  Scenario: Enable social recommendations - Happy Path
    Given a user should see the link "General" - AndroidConfigApp
    When a user is taping on "General" menu - AndroidConfigApp
    Then a user should see the link "Display name" - AndroidConfigApp
    When a user is taping on "Switch enabling social recommendations" menu - AndroidConfigApp
