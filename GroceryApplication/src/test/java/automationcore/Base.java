package automationcore;

import org.testng.annotations.Test;

import constants.Constant;
import utilities.ScreenshotUtility;
import utilities.WaitUtitility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Base {
	Properties prop;
	FileInputStream fs;
	WaitUtitility wait = new WaitUtitility();

	public WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {
		prop = new Properties();
		fs = new FileInputStream(Constant.CONFIG_FILE);
		prop.load(fs);
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Invalid browser");

		}
		driver.get(prop.getProperty("url"));
		wait.implicitWait(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void driverQuit(ITestResult itestresult) throws IOException {
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility screenshot = new ScreenshotUtility();
			screenshot.getScreenshot(driver, itestresult.getName());
		}
		// driver.quit();
	}

}
