package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.LoginOrangeHRM;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefForOrange {
	WebDriver driver=null;
	LoginOrangeHRM orange;
	
	@Given("User launched chrome browser with OrangeHRM Url")
	public void user_launched_chrome_browser_with_orange_hrm_url() {
		orange = new LoginOrangeHRM(driver);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("User enter username and password")
	public void user_enter_username_and_password() {
	    orange.enter_username("Admin");
	    orange.enter_password("admin123");
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
	   orange.clickLogin();
	}

	@Then("User navigated to main page")
	public void user_navigated_to_main_page() throws InterruptedException {
	    Thread.sleep(4000);
	    
	}

}
