package com.ThankYouProject.testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.testBase.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class Testid_003_Install extends BaseClass{
	HomePage obj;

	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new HomePage(driver);
	}

	@Test
	public void testid_003_Install() throws Exception {
		extentTest.setDescription("To verify the splash screen");
		obj.splashScreen();
		extentTest.log(LogStatus.PASS, "User is on splash screen");

	}

	@AfterTest
	public void killApp() {
		driver.closeApp();
	}
}
