Feature: customer want to checkout

  Scenario: customer choose menu checkout
    Given Room booked by some customer
    When customer choose checkout
    Then Room is empty and bill is printed
