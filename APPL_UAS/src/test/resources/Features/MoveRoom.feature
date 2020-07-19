Feature: customer want to change room

  Scenario: customer choose menu change room
    Given Room booked by some customer
    When customer choose new room number
    Then Old room is empty and new room is occupied by Customer
