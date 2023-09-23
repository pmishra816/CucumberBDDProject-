package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Demo {
	
	WebDriver driver=null;
	@BeforeTest
	public void setUpTest() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void googleSearch() {
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Automation Step by Step");
		driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).sendKeys(Keys.RETURN);
	}
	@Test(dependsOnMethods="googleSearch")
	public void clickOnLink() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Automation Step by Step: NEVER STOP LEARNING")).click();
		Thread.sleep(2000);
		
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
