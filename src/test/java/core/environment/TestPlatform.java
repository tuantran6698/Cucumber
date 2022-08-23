package core.environment;

public enum TestPlatform {
    UNSUPPORTED,
    ANDROID,
    IOS,
    WINDOWS,
    LINUX,
    MAC;

    public static TestPlatform fromString(String mode) {

        if ("windows".equalsIgnoreCase(mode)) {
            return TestPlatform.WINDOWS;
        }
        if ("linux".equalsIgnoreCase(mode)) {
            return TestPlatform.LINUX;
        }
        if ("mac".equalsIgnoreCase(mode)) {
            return TestPlatform.MAC;
        }
        if ("android".equalsIgnoreCase(mode)) {
            return TestPlatform.ANDROID;
        }
        if ("ios".equalsIgnoreCase(mode)) {
            return TestPlatform.IOS;
        }

        return TestPlatform.UNSUPPORTED;
    }

    public String toString() {
        return this.name().toLowerCase();
    }
}
