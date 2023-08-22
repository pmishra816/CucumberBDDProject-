package StepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.codehaus.plexus.util.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.common.io.Files;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass {

	@Before
	public void setup() throws IOException {
		readConfig=new ReadConfig();
		Log=LogManager.getLogger("StepDef");//Initialize Logger
		System.out.println("Setup method exicuted");
		String browser=readConfig.getBrowser();
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
			
		default:
			driver = null;
			break;
		}
		Log.fatal("Setup Executed");
	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		loginPg = new LoginPage(driver);
		addNewCustPg = new AddNewCustomerPage(driver);
		Log.info("Chrome launched");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		Log.info("Url Entered");
		
	}

	@And("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String password) throws InterruptedException {
		loginPg.enterEmail(emailAdd);

		loginPg.enterPassword(password);
		Log.info("Entered Email and password");
	}

	@And("Click on Login")
	public void click_on_login() throws InterruptedException {
		loginPg.clickOnLoginButton();
		Log.info("Clicked on login page");
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();

		if (actualTitle.equals(expectedTitle)) {
			Log.info("Page title matched");
			Assert.assertTrue(true);// pass
		} else {
			Log.info("Page title not matched");
			Assert.assertTrue(false);// fail
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		loginPg.clickOnLogOutButton();
		Log.info("Clicked on logout link");
	}

	////////////////////////// Add New Customer/////////////////////////////////

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";
		if (actualTitle.equals(expectedTitle)) {
			Log.warn("User can view Dashboard test passed");
			Assert.assertTrue(true);
		} else {
			Log.warn("User can view Dashboard test failed");
			Assert.assertTrue(false);
		}
	}

	@When("User clicks on customer Menu Item")
	public void user_clicks_on_customer_menu_item() {
		addNewCustPg.clickOnCustomersMenu();
		addNewCustPg.clickOnCustomersMenuItem();
		Log.info("Customer menu clicked");
	}

	@And("Click on Add new button")
	public void click_on_add_new_button() {
		addNewCustPg.clickOnAddnew();
		Log.info("Cicked on add new button");
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";
		if (actualTitle.equals(expectedTitle)) {
			Log.info("User can view Add new customer page-passed");
			Assert.assertTrue(true);// pass
		} else {
			Log.info("User can view Add new customer page-failed");
			Assert.assertTrue(false);// fail
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {

		addNewCustPg.enterEmail(generateEmailId() + "@gmail.com");
		addNewCustPg.enterPassword("Test1");
		addNewCustPg.enterFirstName("Prachi");
		addNewCustPg.enterLastName("dubey");
		addNewCustPg.enterGender("Male");
		addNewCustPg.enterDob("09/14/1996");
		addNewCustPg.enterCompanyName("Ubisoft");
		addNewCustPg.IsTaxExempt();
		addNewCustPg.enterManagerOfVendor("Vendor 2");
		addNewCustPg.Active();
		addNewCustPg.AdminComment();
		
		Log.info("Customer information entered");

	}

	@And("click on Save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSave();
		Log.info("Clicked on save button");
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg) {
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if (bodyTagText.contains(expectedConfirmationMsg)) {
			Log.info("User can view confirmation message-passed");
			Assert.assertTrue(true);
		} else {
			Log.info("User can view confirmation message-failed");
			Assert.assertTrue(false);
		}

	}

	/*@After
	public void teardown(Scenario sc) throws IOException {
		System.out.println("TearDown method executed");
		if(sc.isFailed()==true)
		{
			String filepath="C:\\Users\\Prashant\\git\\repository2\\CucumberFramework\\ScreenShot\\FaliedSS.png";
			TakesScreenshot ss = (TakesScreenshot)driver;
			File src = ss.getScreenshotAs(OutputType.FILE);
			File dst = new File(filepath);
			FileUtils.copyFile(src, dst);
			Log.info("teardown executed and Screen shot taken");
		}
	}*/
		
	public void addScreenshot(Scenario scenario) {
		
		final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		//attach image file report(data,media,type,name of the attachment)
		scenario.attach(screenshot, "image/png", scenario.getName());
	}
	
}
