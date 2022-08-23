package core.common;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static core.common.BuiltInAction.maximizeWindow;
import static core.common.BuiltInAction.navigateTo;
import static core.common.Constant.AUT_URL;
import static core.locators.WebDriver.openBrowser;
import static core.common.BuiltInAction.quit;

public class TestBase {

//    @BeforeMethod
//    public void Startup() {
//        openBrowser("Chrome");
//        navigateTo(AUT_URL);
//        maximizeWindow();
//    }
//
//    @AfterMethod
//    public void ClearUp() {
//        quit();
//    }
}
