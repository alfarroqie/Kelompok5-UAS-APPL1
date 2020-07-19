Feature: customer want to order food

  Scenario: customer choose menu order food
    Given List of foods
    When Customer choose a food
    Then Food is ordered and added to room's bill
