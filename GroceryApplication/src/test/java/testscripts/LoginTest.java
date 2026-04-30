package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.LoginPage;

public class LoginTest extends Base {
	 LoginPage login;
	 @Test
	  public void verifyLoginWithValidCredentials() throws IOException {
		   login= new LoginPage(driver);
		  login.loginByUsingExcelData();
		  boolean ishomepageloaded=login.VerifyHomePageLoaded();
		  Assert.assertTrue(ishomepageloaded,Constant.LP_VerifyLoginWithValidData);
		  
	  }
	  
	  @Test
	  public void verifyLoginWithValidUsernameAndInvalidPassword() {
		   login= new LoginPage(driver);
		  login.enterUsernameonUsernamefield("admin").enterPasswordfield("qwert").clickonSignInButton();
		  boolean IsAlertDisplayed=login.Alertmessge();
		  Assert.assertTrue(IsAlertDisplayed,Constant.LP_verifyLoginWithwrongdata);
	}
	  
	  @Test
	  public void verifyLoginWithInvalidUsernameAndValidPassword() {
		   login= new LoginPage(driver);
		  login.enterUsernameonUsernamefield("Karol").enterPasswordfield("admin").clickonSignInButton();
		  
		  boolean IsAlertDisplayed=login.Alertmessge();
		  Assert.assertTrue(IsAlertDisplayed,Constant.LP_verifyLoginWithwrongdata);
	}
	  
	 
	  
	  @Test(dataProvider="DataProvider1")
	  public void verifyLoginWithInvalidUsernameAndInvalidPasswordWithDataProvider(String username,String pwd) {
		  login= new LoginPage(driver);
		  login.enterUsernameonUsernamefield(username).enterPasswordfield(pwd).clickonSignInButton();
		  boolean IsAlertDisplayed=login.Alertmessge();
		  Assert.assertTrue(IsAlertDisplayed,Constant.LP_verifyLoginWithwrongdata);
}
	  @DataProvider(name="DataProvider1")
	  public Object[][] dpmethod()
	  {
		  return new Object[][] {{"Admin","cart"},{"acf","qwer"},{"qewt","HADS"}};
				  
	  }
}
