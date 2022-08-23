package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class cartSteps {
    @Given("User go to the website")
    public void user_go_to_the_website() {
        System.out.println("User go to the website");
    }
    @When("User select the product that they want to buy")
    public void user_select_the_product_that_they_want_to_buy() {
        System.out.println("User select the product that they want to buy");
    }
    @When("User click to add to cart")
    public void user_click_to_add_to_cart() {
        System.out.println("User click to add to cart");
    }
    @Then("User can see the correct product that they added")
    public void user_can_see_the_correct_product_that_they_added() {
        System.out.println("User can see the correct product that they added");
    }
    @Then("User can buy product with correct price")
    public void user_can_buy_product_with_correct_price() {
        System.out.println("User can buy product with correct price");
    }
    @When("User go to the shopping cart page")
    public void user_go_to_the_shopping_cart_page() {
        System.out.println("User go to the shopping cart page");
    }
    @When("User click to delete product")
    public void user_click_to_delete_product() {
        System.out.println("User click to delete product");
    }
    @Then("User can delete the product from shopping cart")
    public void user_can_delete_the_product_from_shopping_cart() {
        System.out.println("User can delete the product from shopping cart");
    }
    @Then("User can not add existed product with warning message")
    public void user_can_not_add_existed_product_with_warning_message() {
        System.out.println("User can not add existed product with warning message");
    }
}
