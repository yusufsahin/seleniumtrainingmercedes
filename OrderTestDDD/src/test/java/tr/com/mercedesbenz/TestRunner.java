package tr.com.mercedesbenz;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features ="src/test/resources/features",
        glue = "tr.com.mercedesbenz",
        plugin={"pretty", "html:target/cucumber-reports"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
