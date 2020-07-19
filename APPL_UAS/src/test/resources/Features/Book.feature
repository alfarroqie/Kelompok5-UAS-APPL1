Feature: customer want to book room

  Scenario: customer choose menu book room
    Given List of rooms
    When customer choose a room type
    And empty room si available
    Then Room is booked by customer
