package com.ThankYouProject.testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.testBase.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class ToVerifyWelcomeScreen extends BaseClass {
	
	HomePage obj;

	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new HomePage(driver);
	}

	@Test
	public void splashScreenVerify() throws Exception {
		extentTest.setDescription("To verify that user is on Welcome screen");
		obj.welcomeScreen();
		extentTest.log(LogStatus.PASS, "User is on Welcome screen");

	}

	@AfterTest
	public void killApp() {
		driver.closeApp();
	}

}
