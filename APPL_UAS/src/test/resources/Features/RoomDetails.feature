Feature: customer want to know room details

  Scenario: customer choose menu room details
    Given List of menu from the hotels
    When customer choose show room details
    Then Room details is printed
