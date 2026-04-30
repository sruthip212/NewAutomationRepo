package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContacts;
import pages.ManageNews;

public class ManageNewsTest extends Base {
	LoginPage login;
	HomePage home;
	ManageNews news;
  @Test(groups="smoke")
  public void verifyAddNewNewsWithValidData() throws IOException
  {
	  login=new LoginPage(driver);
	  home=login.loginByUsingExcelData();
	 
	  news=home.clickOnManageNews().addNews("Heavy Rain");
	  
	 
	  boolean isAlertDisplayed=news.isAlertDisplayed();
	  Assert.assertTrue(isAlertDisplayed,"Alert is not Displayed");
	  
	  
  }
  
  @Test(groups="smoke")
  public void verifyDeletingExistingNews() throws IOException
  {
	  login=new LoginPage(driver);
	  home=login.loginByUsingExcelData();
	  news=home.clickOnManageNews().deleteNews();
	  boolean isAlertDisplayed=news.isDeleteAlertDisplayed();
	  Assert.assertTrue(isAlertDisplayed,"Alert is not Displayed");
	
	  
  }
  @Test
  public void verifyUpdatingExistingNews() throws IOException
  {
	  login=new LoginPage(driver);
	  home=login.loginByUsingExcelData();
	  news=home.clickOnManageNews().updateNews("No Rain");
	  
     
	  boolean isAlertDisplayed=news.isUpdateAlertDisplayed();
	  Assert.assertTrue(isAlertDisplayed,"Alert is not Displayed");
	
}
  @Test(groups="smoke")
  public void verifySearchForExistingNews() throws IOException
  {
	  login=new LoginPage(driver);
	  home=login.loginByUsingExcelData();
	  news=home.clickOnManageNews().searchNews("cypresscourse");
	    
      boolean isMessageDisplayed=news.isTextDisplayed();
	  Assert.assertTrue(isMessageDisplayed,"Result not Found");
	
}
 
}
