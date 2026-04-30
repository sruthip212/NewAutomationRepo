package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;

public class LogOutTest extends Base {
	LoginPage login;
	HomePage home;
	 @Test
	  public void verifyLogout() throws IOException
	  {
		  login=new LoginPage(driver);
		  home= login.loginByUsingExcelData();
		  home.clickOnLogout();
		  boolean isLogoutDisplayed=home.verifyLogout();
		  Assert.assertTrue(isLogoutDisplayed,"Login page is not loaded");
		  
		
	}
}
