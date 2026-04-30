	package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNews {
	public WebDriver driver;

	public ManageNews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement inputText;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@name='un']")
	private WebElement inputSearchString;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement inputSearchButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	private WebElement editButton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement inputtextEdit;
	@FindBy(xpath = "//button[@name='update']")
	private WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement updateAlertMessage;
	@FindBy(xpath = "//i[@class='fas fa-trash-alt']")
	private WebElement deleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteAlertMsg;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	private WebElement searchResultNotExisting;

	public ManageNews addNews(String news) {
		newButton.click();
		inputText.sendKeys(news);
		saveButton.click();
		return this;

	}

	public boolean isAlertDisplayed() {
		return alertMessage.isDisplayed();
	}

	public ManageNews searchNews(String search) {
		searchButton.click();
		inputSearchString.sendKeys(search);
		inputSearchButton.click();
		return this;

	}

	public boolean isTextDisplayed() {
		return searchResultNotExisting.isDisplayed();
	}

	public ManageNews reset() {
		resetButton.click();
		return this;
	}

	public ManageNews updateNews(String update) {
		editButton.click();
		inputtextEdit.clear();
		inputtextEdit.sendKeys(update);
		updateButton.click();
		return this;

	}

	public boolean isUpdateAlertDisplayed() {
		return updateAlertMessage.isDisplayed();
	}

	public ManageNews deleteNews() {
		deleteButton.click();
		driver.switchTo().alert().accept();
		return this;
	}

	public boolean isDeleteAlertDisplayed() {
		return deleteAlertMsg.isDisplayed();
	}
}
