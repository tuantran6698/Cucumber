package Runners;
 import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/test/resources/feature/swaglabsTest.feature",
        glue = {"StepDefinition"},
        plugin = {"json:target/cucumber-report/cucumber.json"}
)
public class swaglabsTestRun {
}
