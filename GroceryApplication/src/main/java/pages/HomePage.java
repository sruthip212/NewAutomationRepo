package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='active nav-link' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement ManageNewslink;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement admin;
	@FindBy(xpath = "//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']")
	private WebElement logout;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement loginPageText;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class=' nav-link']")
	private WebElement ManageContactLink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='active nav-link']")
	private WebElement ManageCategoryLink;

	public ManageNews clickOnManageNews() {
		ManageNewslink.click();
		return new ManageNews(driver);
	}

	public ManageContacts clickOnManageContact() {
		ManageContactLink.click();
		return new ManageContacts(driver);
	}

	public ManageCategory clickOnManageCategory() {
		ManageCategoryLink.click();
		return new ManageCategory(driver);
	}

	public void clickOnLogout() {
		admin.click();
		logout.click();
	}

	public boolean verifyLogout() {
		return loginPageText.isDisplayed();
	}
}
