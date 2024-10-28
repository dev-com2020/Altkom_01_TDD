Feature: Order Discount Calculation
  As a customer
  I want to receive a discount on my order
  Based on the type of the order

  Scenario Outline: Customer with Gold level should receive discount
    Given a customer with "<membership>" membership
    When the customer places an order worth <order>
    Then the total price should be <total>

    Examples:
    | membership  | order | total |
    | Gold        | 100   | 70    |
    | Silver      | 100   | 80    |
    | Bronze      | 100   | 90    |