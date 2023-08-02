package automationframework;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = {"./src/test/java/automationframework/features" }, 
		glue = "automationframework.stepdefinitions", 
		//tags = {"@PostAPISample" },
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
		//plugin = { "pretty", "html:output","json:output/cucumber.json" },
		monochrome = true)
public class RunnerIT {

}