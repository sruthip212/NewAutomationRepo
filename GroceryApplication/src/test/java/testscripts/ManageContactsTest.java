package testscripts;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContacts;
import pages.ManageNews;

public class ManageContactsTest extends Base{
	LoginPage login;
	HomePage home;
	ManageContacts contact;
  @Test
  public void verifyUpdatingExistingContacts() throws IOException
  {
	  login=new LoginPage(driver);
	  home=login.loginByUsingExcelData();
	  
	  contact=home.clickOnManageContact().updateContacts("1", "50");
	   
	  boolean isAlertMsgDisplayed=contact.isAlertDisplayed();
	  Assert.assertTrue(isAlertMsgDisplayed, "Alert is not Displayed");
	  
}
}
