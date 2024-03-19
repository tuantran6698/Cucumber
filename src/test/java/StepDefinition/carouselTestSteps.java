package StepDefinition;
import core.locators.Locator;
import core.locators.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.How;
import org.testng.annotations.AfterTest;

import static core.common.BuiltInAction.*;
import static core.locators.WebDriver.openBrowser;
public class carouselTestSteps {
    private Locator slide1 = new Locator( How.XPATH,"//section[@itemtitle ='Slide 1']");
    private Locator slide2 = new Locator( How.XPATH,"//section[@itemtitle ='Slide 2']");
    private Locator nextBtn = new Locator (How.XPATH,"//button[@data-bi-ecn='Carousel Forward']");
    private Locator backBtn = new Locator (How.XPATH,"//button[@data-bi-ecn='Carousel Back']");


    @Given("User access to the website")
    public void user_access_to_the_website() {

        openBrowser("chrome");
        navigateTo("https://www.microsoft.com/vi-vn/");
        maximizeWindow();
    }

    @When("User wait till the carousel change slide")
    public void user_wait_till_the_carousel_change_slide() {
        waitForElement(slide1.getBy(),30);
        checkControlExistz(slide1.getBy());
    }

    @Then("User can see the slide has been changed")
    public void user_can_see_the_slide_has_been_changed() {
        waitForElement(slide2.getBy(),25);
        checkControlExistz(slide2.getBy());
        quit();
    }

    @When("User click on the next button")
    public void User_click_on_the_next_button() {
        waitForElement(slide1.getBy(),30);
        checkControlExistz(slide1.getBy());
        click(nextBtn.getBy());
    }

    @Then("User can see the slide has been changed to next slide")
    public void user_can_see_the_slide_has_been_changed_to_the_next_slide() {
        waitForElement(slide2.getBy(),25);
        checkControlExistz(slide2.getBy());
        quit();
    }
    @When("User click on the back button")
    public void User_click_on_the_back_button() {
        waitForElement(slide1.getBy(),30);
        checkControlExistz(slide1.getBy());
        click(nextBtn.getBy());
        checkControlExistz(slide2.getBy());
        click(backBtn.getBy());
    }

    @Then("User can see the slide has been changed to last slide")
    public void user_can_see_the_slide_has_been_changed_to_the_last_slide() {
        checkControlExistz(slide1.getBy());
        quit();
    }
}
