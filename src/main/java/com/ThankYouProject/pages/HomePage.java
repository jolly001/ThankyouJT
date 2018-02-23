package com.ThankYouProject.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.testng.Assert;

import com.ThankYouProject.testBase.BaseClass;
import com.ThankYouProject.utility.CommonFunctions;

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
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "123456");
		common.click("verifybutton", driver);
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
		common.click("myFaithTab", driver);
		common.sendKeys("enterGodName", driver, "newGodTD");
		common.click("saveBtn", driver);
		Thread.sleep(5000);
		common.click("userTutorial", driver);
		// common.applywait();
		common.click("skip&conbutton", driver);

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
			common.checkIfElementIsEnabled("verifyHomePage", driver);
			// if the same user is logging in again and has not imported the
			// contacts
		} else if (common.getWebElements("importButton").size() == 1) {
			common.click("skip&conbutton", driver);
			common.checkIfElementIsEnabled("verifyHomePage", driver);

		} else {
			// if the same user has imported all the contacts this code will run
			common.checkIfElementIsEnabled("verifyHomePage", driver);
		}

	}

	public void userIsAbleToEditProfile() throws Exception {
		visitHomePage();
		common.click("userProfPic", driver);
		common.verifyTitle("profPageTitle", driver, "profileTitleTD");
		common.checkIfElementIsEnabled("verifyProftabisEbabled", driver);
		common.sendKeys("enterUserName", driver, "userEditNameTD");
		common.checkIfElementIsDisabled("editUserNumber", driver);
		common.click("myFaithTab", driver);
		common.sendKeys("enterGodName", driver, "editGodNameTD");
		common.click("saveBtn", driver);
		Thread.sleep(5000);
		common.click("skip&conbutton", driver);
		common.click("userProfPic", driver);
		common.verifyTitle("enterUserName", driver, "confirmUsernameTD");
		common.click("myFaithTab", driver);
		common.verifyTitle("enterGodName", driver, "confirmGodName");

	}

	public void userAReg() throws Exception {
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userANumTD");
		common.click("verifybutton", driver);
		for (int i = 0; i < 5; i++) {
			common.click("allowPopup", driver);
		}
		// common.applywait();
		common.sendKeys("enterCode", driver, "enterOtpTD");
		// common.applywait();
		if (common.getWebElements("importButton").size() == 1) {
			common.click("skip&conbutton", driver);
			Assert.assertTrue(true, "You are on home page");
			common.click("selUserContact", driver);
			common.click("indebtThanks", driver);
			common.click("grateful", driver);
			common.click("thankful", driver);
			common.click("sayThanksbtn", driver);
			// common.applywait();
			common.click("clicktosendThanks", driver);
			// common.applywait();
			common.click("grateful", driver);

		} else if (common.getWebElements("profPageTitle").size() == 1) {
			common.sendKeys("enterUserName", driver, "userANameTD");
			common.click("myFaithTab", driver);
			common.sendKeys("enterGodName", driver, "userAGodTD");
			// common.applywait();
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

		}

		else {

			common.checkIfElementIsEnabled("verifyHomePage", driver);
		}

		common.click("selUserContact", driver);
		common.click("indebtThanks", driver);
		common.click("grateful", driver);
		common.click("thankful", driver);
		common.click("sayThanksbtn", driver);
		// common.applywait();
		common.click("clicktosendThanks", driver);
		// common.applywait();
		common.click("grateful", driver);

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