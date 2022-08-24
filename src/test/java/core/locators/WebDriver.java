package core.locators;

import core.common.Utilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import static core.common.Constant.WEBDRIVER;

public class WebDriver {
    public static void openBrowser(String browserName) {
        switch (browserName) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\drivers\\chromedriver.exe");
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--headless");
//                WEBDRIVER = new ChromeDriver(options);
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + "\\drivers\\geckodriver.exe");
                WEBDRIVER = new FirefoxDriver();
                break;
            case "Egde":
                WEBDRIVER = new EdgeDriver();
                break;
            case "IE":
                WEBDRIVER = new InternetExplorerDriver();
                break;
            case "Safari":
                WEBDRIVER = new SafariDriver();
                break;
            default:
                System.out.println(browserName + " cannot define!");
        }
    }
}
