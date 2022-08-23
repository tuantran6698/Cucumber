package StepDefinition;

import core.locators.Locator;
import core.locators.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.testng.IExpectedExceptionsHolder;

import static core.common.BuiltInAction.*;
import static core.locators.WebDriver.openBrowser;

public class orderProductStep {
    private Locator item =new Locator(How.XPATH,"//div[.='Khaki Suede Polish Work Boots Sale  $149.99 Add To Cart']//button[@class='add']");
            Locator cartIcon= new Locator(How.XPATH,"//div[@class='cartitem']");
            Locator emailTxt= new Locator(How.XPATH,"//input[@id='email']");
            Locator frameCard= new Locator(How.XPATH,"//div[@id='card']//iframe");
            Locator cardNumber= new Locator(How.XPATH,"//input[@name='cardnumber']");
            Locator expireDate= new Locator(How.XPATH,"//input[@name='exp-date']");
            Locator CVCField= new Locator(How.XPATH,"//input[@name='cvc']");
            Locator ZIPCode= new Locator(How.XPATH,"//input[@name='postal']");
            Locator payBtn= new Locator(How.XPATH,"//button[@class='pay-with-stripe']");
            Locator orderSuccess=new Locator(How.XPATH,"//div[@class='successsvg']");



    @Given("User go to the website1")
    public void user_go_to_home_website1() {
        openBrowser("Chrome");
        navigateTo("https://demo.gondolatest.com/");
        maximizeWindow();
    }
    @When("User select the product that they want to buy1")
    public void select_product() {
        click(item.getBy());
        click(cartIcon.getBy());
        System.out.println("adding Item successful");

    }
    @When("User click to check out")
    public void user_click_to_check_out() {
        enter(emailTxt.getBy(),"Test@gmail.com");
        switchIframe(frameCard.getBy());
        enter(cardNumber.getBy(),"4242 4242 4242 4242");
        enter(expireDate.getBy(),"08/22");
        enter(CVCField.getBy(),"100");
        enter(ZIPCode.getBy(),"70000");
        System.out.println("Input information successful");
    }
    @Then("User can order successfully")
    public void user_can_order_successfully() {
        switchOutIframe();
        click(payBtn.getBy());
        checkControlExistz(orderSuccess.getBy());
        System.out.println("User can order successfully");
    }
}
