package core.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.support.How;

public class Locator {
    private How _type;
    private String _value;
    private By _by;

    public Locator(How type, String value) {

        this._type = type;
        this._value = value;
        this._by = type.buildBy(value);
    }

    public How getType() {
        return _type;
    }

    public String getValue() {
        return _value;
    }

    public By setBy(By by) {
        return _by = by;
    }

    public By getBy() {
        return _by;
    }
}
