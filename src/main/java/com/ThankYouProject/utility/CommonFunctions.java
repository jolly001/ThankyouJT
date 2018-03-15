package com.ThankYouProject.utility;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ThankYouProject.testBase.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CommonFunctions extends BaseClass {

	public void click(String locator, AndroidDriver<AndroidElement> driver) throws Exception {
		// For Clicking on Element

		getWebElement(locator).click();

	}

	public void sendKeys(String locator, AndroidDriver driver, String value) throws Exception {

		// For Entering Text in an Element

		getWebElement(locator).sendKeys(getTestData(value));

	}

	public String getTestData(String value) {

		// For getting TestData from the property File

		return test.getProperty(value);
	}

	public WebElement getWebElement(String locator) throws Exception {

		// For getting Locator value from the locator property File
		return getLocator(loc.getProperty(locator));
	}

	public WebElement getLocator(String locator) throws Exception {

		// For minimizing the Locator Code

		// System.out.println(locator);
		String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];
		// System.out.println("locatorType:-"+locatorType);
		// System.out.println("locatorValue:-"+locatorValue);
		if (locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}

	public List<WebElement> getWebElements(String locator) throws Exception {
		return getLocators(loc.getProperty(locator));
	}

	public List getLocators(String locator) throws Exception {
		String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];
		System.out.println("locatorType:-" + locatorType);
		System.out.println("locatorValue:-" + locatorValue);

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElements(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElements(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return driver.findElements(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElements(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return driver.findElements(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElements(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}

	public void cleartext(String locator, AndroidDriver driver) throws Exception {
		getWebElement(locator).clear();
	}

	// public void swipe(String locator, AndroidDriver driver) throws Exception{
	// TouchAction t= new TouchAction(driver);
	// t.press((getWebElement(locator))).moveTo((getWebElement(locator))).release().perform();
	//
	// }

	public void waitForVisibilityOfElement(String locator, AndroidDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) getWebElement(locator)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void verifyTitle(String locator, AndroidDriver<AndroidElement> driver, String actual) throws Exception {

		String expected = getWebElement(locator).getText();

		Assert.assertEquals(getTestData(actual), expected);

	}

	public void assertionMethod(String actual, AndroidDriver<AndroidElement> driver, String expected) {
		// Assert.assertEquals(getTestData(actual), expected);
		String message = "|Actual Text: " + actual + "| |Expected Text: " + getTestData(expected) + "|";
		String html = "<span style='color:blue;'>" + message + " </span>";
		extentTest.log(LogStatus.INFO, html);
		Assert.assertEquals(actual, getTestData(expected));

	}

	public void checkIfElementIsEnabled(String locator, AndroidDriver<AndroidElement> driver) throws Exception {
		if (getWebElement(locator).isEnabled()) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
	}

	public void checkIfElementIsDisabled(String locator, AndroidDriver<AndroidElement> driver) throws Exception {
		if (!getWebElement(locator).isSelected()) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
	}

	public String getText(String locator, AndroidDriver<AndroidElement> driver) throws Exception {
		String text = getWebElement(locator).getText();
		return text;
	}

	public int getSize(String locator, AndroidDriver<AndroidElement> driver) throws Exception {
		int ele = getLocators(loc.getProperty(locator)).size();
		if (ele == 1) {
			Assert.assertTrue(true);
			extentTest.log(LogStatus.PASS, "The element is visible");
		} else {
			Assert.assertTrue(false);
			extentTest.log(LogStatus.PASS, "The element is not visible");
		}
		return ele;
	}

	public String randomnumgen() {
		Random rand = new Random();
		int num = rand.nextInt(9000000) + 1000000;
		int number = num;
		String numberAsString = new Integer(number).toString();
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Number']")).sendKeys(numberAsString);
		return numberAsString;

	}

	public TouchAction tap(String locator, AndroidDriver<AndroidElement> driver) throws Exception {

		TouchAction action = new TouchAction(driver);

		return action.tap(getWebElement(locator)).perform();

	}

	public TouchAction press(String locator, AndroidDriver<AndroidElement> driver) throws Exception {
		TouchAction action = new TouchAction(driver);
		return action.press(getWebElement(locator)).moveTo(getWebElement(locator)).release().perform();

	}

	public File getSpecificScreenshot(AndroidDriver<AndroidElement> driver, WebElement element, String screenshotName)
			throws IOException {

		// Get entire page screenshot
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(screenshot);

		// Get the location of element on the page
		Point point = element.getLocation();

		// Get width and height of the element
		int eleWidth = element.getSize().getWidth();
		int eleHeight = element.getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);

		// Copy the element screenshot to disk
		File screenshotLocation = new File(System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png");
		FileUtils.copyFile(screenshot, screenshotLocation);
		return screenshotLocation;

	}

	public float compareImage(File fileA, File fileB) {

		float percentage = 0;
		try {
			// take buffer data from both image files //
			BufferedImage biA = ImageIO.read(fileA);
			DataBuffer dbA = biA.getData().getDataBuffer();
			int sizeA = dbA.getSize();
			BufferedImage biB = ImageIO.read(fileB);
			DataBuffer dbB = biB.getData().getDataBuffer();
			int sizeB = dbB.getSize();
			int count = 0;
			// compare data-buffer objects //
			if (sizeA == sizeB) {

				for (int i = 0; i < sizeA; i++) {

					if (dbA.getElem(i) == dbB.getElem(i)) {
						count = count + 1;
					}

				}
				percentage = (count * 100) / sizeA;
			} else {
				System.out.println("Both the images are not of same size");
				System.out.println(percentage);
			}

		} catch (Exception e) {
			System.out.println("Failed to compare image files ...");
		}
		System.out.println(percentage);
		return percentage;
	}

	public void horizontalSwipe() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getHeight();
		int y = (int) (height * 0.20);
		int startx = (int) (width * 0.75);
		int endx = (int) (width * 0.35);
		driver.swipe(startx, y, endx, y, 500);
	}

	public void swipeUpToContact(String locator, AndroidDriver<AndroidElement> driver) {
		boolean f = false;
		for (int i = 0; i <= 10; i++) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				getWebElement(locator).isDisplayed();
				f = true;
				break;
			} catch (Exception e) {
				horizontalSwipe();
			}
			if (f) {
				System.out.println("Passed");
			} else {
				System.out.println("Failed");
			}
		}
	}
	public void methodForLogin() throws Exception{
		//common method call to user login
		click(("agreeBttn"), driver);
		extentTest.log(LogStatus.INFO, "Clicked on Agree and Continue button");
		click("selectCountry", driver);
		sendKeys("enterCountryname", driver, "countryNameTD");
		click("india", driver);
		randomnumgen();
		click("verifybutton", driver);
		sendKeys("enterCode", driver, "enterOtpTD");
		sendKeys("enterUserName", driver, "newUserTD");
		extentTest.log(LogStatus.INFO, "user is on profile and has entered his name");
		click("myFaithTab", driver);
		sendKeys("enterGodName", driver, "newGodTD");
		extentTest.log(LogStatus.INFO, "user is on God's profile and has entered God's name");
		click("saveBtn", driver);
	}
	
	public void methodForLoginforExistingUser() throws Exception{
		click(("agreeBttn"), driver);
		click("selectCountry", driver);
		sendKeys("enterCountryname", driver, "countryNameTD");
		click("india", driver);
		sendKeys("enterNum", driver, "userANumTD");
		click("verifybutton", driver);
		sendKeys("enterCode", driver, "enterOtpTD");
		Thread.sleep(6000);
}
}