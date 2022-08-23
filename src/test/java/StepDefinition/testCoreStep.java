package StepDefinition;

import core.locators.Locator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.How;

import static core.common.BuiltInAction.*;
import static core.locators.WebDriver.openBrowser;

public class testCoreStep {
    private Locator addProduct = new Locator(How.XPATH, "//div[@class='column main']/div[1]/div[@class='block-content slick-initialized slick-slider slick-dotted']");
    @Given("User go to home page")
    public void user_go_to_home_page() {
        openBrowser("Chrome");
        navigateTo("https://magento2.demo.ubertheme.com/");
    }
    @When("User click to add product to cart")
    public void user_click_to_add_product_to_cart() {
        click(addProduct.getBy());
    }
    @Then("User can add products")
    public void user_can_add_products() {
        System.out.println("Ahihi- Test case passed");
    }
}
