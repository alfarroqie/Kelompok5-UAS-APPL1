Feature: customer want to do fitness
  Scenario: customer choose menu fitness
    Given Room booked by some customer
    When customer choose fitness package
    Then package price is added to rooms bill
