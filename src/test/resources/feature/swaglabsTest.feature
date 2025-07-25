Feature: Swag Labs Test
    Scenario: Verify that the user can log in with valid credentials
        Given User is on the login page
        When User enters valid username and password
        Then User should be redirected to the products page
    
    Scenario: Verify that the user can add a product to the cart
        Given User is on the products page
        When User adds a product to the cart
        Then User should see the product in the cart

    Scenario: Verify that the user can remove a product from the cart
        Given User has a product in the cart
        When User removes the product from the cart
        Then User should see an empty cart

    Scenario: Verify that the user can complete a purchase
        Given User has products in the cart
        When User proceeds to checkout and completes the purchase
        Then User should see a confirmation message for successful purchase