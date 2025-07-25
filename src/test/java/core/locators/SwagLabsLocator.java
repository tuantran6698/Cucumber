package core.locators;
import core.locators.Locator;
import org.openqa.selenium.support.How;

public class SwagLabsLocator {
    public static Locator username = new Locator(How.XPATH, "//input[@id='user-name']");
    public static Locator password = new Locator(How.XPATH, "//input[@id='password']");
    public static Locator loginButton = new Locator(How.XPATH, "//input[@id='login-button']");
    public static Locator addToCartButton = new Locator(How.XPATH, "//button[@id='add-to-cart-sauce-labs-backpack']");
    public static Locator cartPage = new Locator(How.XPATH, "//div[@id='shopping_cart_container']");
    public static Locator cartList= new Locator(How.XPATH, "//div[@class='cart_list']");
    public static Locator removeButton = new Locator(How.XPATH, "//button[@id='remove-sauce-labs-backpack']");
    public static Locator emptyCartPage = new Locator(How.XPATH, "//div[@class='removed_cart_item']");
    public static Locator firstName = new Locator(How.XPATH, "//input[@id='first-name']");
    public static Locator lastName = new Locator(How.XPATH, "//input[@id='last-name']");
    public static Locator postalCode = new Locator(How.XPATH, "//input[@id='postal-code']");
    public static Locator checkoutPage = new Locator(How.XPATH, "//button[@id='checkout']");
    public static Locator continueButton = new Locator(How.XPATH, "//input[@id='continue']");
    public static Locator finishButton = new Locator(How.XPATH, "//button[@id='finish']");

}

