package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.GeneralUtilities;

public class ManageContacts {
	public WebDriver driver;
	FakerUtility fake = new FakerUtility();
	GeneralUtilities general = new GeneralUtilities();

	public ManageContacts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")
	private WebElement Editbutton;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneNumberField;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;
	@FindBy(xpath = "//textarea[@id='content' and @name='address']")
	private WebElement addressField;
	@FindBy(xpath = "//textarea[@id='content' and @name='del_time']")
	private WebElement DeliveryTime;
	@FindBy(xpath = "//input[@name='del_limit']")
	private WebElement DeliveryChargeLimit;
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertmessage;

	public ManageContacts updateContacts(String DT, String DCT) {
		Editbutton.click();
		String phoneno = fake.generatePhone();
		phoneNumberField.clear();
		phoneNumberField.sendKeys(phoneno);
		String email = fake.generateEmail();
		emailField.clear();
		emailField.sendKeys(email);
		String address = fake.generateAddress();
		addressField.clear();
		addressField.sendKeys(address);
		DeliveryTime.clear();
		DeliveryTime.sendKeys(DT);
		DeliveryChargeLimit.clear();
		DeliveryChargeLimit.sendKeys(DCT);
		general.clickJavaScriptExecutor(updateButton, driver);
		return this;

	}

	public boolean isAlertDisplayed() {
		return alertmessage.isDisplayed();
	}
}
