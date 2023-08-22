package TestRunner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features ={".//Features/LoginFeature.feature"},//feature file path
		glue ="StepDefinition",//path of step definition package
		dryRun =false,//it will check the code for feature is implemented or not and it is linked correctly
		monochrome = false,//readable format in console
		tags="@Sanity or @Regression",//Scenarios under Smoke tag will be executed
		plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class RunForExtentReport {

}
