package com.ThankYouProject.testCases.profile;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.pages.Profile;
import com.ThankYouProject.testBase.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class TC_M14_Profile extends BaseClass{
	Profile obj;

	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new Profile(driver);
	}

	@Test
	public void TC_M13_Profile() throws Exception {
		extentTest.setDescription("Verify that User is able to put profile photo on Profile page by Clicking Picture from Device");
		obj.profilePictureAttach();

	}

	@AfterTest
	public void killApp() {
		//driver.closeApp();
	}
}
