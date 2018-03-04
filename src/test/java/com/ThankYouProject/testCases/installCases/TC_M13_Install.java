package com.ThankYouProject.testCases.installCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.testBase.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class TC_M13_Install extends BaseClass{
	HomePage obj;

	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new HomePage(driver);
	}

	@Test
	public void TC_M13_Install() throws Exception {
		extentTest.setDescription("User is able to get the 59 Sec time when the user press the Resend code button.");
		obj.getting59SecondTimeAfterClickingOnResendButton();

	}

	@AfterTest
	public void killApp() {
		driver.closeApp();
	}
}
