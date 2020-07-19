Feature: customer want to know room availability

  Scenario: customer choose menu room availability
    Given List of menu from the hotels
    When customer choose show room availability
    Then Room availability is printed
