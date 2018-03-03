package com.ThankYouProject.testCases.InstallCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.testBase.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class ToTestSpalshScreen extends BaseClass{
	HomePage obj;

	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new HomePage(driver);
	}

	@Test
	public void toTestSpalshScreen() throws Exception {
		extentTest.setDescription("To verify the splash screen");
		obj.splashScreen();
		extentTest.log(LogStatus.PASS, "User is on splash screen");

	}

	@AfterTest
	public void killApp() {
		driver.closeApp();
	}
}
