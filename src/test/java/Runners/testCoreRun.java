package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature/testCore.feature",
        glue = {"StepDefinition"},
        plugin = {"json:target/cucumber-report/cucumber.json"}
)

public class testCoreRun extends AbstractTestNGCucumberTests {
}
