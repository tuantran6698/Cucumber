Feature: Cart Test
  Scenario: Verify that user can add product to cart successfully
    Given User go to the website
    When  User select the product that they want to buy
    And User click to add to cart
    Then User can see the correct product that they added

  Scenario: Verify that user can not add existed product to cart successfully
    Given User go to the website
    When  User select the product that they want to buy
    And User click to add to cart
    Then User can not add existed product with warning message

  Scenario: Verify that user can buy product with correct price
    Given User go to the website
    When  User select the product that they want to buy
    And User click to add to cart
    Then User can buy product with correct price

  Scenario: Verify that user can delete the product from shopping cart
    Given User go to the website
    When  User select the product that they want to buy
    And User click to add to cart
    And User go to the shopping cart page
    And User click to delete product
    Then User can delete the product from shopping cart