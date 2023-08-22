package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {

	public WebDriver ldriver;// Global Webdriver

	// constructor
	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);// Used Page Factory to Find the elements on a page
	}

	// Find web elements on the web page
	@FindBy(xpath = "//p[normalize-space()='Customers']//i[contains(@class,'right fas fa-angle-left')]")
	WebElement lnkCustomers_menu;

	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement lnkCustomers_menuitem;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement btnAddnew;

	/////////////////////////// Add New Customer Page//////////////////////////

	@FindBy(xpath = "//input[@id='Email']")
	WebElement txtEmail;// EMail

	@FindBy(xpath = "//input[@id='Password']")
	WebElement txtPassword;// password

	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement txtFirstName;// FirstName

	@FindBy(xpath = "//input[@id='LastName']")
	WebElement txtLastName;// LastName

	@FindBy(id = "Gender_Male")
	WebElement MaleGender;// Gender Male

	@FindBy(id = "Gender_Female")
	WebElement FeMaleGender;

	@FindBy(xpath = "//input[@id='DateOfBirth']")
	WebElement txtDob;// DOB

	@FindBy(xpath = "//input[@id='Company']")
	WebElement txtCompanyName;// Company name

	@FindBy(xpath = "//input[@id='IsTaxExempt']")
	WebElement checkTaxExempt;// Tax Exempt

	@FindBy(xpath = "//div[@class='input-group-append']//div[@role='listbox']")
	WebElement dropdownNewsletter;// Newsletter

	@FindBy(xpath = "//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover k-state-focused k-state-border-down']//div[@role='listbox']")
	WebElement dropdownCustomerRoles;// Customer Roles

	@FindBy(xpath = "//select[@id='VendorId']")
	WebElement dropdownVendorMgr;// Vendor Manager

	@FindBy(xpath = "//input[@id='Active']")
	WebElement checkActive;// Active

	@FindBy(xpath = "//textarea[@id='AdminComment']")
	WebElement txtAdminContent;// Admin comment

	@FindBy(xpath = "//button[@name='save']")
	WebElement btnSave;// save button

	/////////////////////////// Actions Methods for Web Elements

	public String getPageTitle() {
		return ldriver.getTitle();
	}

	public void clickOnCustomersMenu() {
		lnkCustomers_menu.click();
	}

	public void clickOnCustomersMenuItem() {
		lnkCustomers_menu.click();
		lnkCustomers_menuitem.click();
	}

	public void clickOnAddnew() {
		btnAddnew.click();
	}

	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void enterFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}

	public void enterDob(String dob) {
		txtDob.sendKeys(dob);
	}

	public void enterCompanyName(String coName) {
		txtCompanyName.sendKeys(coName);
	}
	
	public void IsTaxExempt() {
		checkTaxExempt.click();
	}
	
	public void Active() {
		checkActive.click();
	}

	public void AdminComment() {
		txtAdminContent.sendKeys("NA");
		
	}
	/*
	 * public void enterCustomerRoles(String role) {
	 * 
	 * }
	 */

	public void enterManagerOfVendor(String value) {
		Select drp = new Select(dropdownVendorMgr);
		drp.selectByVisibleText(value);
	}

	public void enterGender(String gender) {
		if (gender.equals("Male")) {
			MaleGender.click();
		} else if (gender.equals("Female")) {
			FeMaleGender.click();
		} else// default set Male gender
		{
			MaleGender.click();
		}

	}

	public void clickOnSave() {
		btnSave.click();
	}

}
