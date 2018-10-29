package local.kor;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by Kor on 26.10.2018.
 */
@CucumberOptions(
        strict = true,
        features = {"src/test/resources/features"},
        glue = "local.kor.stepdifinition"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
