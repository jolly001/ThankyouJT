package com.ThankYouProject.pages;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ThankYouProject.testBase.BaseClass;
import com.ThankYouProject.utility.CommonFunctions;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class Profile extends BaseClass {
	AndroidDriver<AndroidElement> driver;
	CommonFunctions common = new CommonFunctions();

	public Profile(AndroidDriver<AndroidElement> driver) {

		this.driver = driver;
	}

	public void profilePictureAttach() throws Exception {
		common.click(("agreeBttn"), driver);
		extentTest.log(LogStatus.INFO, "Clicked on Agree and Continue button");
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		extentTest.log(LogStatus.PASS, "User is able to select the country code");

		// User selects the country code
		common.sendKeys("enterNum", driver, "123456");
		common.click("verifybutton", driver);
		extentTest.log(LogStatus.PASS, "Clicked on verify button by entering number less than 7 digits");
		// User is not able to register with digits less than 6
		Thread.sleep(1000);
		common.verifyTitle("enterNumHeader", driver, "enterNumTitleTD");
		common.cleartext("enterNum", driver);
		common.randomnumgen(); // generates 7 digis number
		common.click("verifybutton", driver);
		common.sendKeys("enterCode", driver, "enterOtpTD");
		extentTest.log(LogStatus.PASS, "User is able to register with digits between 7-13");
		// User is able to register with digits between 7-13
		common.sendKeys("enterUserName", driver, "newUserTD");
		extentTest.log(LogStatus.INFO, "user is on profile and has entered his name");

		common.click("saveBtn", driver);
		Thread.sleep(5000);
		common.click("userTutorial", driver);
		// common.applywait();
		common.click("skip&conbutton", driver);
		extentTest.log(LogStatus.INFO, "user has skipped user tutorial");
		common.verifyTitle("verifyHomePage", driver, "homePageTitleTD");
		extentTest.log(LogStatus.PASS, "Verified that user is on the home page");

		common.click("profilePicHomeScreen", driver);

		WebElement element1 = common.getWebElement("profilePicIcon");
		String blankProficPic = "blankProficPic";
		File beforeScreenshot = common.getSpecificScreenshot(driver, element1, blankProficPic);
		extentTest.log(LogStatus.INFO, "Screenshot without profile picture is taken");

		element1.click();

		common.click("clickFromCameraBttn", driver);
		Thread.sleep(3000);

		common.click("shutterBttn", driver);
		extentTest.log(LogStatus.PASS, "User has Opened the Camera");
		extentTest.log(LogStatus.INFO, "Picture is clicked from camera");
		common.click("doneBttnCamera", driver);
		common.click("cropBttn", driver);

		Thread.sleep(3000);
		WebElement element2 = common.getWebElement("profilePicIcon");
		String proficPicWithPic = "proficWithPic";
		File afterScreenshot = common.getSpecificScreenshot(driver, element2, proficPicWithPic);
		extentTest.log(LogStatus.INFO, "Screenshot with profile picture is taken");
		int Result = (int) common.compareImage(beforeScreenshot, afterScreenshot);
		if (Result == 100) {

			Assert.assertTrue(false);
		} else {
			extentTest.log(LogStatus.PASS, "Profile Picture is uploaded");
			Assert.assertTrue(true);
		}

	}

	public void userNotAbleToSubmitProfileAfterSavingName() throws Exception {
		common.click(("agreeBttn"), driver);
		extentTest.log(LogStatus.INFO, "Clicked on Agree and Continue button");
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.randomnumgen(); // generates 7 digits number
		common.click("verifybutton", driver);
		common.sendKeys("enterCode", driver, "enterOtpTD");
		common.click("saveBtn", driver);
		common.getSize("enterUserNameToast", driver);
		extentTest.log(LogStatus.INFO, "user is not able to save profile as name is required");
		common.sendKeys("enterUserName", driver, "newUserTD");
		extentTest.log(LogStatus.INFO, "user is on profile and has entered his name");
		common.click("myFaithTab", driver);
		common.sendKeys("enterGodName", driver, "newGodTD");
		extentTest.log(LogStatus.INFO, "user is on God's profile and has entered God's name");
		common.click("saveBtn", driver);
		Thread.sleep(5000);
		common.click("userTutorial", driver);
		common.click("skip&conbutton", driver);
		extentTest.log(LogStatus.INFO, "user has skipped user tutorial");
		common.verifyTitle("verifyHomePage", driver, "homePageTitleTD");
		extentTest.log(LogStatus.PASS, "Verified that user is on the home page");
		// User is on the home page
		common.click("userProfPic", driver);
		common.verifyTitle("profPageTitle", driver, "profileTitleTD");
		common.checkIfElementIsEnabled("verifyProftabisEbabled", driver);
		extentTest.log(LogStatus.INFO, "Verified that user is profile page page");

	}

	public void uploadPicFromGallery() throws Exception {
		common.click(("agreeBttn"), driver);
		extentTest.log(LogStatus.INFO, "Clicked on Agree and Continue button");
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		extentTest.log(LogStatus.PASS, "User is able to select the country code");
		// User selects the country code
		common.sendKeys("enterNum", driver, "123456");
		common.click("verifybutton", driver);
		Thread.sleep(1000);
		common.verifyTitle("enterNumHeader", driver, "enterNumTitleTD");
		common.cleartext("enterNum", driver);
		common.randomnumgen(); // generates 7 digis number
		common.click("verifybutton", driver);
		common.sendKeys("enterCode", driver, "enterOtpTD");
		common.sendKeys("enterUserName", driver, "newUserTD");
		extentTest.log(LogStatus.INFO, "user is on profile and has entered his name");

		common.click("saveBtn", driver);
		Thread.sleep(5000);
		common.click("userTutorial", driver);
		common.click("skip&conbutton", driver);
		extentTest.log(LogStatus.INFO, "user has skipped user tutorial");
		common.verifyTitle("verifyHomePage", driver, "homePageTitleTD");
		extentTest.log(LogStatus.PASS, "Verified that user is on the home page");

		common.click("profilePicHomeScreen", driver);

		WebElement element1 = common.getWebElement("profilePicIcon");
		String blankProficPic = "blankProficPic";
		File beforeScreenshot = common.getSpecificScreenshot(driver, element1, blankProficPic);
		extentTest.log(LogStatus.INFO, "Screenshot without profile picture is taken");
		element1.click();
		// Code to upload image from gallery. The image should be in emulator
		common.click("clickOnGallery", driver);
		common.click("clickOnGalleryPic", driver);
		common.click("clickOnGalleryPic1", driver);
		common.click("clickOnGalleryPic2", driver);
		Thread.sleep(3000);
		common.click("cropBttn", driver);
		Thread.sleep(3000);
		WebElement element2 = common.getWebElement("profilePicIcon");
		String proficPicWithPic = "proficWithPic";
		File afterScreenshot = common.getSpecificScreenshot(driver, element2, proficPicWithPic);
		extentTest.log(LogStatus.INFO, "Screenshot with profile picture is taken");
		int Result = (int) common.compareImage(beforeScreenshot, afterScreenshot);
		if (Result == 100) {

			Assert.assertTrue(false);
		} else {
			extentTest.log(LogStatus.PASS, "Profile Picture is uploaded from the gallery");
			Assert.assertTrue(true);
		}
		common.click("saveBtn", driver);
	}

	public void updateProfileFromProfileTab() throws Exception {
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "numberTD");
		common.click("verifybutton", driver);
		common.sendKeys("enterCode", driver, "enterOtpTD");
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
			common.click("profileTab", driver);
			common.verifyTitle("profileTab", driver, "profileTitleTD");
			extentTest.log(LogStatus.INFO, "Verified that user is on the Profile page");
			common.click("clickOnProfileFromProfTab", driver);
			common.checkIfElementIsDisabled("editUserNumber", driver);
			extentTest.log(LogStatus.PASS, "Verified that user is not able to edit number");
			common.cleartext("enterUserName", driver);
			common.sendKeys("enterUserName", driver, "newUserTD");
			extentTest.log(LogStatus.PASS, "Verified that user is able to edit name");
			common.click("saveBtn", driver);
			extentTest.log(LogStatus.PASS, "Verified that user is able to update profile");

			// if the same user is logging in again and has not imported the
			// contacts
		} else if (common.getWebElements("importButton").size() == 1) {
			common.click("skip&conbutton", driver);
			common.verifyTitle("verifyHomePage", driver, "homePageTitleTD");
			extentTest.log(LogStatus.PASS, "Verified that user is on the home page");
			common.click("profileTab", driver);
			common.verifyTitle("profileTab", driver, "profileTitleTD");
			extentTest.log(LogStatus.INFO, "Verified that user is on the Profile page");
			common.click("clickOnProfileFromProfTab", driver);
			common.checkIfElementIsDisabled("editUserNumber", driver);
			extentTest.log(LogStatus.PASS, "Verified that user is not able to edit number");
			common.cleartext("enterUserName", driver);
			common.sendKeys("enterUserName", driver, "newUserTD");
			extentTest.log(LogStatus.PASS, "Verified that user is able to edit name");
			common.click("saveBtn", driver);
			extentTest.log(LogStatus.PASS, "Verified that user is able to update profile");

		} else {
			// if the same user has imported all the contacts this code will run
			common.verifyTitle("verifyHomePage", driver, "homePageTitleTD");
			extentTest.log(LogStatus.PASS, "Verified that user is on the home page");
			common.click("profileTab", driver);
			common.verifyTitle("profileTab", driver, "profileTitleTD");
			extentTest.log(LogStatus.INFO, "Verified that user is on the Profile page");
			common.click("clickOnProfileFromProfTab", driver);
			common.checkIfElementIsDisabled("editNumCheck", driver);
			extentTest.log(LogStatus.PASS, "Verified that user is not able to edit number");
			common.cleartext("enterUserName", driver);
			common.sendKeys("enterUserName", driver, "newUserTD");
			common.click("saveBtn", driver);

		}

	}

}
