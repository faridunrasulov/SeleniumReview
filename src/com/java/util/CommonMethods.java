package com.java.util;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends BaseClass {

	/**
	 * Method that clears and send keys
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Method will check if radio/checkboox is enabled/not selected and clicks it
	 * 
	 * @param radioOrCHeckbox
	 * @param value
	 */
	public static void clickRadioOrCheckbox(List<WebElement> radioOrCHeckbox, String value) {
		String actualValue;
		for (WebElement radioOrBox : radioOrCHeckbox) {
			actualValue = radioOrBox.getAttribute("value").trim();
			if (radioOrBox.isDisplayed() && !radioOrBox.isSelected()) {
				if (actualValue.equals(value)) {
					radioOrBox.click();
					break;
				}
			}
		}
	}

	/**
	 * Method that checks if text is there and then selects dropdowns
	 * 
	 * @param element
	 * @param expectedValue
	 */
	public static void selectDdValue(WebElement element, String expectedValue) {

		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			String actualValue;

			for (WebElement op : options) {
				actualValue = op.getText();
				if (op.isEnabled()) {
					if (actualValue.equals(expectedValue)) {
						op.click();
						break;
					}
				}
			}

		} catch (UnexpectedTagNameException ua) {
			ua.printStackTrace();
		}

	}

	/**
	 * Method that selects value by index
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDdValue(WebElement element, int index) {

		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			int size = options.size();
			if (size > index) {
				select.selectByIndex(index);
			}

		} catch (UnexpectedTagNameException ua) {
			ua.printStackTrace();
		}
	}

	/**
	 * method that accepts alerts and catches exception if alert is not present
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException ne) {
			ne.printStackTrace();
		}
	}

	/**
	 * method that dismisses alerts and catches exception if alert is not present
	 */
	public static void dissmisAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException ne) {
			ne.printStackTrace();
		}
	}

	/**
	 * method that gets text of alerts and catches exception if alert is not present
	 */
	public static String getAlertText() {
		String alertText = "";
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException ne) {
			ne.printStackTrace();
			alertText = null;
		}
		return alertText;
	}

	/**
	 * Method that sends keys to alert and catches exception if alert is not present
	 * 
	 * @param text
	 */
	public static void sendAlerttxt(String text) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);
		} catch (NoAlertPresentException ne) {
			ne.printStackTrace();

		}
	}

	/**
	 * Method will switch to a frame using nameOrId
	 * 
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {

		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException nf) {
			nf.printStackTrace();
		}
	}

	/**
	 * Method will switch to frame using element
	 * 
	 * @param element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException nf) {
			nf.printStackTrace();
		}
	}

	/**
	 * Method will switch to frame using index
	 * 
	 * @param index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException nf) {
			nf.printStackTrace();
		}
	}

	/**
	 * This method switches to child window
	 */
	public static void switchToChildWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String oneWindow : windows) {
			if (!oneWindow.equals(mainWindow)) {
				driver.switchTo().window(oneWindow);
				break;
			}
		}
	}

	/**
	 * Method will create an object of WebDriverWait and return it
	 * 
	 * @return
	 */
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		return wait;
	}

	/**
	 * Method will explicitly wait for an element to be clickable
	 * 
	 * @param clickable
	 */
	public static WebElement waitForClickability(WebElement clickable) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(clickable));

	}

	/**
	 * Method will explicitly wait for an element until it appears on DOM
	 * 
	 * @param element
	 */
	public static void wiatForStaleNoElement(WebElement element) {
		getWaitObject().until(ExpectedConditions.stalenessOf(element));
	}
	
	public static void findByIdAndClick(String id) {
		boolean isFound = false;
		while (!isFound) {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
			for (int i = 0; i < rows.size(); i++) {
				String rowTxt = rows.get(i).getText();
				if (rowTxt.contains(id)) {
					isFound = true;
					sleep(1);
					driver.findElement(By.xpath("//a[text()='"+id.trim()+"']")).click();
					break;
				}
			}
			if (!isFound)
				driver.findElement(By.xpath("//a[text()='Next']")).click();
			
			
		}
	}

	/**
	 * Method will wait an WebElement and then click on WebElement
	 * 
	 * @param click
	 */
	public static void click(WebElement click) {
		click.click();
	}
	public static void waitAndClick(WebElement element) {
		waitForClickability(element);
		element.click();
	}

	/**
	 * Method will wait an WebElement and then submit on WebElement
	 * 
	 * @param element
	 */
	public static void submit(WebElement submit) {
		waitForClickability(submit);
		submit.submit();
	}

	/**
	 * Method will pause a script of WebPage to certain time
	 * 
	 * @param number
	 */
	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void oneButtonClick(WebElement element) {
		if (element.isEnabled() && !element.isSelected()) {
			waitForClickability(element);
			element.click();
		}
	}

	public static void getWindowTitleAndClose(Set<String> linksID, String parentId) {
		Set<String> LinkId = driver.getWindowHandles();
		for (String link : LinkId) {
			if (!link.equals(parentId)) {
				driver.switchTo().window(link);
				String title = driver.getTitle();
				System.out.println(title);
				driver.close();
			}
		}
	}

	public static void waitForTextOfElementToBeVisible(WebElement element, String text) {
		getWaitObject().until(ExpectedConditions.textToBePresentInElementValue(element, text));
	}

	public static void waitForStalenessOfElement(WebElement element) {
		getWaitObject().until(ExpectedConditions.stalenessOf(element));
	}

	public static void waitForVisibility(WebElement element) {
		getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	public static JavascriptExecutor getJavaScriptObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	public static void javaScriptClick(WebElement element) {
		getJavaScriptObject().executeScript("arguments[0].click();", element);

	}
	
	public static void scrollToElement(WebElement element) {
		getJavaScriptObject().executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public static void scrollDown(int pixel) {
		getJavaScriptObject().executeScript("window.scrollBy(0,"+pixel+")");

	}
	public static void scrollUp(int pixel) {
		getJavaScriptObject().executeScript("window.scrollBy(0,-"+pixel+")");

	}
	public static void isDisplayedLogo(WebElement element) {		
		if(element.isDisplayed()) {
			System.out.println("Logo is displayed");
		}else {
			System.err.println("Logo is NOT displayed");
		}
	}
	
	/**
	 * This method will select a day from a calendar
	 * @param calendarDates
	 * @param day
	 */
	public static void selectCalendarDate(List<WebElement> calendarDates,String day) {
		
		for (WebElement date : calendarDates) {
			String dateTxt = date.getText();
			if(date.isEnabled()) {
				if(dateTxt.equals(day)) {
					date.click();
					break;
				}
			}
		}
	}
	
}
