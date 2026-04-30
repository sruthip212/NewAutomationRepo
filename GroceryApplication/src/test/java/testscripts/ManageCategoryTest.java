package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategory;
import pages.ManageNews;
import utilities.GeneralUtilities;

public class ManageCategoryTest extends Base{
	
	GeneralUtilities general=new GeneralUtilities();	
	 LoginPage login;
	 HomePage home;
	 ManageCategory Category;
	 @Test
	  public void verifyAddNewCategoryWithValidData() throws IOException
	  {
		  login=new LoginPage(driver);
		  home=login.loginByUsingExcelData();
		  Category=home.clickOnManageCategory().addCategory("apple");
		  boolean isAlertmessageDisplayed=Category.isAlertDisplayed();
		  Assert.assertTrue(isAlertmessageDisplayed, "Alert not Displayed");
		  
	  }
	 @Test
	 public void verifySearchForNonExistingCategory() throws IOException
	  {
		  login=new LoginPage(driver);
		  home=login.loginByUsingExcelData();
		  Category=home.clickOnManageCategory().searchCategory("Apple"+general.generateCurrentDateAndTime());
		  boolean isSearchTextDisplayed=Category.isSearchTextDisplayed();
		  Assert.assertTrue(isSearchTextDisplayed, "Alert not Displayed");
		  
		  	  
		  
	  }
	 @Test
	 public void verifyDeleteForExistingCategory() throws IOException
	  {
		  login=new LoginPage(driver);
		  home=login.loginByUsingExcelData();
		  Category=home.clickOnManageCategory().deleteCategory();
		   boolean isDeleteAlertmessageDisplayed=Category.isDeleteAlertMsgDisplayed();
		  Assert.assertTrue(isDeleteAlertmessageDisplayed, "Alert not Displayed");
		  
		  	  
		  
	  }
}
