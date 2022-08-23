package Runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature/orderProductTest.feature",
        glue = {"StepDefinition"},
        plugin = {"pretty","json:target/cucumber-report/cucumber.json"}
)
public class orderProductRun extends AbstractTestNGCucumberTests {
}
