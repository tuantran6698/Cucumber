package StepDefinition;
import core.locators.SwagLabsLocator; 
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.AfterTest;
import static core.common.BuiltInAction.*;
import static core.locators.WebDriver.openBrowser;
public class swaglabsTestSteps {

    @Given("User is on the login page")
    public void userIsOnLoginPage(){
        openBrowser("Chrome");
         navigateTo("https://www.saucedemo.com/");
        checkControlExistz(SwagLabsLocator.username.getBy());
        checkControlExistz(SwagLabsLocator.password.getBy());
        checkControlExistz(SwagLabsLocator.loginButton.getBy());
    }

    @When("User enters valid username and password")
    public void userEntersValidCredentials() {
        enter(SwagLabsLocator.username.getBy(), "standard_user");
        enter(SwagLabsLocator.password.getBy(), "secret_sauce");
        click(SwagLabsLocator.loginButton.getBy());
    }

    @Then("User should be redirected to the products page")
    public void userIsRedirectedToaddToCartButton() {
        checkControlExistz(SwagLabsLocator.addToCartButton.getBy());
    }


    @Given("User is on the products page")
    public void User_is_on_the_products_page() {
        checkControlExistz(SwagLabsLocator.addToCartButton.getBy());
    }

    @When("User adds a product to the cart")
    public void User_adds_a_product_to_the_cart() {
        click(SwagLabsLocator.addToCartButton.getBy());
        checkControlExistz(SwagLabsLocator.cartPage.getBy());
        click(SwagLabsLocator.cartPage.getBy());
    }

    @Then("User should see the product in the cart")
    public void User_should_see_the_product_in_the_cart() {
        checkControlExistz(SwagLabsLocator.cartList.getBy());
    }

    @Given("User has a product in the cart")
    public void User_has_a_product_in_the_cart() {
    click(SwagLabsLocator.cartPage.getBy());
    checkControlExistz(SwagLabsLocator.cartList.getBy());
    
    }

    @When("User removes the product from the cart")
    public void User_removes_the_product_from_the_cart() {
        click(SwagLabsLocator.removeButton.getBy());
    }

    @Then("User should see an empty cart")
    public void User_should_see_an_empty_cart() {
        checkControlExistz(SwagLabsLocator.emptyCartPage.getBy());
    }
    @Given("User has products in the cart")
    public void User_has_products_in_the_cart() {
        openBrowser("Chrome");
        navigateTo("https://www.saucedemo.com/");
        enter(SwagLabsLocator.username.getBy(), "standard_user");
        enter(SwagLabsLocator.password.getBy(), "secret_sauce");
        click(SwagLabsLocator.loginButton.getBy());
        click(SwagLabsLocator.addToCartButton.getBy());
        checkControlExistz(SwagLabsLocator.cartPage.getBy());
        click(SwagLabsLocator.cartPage.getBy());
    }

    @When("User proceeds to checkout and completes the purchase")
    public void User_proceeds_to_checkout_and_completes_the_purchase() {
        click(SwagLabsLocator.checkoutPage.getBy());
        enter(SwagLabsLocator.firstName.getBy(), "John");
        enter(SwagLabsLocator.lastName.getBy(), "Doe");
        enter(SwagLabsLocator.postalCode.getBy(), "12345");
        click(SwagLabsLocator.continueButton.getBy());
        
    }
    @Then("User should see a confirmation message for successful purchase")
    public void User_should_see_a_confirmation_message_for_successful_purchase() {
        checkControlExistz(SwagLabsLocator.finishButton.getBy());
        click(SwagLabsLocator.finishButton.getBy());
    }
    @AfterTest
    public void tearDown() {
        close();
    }
}