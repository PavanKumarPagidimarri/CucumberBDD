package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features",
                 glue= {"org.App.stepdefs"},
                 plugin = {"pretty", "html:target/cucumber-reports",  "json:target/cucumber.json"},
                 monochrome = true,
                 publish = true
)
//extend AbstractTestNGCucumberTests is using to run tests in parallel mode
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
