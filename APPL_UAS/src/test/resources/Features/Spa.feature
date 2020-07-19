Feature: customer want to order a spa

  Scenario: customer choose spa from menu
    Given List of spa packages
    When Customer choose spa package
    Then Spa is added to the bill
