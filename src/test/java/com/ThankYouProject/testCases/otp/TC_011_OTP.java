package com.ThankYouProject.testCases.otp;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.testBase.BaseClass;

public class TC_011_OTP extends BaseClass {
	HomePage obj;
	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new HomePage(driver);
	}

	@Test
	public void userIsAbleToProceedAfterResendVerificationCode() throws Exception {
		obj.userIsAbleToProceedAfterResendVerificationCode();

	}

	@AfterTest
	public void killApp() {
		driver.closeApp();

	}

}
