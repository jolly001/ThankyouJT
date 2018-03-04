package com.ThankYouProject.pages;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ThankYouProject.testBase.BaseClass;
import com.ThankYouProject.utility.CommonFunctions;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Profile extends BaseClass{
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

		WebElement element1=common.getWebElement("profilePicIcon");
		 String blankProficPic="blankProficPic";
		File beforeScreenshot =common.getSpecificScreenshot(driver, element1,  blankProficPic);
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
			 WebElement element2=common.getWebElement("profilePicIcon");
			 String proficPicWithPic="proficWithPic";
			File afterScreenshot =common.getSpecificScreenshot(driver, element2,  proficPicWithPic);
			extentTest.log(LogStatus.INFO, "Screenshot with profile picture is taken");
			int Result=(int) common.compareImage(beforeScreenshot, afterScreenshot);
			if(Result==100)
			{
				
				Assert.assertTrue(false);
			}
			else
			{
				extentTest.log(LogStatus.PASS, "Profile Picture is uploaded");
				Assert.assertTrue(true);
			}
	
			 
			 

	}


}
