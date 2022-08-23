package core.environment;

public enum DriverType {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge"),
    IE11("ie11"),
    SAFARI("safari"),
    CHROME_MOBILE("chrome mobile"),
    NATIVE_MOBILE("native");

    private final String value;

    DriverType(String value) {

        this.value = value;
    }

    public String getValue() {

        return value;
    }
}
