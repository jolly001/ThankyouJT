package com.ThankYouProject.testCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.testBase.BaseClass;

public class ToVerifyTermsOfServiceAndPrivacyPolicy extends BaseClass {
	HomePage obj;

	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new HomePage(driver);
	}

	@Test
	public void verifyTheTOSandPP() throws Exception {
		obj.welcomeScreen();
	}

}
