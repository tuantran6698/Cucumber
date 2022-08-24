package Runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature",
        glue = {"StepDefinition"},
        plugin = {"pretty","json:target/cucumber-report/cucumber.json"}
)
public class RunnersAll extends AbstractTestNGCucumberTests{
}
