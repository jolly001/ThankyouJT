package com.ThankYouProject.testCases.installCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.testBase.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class MinimizeTheApp extends BaseClass{
	HomePage obj;

	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new HomePage(driver);
	}

	@Test
	public void minimizeTheApp() throws Exception {
		extentTest.setDescription("To verify Able to Minimize the screen and switch back");
		obj.minimizingApplication();

	}

	@AfterTest
	public void killApp() {
		driver.closeApp();
	}
}
