package StepDefinition;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import Utilities.ReadConfig;

//parent class
public class BaseClass {
	
	public static WebDriver driver;
	public LoginPage loginPg;
	public AddNewCustomerPage addNewCustPg;
	public static Logger Log; 
	public ReadConfig readConfig; 
	
	
	
	//Generate unique email Id
	public String generateEmailId() {
		return (RandomStringUtils.randomAlphabetic(5));
	}
	

}
