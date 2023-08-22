package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;//Created Global local webDriver ldriver
	
	public LoginPage(WebDriver rDriver)//remote webdriver rDriver
	{
		ldriver=rDriver;
		
		PageFactory.initElements(rDriver, this);//Used Page Factory to Find the elements on a page
	}
	
	@FindBy(id = "Email")//used path for user name web element
	WebElement email;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@class='button-1 login-button']")//used x path for login button
	WebElement LoginBtn;
	
	@FindBy(linkText = "Logout")
	WebElement logout;
	
	public void enterEmail(String emailAdd) throws InterruptedException
	{
		email.clear();
		Thread.sleep(2000);
		email.sendKeys(emailAdd);
	}
	public void enterPassword(String pwd) throws InterruptedException
	{
		password.clear();
		password.sendKeys(pwd);
	}
	public void clickOnLoginButton() throws InterruptedException
	{
		Thread.sleep(2000);
		LoginBtn.click();
	}
	public void clickOnLogOutButton() throws InterruptedException
	{
		Thread.sleep(2000);
		logout.click();
	}
}