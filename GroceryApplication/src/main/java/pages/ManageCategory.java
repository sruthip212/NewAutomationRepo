package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.GeneralUtilities;

public class ManageCategory {
	public WebDriver driver;
	FileUploadUtility file = new FileUploadUtility();
	GeneralUtilities general = new GeneralUtilities();

	public ManageCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement inputCategory;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement choosefile;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement SaveButton;
	@FindBy(xpath = "//li[@id='134-selectable']")
	private WebElement discountElement;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessage;
	@FindBy(xpath = "//input[@name='top_menu' and @value='yes']")
	private WebElement radioButtonTopMenu;
	@FindBy(xpath = "//input[@name='show_home' and @value='yes']")
	private WebElement radioButtonLeftMenu;
	@FindBy(xpath = "//i[@class=' fa fa-search']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@placeholder='Category']")
	private WebElement inputSearchCategoryText;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement saveSearchButton;
	@FindBy(xpath = "//span[@id='res']")
	private WebElement seacrchAlertMsg;
	@FindBy(xpath = "//i[@class='fas fa-trash-alt']")
	private WebElement deleteCategory;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement dltAlertMessage;

	public ManageCategory addCategory(String catrgory) {
		newButton.click();
		inputCategory.sendKeys(catrgory + general.generateCurrentDateAndTime());
		discountElement.click();

		if (!radioButtonTopMenu.isSelected()) {
			radioButtonTopMenu.click();
		}

		else {
			radioButtonTopMenu.click();
		}
		if (radioButtonLeftMenu.isSelected()) {
			radioButtonLeftMenu.click();
		}

		else {
			radioButtonLeftMenu.click();
		}
		String imagepath =Constant.File_Path;
		file.fileUploadusingSendkeys(choosefile, imagepath);
		general.clickJavaScriptExecutor(SaveButton, driver);
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertMessage.isDisplayed();
	}

	public ManageCategory searchCategory(String searchtext) {
		searchButton.click();
		inputSearchCategoryText.sendKeys(searchtext);
		saveSearchButton.click();
		return this;

	}

	public boolean isSearchTextDisplayed() {
		return seacrchAlertMsg.isDisplayed();
	}

	public ManageCategory deleteCategory() {
		deleteCategory.click();
		driver.switchTo().alert().accept();
		return this;
	}

	public boolean isDeleteAlertMsgDisplayed() {
		return dltAlertMessage.isDisplayed();
	}
}
