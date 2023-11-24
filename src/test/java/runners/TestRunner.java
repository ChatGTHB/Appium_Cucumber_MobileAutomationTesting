package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Smoke",
        features = {"src/test/java/featureFiles"},
        glue = {"stepDefinitions"}
)

public class TestRunner extends AbstractTestNGCucumberTests{
}