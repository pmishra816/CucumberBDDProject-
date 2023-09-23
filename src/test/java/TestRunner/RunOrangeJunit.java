package TestRunner;

@io.cucumber.testng.CucumberOptions(
		features ={".//Features/LoginOrangeHRM.feature"},//feature file path
		glue ="StepDefinition",//path of step definition package
		dryRun =true,//it will check the code for feature is implemented or not and it is linked correctly
		monochrome = true,//readable format in console
		plugin ={"pretty", "html:target/HTML Cucumber Reports/LoginOrangeHRM.html"}//pretty is format
		)
public class RunOrangeJunit {

}
