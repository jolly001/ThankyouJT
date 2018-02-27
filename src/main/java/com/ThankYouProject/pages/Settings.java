package com.ThankYouProject.pages;

import com.ThankYouProject.testBase.BaseClass;
import com.ThankYouProject.utility.CommonFunctions;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Settings extends BaseClass {
	HomePage obj;
	AndroidDriver<AndroidElement> driver;
	CommonFunctions common = new CommonFunctions();

	public Settings(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void goToSettingPage() throws Exception {
		common.click(("agreeBttn"), driver);
        extentTest.log(LogStatus.INFO, "Clicked on agree button");
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.randomnumgen();
		common.click("verifybutton", driver);
		 extentTest.log(LogStatus.INFO, "Clicked on verify button");

//		for (int i = 0; i < 5; i++) {
//			common.click("allowPopup", driver);
//		}
		
		common.sendKeys("enterCode", driver, "enterOtpTD");
		//common.applywait();
		extentTest.log(LogStatus.INFO, "User is on Profile Page");
		common.sendKeys("enterUserName", driver, "userANameTD");
		common.click("myFaithTab", driver);
		common.sendKeys("enterGodName", driver, "userAGodTD");
		//common.applywait();
		common.click("saveBtn", driver);
		extentTest.log(LogStatus.INFO, "Save button is clicked");
		
		common.click("userTutorial", driver);
		//Thread.sleep(5000);
		common.click("skip&conbutton", driver);
		common.click("tapOnSettings", driver);
		extentTest.log(LogStatus.INFO, "Settings button is clicked");
		common.verifyTitle("settingsPageTitle", driver, "setTitleTD");
	}

}
