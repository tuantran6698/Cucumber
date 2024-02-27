package Runners;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature/carouselTest.feature",
        glue = {"StepDefinition"},
        plugin = {"json:target/cucumber-report/cucumber.json"}
)
public class carouselTestRun {
}
