Feature: Application configuration on Real iOS device

  @Id=201 @Device=IosRealDevice
  Scenario: Play with search - Happy Path
    Given a user sees the Title "Meal name" - FanaticalFood
    When a user taps on the button "Set Default Label Text"
    Then a user sees the Title "Default Text" - FanaticalFood
    When a user types a meal "Hamburger" - FanaticalFood
    Then a user sees the Title "Hamburger" - FanaticalFood