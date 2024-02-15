package TestRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features/Login.feature",
		glue = "steps",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty", "html:test-output"}
		)
public class TestRunner {

}
