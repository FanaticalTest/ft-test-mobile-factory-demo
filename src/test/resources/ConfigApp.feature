Feature: Application configuration on Real Android device

  @Id=101 @Device=AndroidRealDevice
  Scenario: General configuration - Happy Path
    Given a user should see the link "General" - AndroidConfigApp
    When a user is taping on "General" menu - AndroidConfigApp
    Then a user should see the link "Display name" - AndroidConfigApp
    When a user is taping on "Display name" menu - AndroidConfigApp
