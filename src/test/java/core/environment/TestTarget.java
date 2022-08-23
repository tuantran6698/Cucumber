package core.environment;

public enum TestTarget {
    UNSUPPORTED,
    NATIVE,
    CHROME,
    FIREFOX,
    EDGE;// other here...

    public static TestTarget fromString(String mode) {

        if ("chrome".equalsIgnoreCase(mode)) {
            return TestTarget.CHROME;
        }
        if ("firefox".equalsIgnoreCase(mode)) {
            return TestTarget.FIREFOX;
        }
        if ("native".equalsIgnoreCase(mode)) {
            return TestTarget.NATIVE;
        }
        return TestTarget.UNSUPPORTED;
    }

    public DriverType toDriverType() {

        if (this == NATIVE) {
            return DriverType.NATIVE_MOBILE;
        }
        if (this == CHROME) {
            return DriverType.CHROME;
        }
        if (this == FIREFOX) {
            return DriverType.FIREFOX;
        }
        if (this == EDGE) {
            return DriverType.EDGE;
        }
        return null;
    }

    public String toString() {

        return this.name().toLowerCase();
    }
}
