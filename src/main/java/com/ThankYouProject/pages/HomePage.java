package com.ThankYouProject.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ThankYouProject.testBase.BaseClass;
import com.ThankYouProject.utility.CommonFunctions;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomePage extends BaseClass {
	AndroidDriver<AndroidElement> driver;
	CommonFunctions common = new CommonFunctions();

	public HomePage(AndroidDriver<AndroidElement> driver) {

		this.driver = driver;
	}

	public void spalshScreen() {
		//// common.applywait();
		try {
			if (driver
					.findElement(By.xpath("//android.widget.ProgressBar[contains(@resource-id,'splash_progress_bar')]"))
					.isDisplayed() == true) {
				Assert.assertTrue(true, "You are on the splash screen and the progress bar is detected");
			} else
				Assert.assertTrue(false, "splash screen not detected");

		} catch (InvalidSelectorException e) {
			System.out.println(e);
		}

	}

	public void welcomeScreen() throws Exception {
		// common.applywait();
		common.verifyTitle("welcomePage", driver, "welcomeTextTD");
		common.click("termsOfServ", driver);
		common.verifyTitle("tosTitle", driver, "termOfServTitleTD");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		common.click("backButton", driver);
		common.verifyTitle("welcomePage", driver, "welcomeTextTD"); // to
																	// verify
																	// user
																	// is on
																	// home
		//// common.applywait();
		common.click("privacyPolicy", driver);
		common.verifyTitle("privacypolicyHeader", driver, "privacyPolicyTitleTD");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		common.click("backButton", driver);
		common.verifyTitle("welcomePage", driver, "welcomeTextTD"); // to
																	// verify
																	// the
																	// user
																	// is on
																	// home

	}

	public void userRegisteration() throws Exception {
		common.click(("agreeBttn"), driver);
		extentTest.log(LogStatus.INFO, "Clicked on Agree and Continue button");
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "123456");
		common.click("verifybutton", driver);
		extentTest.log(LogStatus.INFO, "Clicked on verify button");
		Thread.sleep(1000);
		for (int i = 0; i < 5; i++) {
			common.click("allowPopup", driver);
		}
		common.verifyTitle("enterNumHeader", driver, "enterNumTitleTD");
		common.cleartext("enterNum", driver);
		common.randomnumgen();
		common.click("verifybutton", driver);
		// common.applywait();
		common.sendKeys("enterCode", driver, "enterOtpTD");
		// common.applywait();
		common.sendKeys("enterUserName", driver, "newUserTD");
		extentTest.log(LogStatus.INFO, "user is on profile and has entered his name");
		common.click("myFaithTab", driver);
		common.sendKeys("enterGodName", driver, "newGodTD");
		extentTest.log(LogStatus.INFO, "user is on God's profile and has entered God's name");
		common.click("saveBtn", driver);
		Thread.sleep(5000);
		common.click("userTutorial", driver);
		// common.applywait();
		common.click("skip&conbutton", driver);
		extentTest.log(LogStatus.INFO, "user has skipped user tutorial");

	}

	public void visitHomePage() throws Exception {

		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "numberTD");
		common.click("verifybutton", driver);

		for (int i = 0; i < 5; i++) {
			common.click("allowPopup", driver);
		}
		common.sendKeys("enterCode", driver, "enterOtpTD");
		// common.applywait();
		// if the user is a new user

		if (common.getWebElements("profPageTitle").size() == 1) {
			extentTest.log(LogStatus.INFO, "Verified that this user is a new user");
			common.sendKeys("enterUserName", driver, "userANameTD");
			common.click("myFaithTab", driver);
			common.sendKeys("enterGodName", driver, "userAGodTD");
			// common.applywait();
			common.click("saveBtn", driver);

			Thread.sleep(5000);

			common.click("userTutorial", driver);
			Thread.sleep(5000);
			common.click("skip&conbutton", driver);
			Thread.sleep(10000);
			common.click("selGod", driver);
			// common.applywait();
			common.click("godTutSkip", driver);
			extentTest.log(LogStatus.INFO, "Skipped God's tutorial");
			common.checkIfElementIsEnabled("verifyHomePage", driver);
			// if the same user is logging in again and has not imported the
			// contacts
		} else if (common.getWebElements("importButton").size() == 1) {
			common.click("skip&conbutton", driver);
			common.verifyTitle("verifyHomePage", driver, "homePageTitleTD");
			extentTest.log(LogStatus.PASS, "Verified that user is on the home page");

		} else {
			// if the same user has imported all the contacts this code will run
			common.verifyTitle("verifyHomePage", driver, "homePageTitleTD");
			extentTest.log(LogStatus.PASS, "Verified that user is on the home page");
		}

	}

	public void userIsAbleToEditProfile() throws Exception {
		visitHomePage();
		common.click("userProfPic", driver);
		common.verifyTitle("profPageTitle", driver, "profileTitleTD");
		common.checkIfElementIsEnabled("verifyProftabisEbabled", driver);
		extentTest.log(LogStatus.INFO, "Verified that user is Home page");
		common.sendKeys("enterUserName", driver, "userEditNameTD");
		common.checkIfElementIsDisabled("editUserNumber", driver);
		common.click("myFaithTab", driver);
		common.sendKeys("enterGodName", driver, "editGodNameTD");
		common.click("saveBtn", driver);
		// Thread.sleep(5000);
		// common.click("skip&conbutton", driver);
		common.click("userProfPic", driver);
		common.verifyTitle("enterUserName", driver, "confirmUsernameTD");
		extentTest.log(LogStatus.INFO, "The user name is edited successfully");
		common.click("myFaithTab", driver);
		common.verifyTitle("enterGodName", driver, "confirmGodName");
		extentTest.log(LogStatus.INFO, "The God's name is edited successfully");

	}

	public void userASendsThankfulMessage() throws Exception {
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userANumTD");
		common.click("verifybutton", driver);
		for (int i = 0; i < 5; i++) {
			common.click("allowPopup", driver);
		}
		common.sendKeys("enterCode", driver, "enterOtpTD");
		if (common.getWebElements("importButton").size() == 1) {
			common.click("skip&conbutton", driver);
			common.click("selUserContact", driver);
			common.click("indebtThanks", driver);
			common.click("grateful", driver);
			common.click("thankful", driver);
			common.click("sayThanksbtn", driver);
			common.click("clicktosendThanks", driver);
			common.click("grateful", driver);
			extentTest.log(LogStatus.INFO, "Thanks has been sent");
//			String actual=common.getText("thankfulText", driver);
//			System.out.println(actual);
			
		} else if (common.getWebElements("profPageTitle").size() == 1) {
			common.sendKeys("enterUserName", driver, "userANameTD");
			common.click("myFaithTab", driver);
			common.sendKeys("enterGodName", driver, "userAGodTD");
			common.click("saveBtn", driver);
			System.out.println("Save is clicked");
			Thread.sleep(5000);
			common.click("userTutorial", driver);
			Thread.sleep(5000);
			common.click("skip&conbutton", driver);
			Thread.sleep(10000);
			common.click("selGod", driver);
			// common.applywait();
			common.click("godTutSkip", driver);
			common.tap("selUserContact", driver);
			extentTest.log(LogStatus.INFO, "The user name is selected");
			common.click("indebtThanks", driver);
			common.click("grateful", driver);
			common.click("thankful", driver);
			extentTest.log(LogStatus.INFO, "The user has selected tankful message");
			common.click("sayThanksbtn", driver);
			common.click("clicktosendThanks", driver);
			extentTest.log(LogStatus.INFO, "Thanks has been sent");
//			String actual=common.getText("thankfulText", driver);
//			System.out.println(actual);
			

		} else {

			common.tap("selUserContact", driver);
			extentTest.log(LogStatus.INFO, "The user name is selected");
			common.click("indebtThanks", driver);
			common.click("grateful", driver);
			common.click("thankful", driver);
			extentTest.log(LogStatus.INFO, "The user has selected tankful message");
			common.click("sayThanksbtn", driver);
			common.click("clicktosendThanks", driver);
			extentTest.log(LogStatus.INFO, "Thanks has been sent");
//			String actual=common.getText("thankfulText", driver);
//			System.out.println("jsjdjbjwsdbjsbdb"+ actual);

		}

	}

	public void userBReg() throws Exception {
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userBNumTD");
		common.click("verifybutton", driver);
		for (int i = 0; i < 5; i++) {
			common.click("allowPopup", driver);
		}
		//// common.applywait();
		common.sendKeys("enterCode", driver, "enterOtpTD");
		//// common.applywait();
		if (driver.findElements(By.xpath("//android.widget.Button[contains(@resource-id,'btnImport')]")).size() == 1) {
			common.click("skip&conbutton", driver);
			Assert.assertTrue(true, "You are on home page");
		}

		else {

			common.sendKeys("enterUserName", driver, "userBNameTD");
			common.click("myFaithTab", driver);
			common.sendKeys("enterGodName", driver, "userBGodTD");
			common.click("saveBtn", driver);
			common.click("userTutorial", driver);
			//// common.applywait();
			common.click("skip&conbutton", driver);
		}

	}
}