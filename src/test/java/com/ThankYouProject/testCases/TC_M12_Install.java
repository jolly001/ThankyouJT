package com.ThankYouProject.testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.testBase.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class TC_M12_Install extends BaseClass{
	HomePage obj;

	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new HomePage(driver);
	}

	@Test
	public void TC_M12_Install() throws Exception {
		extentTest.setDescription("To verify Able to Minimize the screen and switch back");
		obj.minimizingApplication();

	}

	@AfterTest
	public void killApp() {
		driver.closeApp();
	}
}
