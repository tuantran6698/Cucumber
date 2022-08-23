package core.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.support.How;

public class LocatorLoader {

    public static By getByLocator(How type, String value){
        return type.buildBy(value);
    }
}
