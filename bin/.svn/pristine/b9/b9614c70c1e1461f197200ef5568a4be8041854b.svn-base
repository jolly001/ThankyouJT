package com.ThankYouProject.testCases.otp;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.testBase.BaseClass;

public class TC_012_Otp extends BaseClass{
	HomePage obj;
	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new HomePage(driver);
	}

	@Test
	public void testUserIsNotAbleToEnterWrongOTP() throws Exception {
		obj.enterWrongOtp();

	}

	@AfterTest
	public void killApp() {
		driver.closeApp();

	}

}
