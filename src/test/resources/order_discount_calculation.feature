Feature: Order Discount Calculation
  As a customer
  I want to receive a discount on my order
  Based on the type of the order

  Scenario: Customer with Bronze level should receive 10% discount
    Given a customer with "Bronze" membership
    When the customer places an order worth 100
    Then the total price should be 90

  Scenario: Customer with Silver level should receive 20% discount
    Given a customer with "Silver" membership
    When the customer places an order worth 100
    Then the total price should be 80

  Scenario: Customer with Gold level should receive 30% discount
    Given a customer with "Gold" membership
    When the customer places an order worth 100
    Then the total price should be 70