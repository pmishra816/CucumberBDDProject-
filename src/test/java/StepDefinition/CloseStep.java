package StepDefinition;

import io.cucumber.java.en.And;

public class CloseStep extends BaseClass {

	
	@And("close browser")
	public void close_browser() {
		Log.info("Browser is closed");
		driver.close();
		//driver.quit();
	}
}
