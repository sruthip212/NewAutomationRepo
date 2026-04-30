package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	WebDriver driver;

	public String selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String selectDropdownWithIndex(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String selectDropdownWithVisibleText(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByVisibleText(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void clickJavaScriptExecutorByScroll(WebDriver driver, List<WebElement> elements, int index) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", elements.get(index));
	}

	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}

	public void ClickDragAndDrop(WebElement SourceElement1, WebElement TargetElement) {
		Actions Act = new Actions(driver);
		Act.dragAndDrop(SourceElement1, TargetElement).perform();
	}

	public void ClickOnCheckbox(WebElement checkbox) {
		if (!checkbox.isSelected()) {
			checkbox.click();

		} else {
			checkbox.click();

		}
	}

	public void alertDismiss() {
		driver.switchTo().alert().dismiss();
	}

	public void alertAccept() {
		driver.switchTo().alert().accept();
	}

	public void javaScriptExecutorScrollRight() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(500,0)", 0);
	}

	public void javaScriptExecutorScrollLeft() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(-500,0)", 0);
	}

	public void javaScriptExecutorScrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
	}

	public void javaScriptExecutorScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}

	public void mouseHover(WebElement ClickMe) {
		Actions action = new Actions(driver);
		action.moveToElement(ClickMe).perform();
	}

	public void rightClick(WebElement RightClick) {
		Actions action = new Actions(driver);
		action.contextClick(RightClick).perform();
	}

	public void doubleClick(WebElement doubleClick) {
		Actions action = new Actions(driver);
		action.doubleClick(doubleClick).perform();
	}
}
