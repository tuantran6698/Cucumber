Feature: Order Product
  Scenario: Verify that user can order successfully
    Given User go to the website1
    When  User select the product that they want to buy1
    And User click to add to cart
    And User click to check out
    Then User can order successfully