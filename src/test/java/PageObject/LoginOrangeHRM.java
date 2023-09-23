package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginOrangeHRM {
	WebDriver driver;
	
	By txt_username=By.xpath("//input[@placeholder='Username']");
	By txt_password=By.xpath("//input[@placeholder='Password']");
	By btn_login=By.xpath("//button[@type='submit']");
	
	
	public LoginOrangeHRM(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	public void enter_username(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}
	public void enter_password(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}
	public void clickLogin() {
		driver.findElement(btn_login).click();
	}
}
