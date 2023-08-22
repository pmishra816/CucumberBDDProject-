package TestRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features ={".//Features/LoginFeature.feature"},//feature file path
		glue ="StepDefinition",//path of step definition package
		dryRun =false,//it will check the code for feature is implemented or not and it is linked correctly
		monochrome = false,//readable format in console
		tags="@Sanity or @Regression",//Scenarios under Smoke tag will be executed
		plugin ={"pretty", "html:target/HTML Cucumber Reports/LoginFeaturereport1.html"}//pretty is format
		)
public class RunTestNG extends AbstractTestNGCucumberTests{

}
