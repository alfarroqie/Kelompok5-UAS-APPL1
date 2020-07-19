Feature: customer need a clean clothes
  Scenario: customer choose menu laundry
    Given Room booked by some customer
    When customer choose laundry package
    And customer input the number of clothes
    Then Laundry price is added to rooms bill
