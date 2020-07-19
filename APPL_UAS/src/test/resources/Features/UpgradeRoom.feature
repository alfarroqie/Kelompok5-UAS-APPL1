Feature: customer want to upgrade room

  Scenario: customer room is Deluxe
    Given Room booked by some customer
    When customer choose new room number
    Then Old room is empty and new room is occupied by Customer

  Scenario Outline: Customer room is Luxury
    Then Cant upgrade room
