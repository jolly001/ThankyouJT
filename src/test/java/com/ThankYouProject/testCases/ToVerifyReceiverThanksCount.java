package com.ThankYouProject.testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.pages.Profile;
import com.ThankYouProject.testBase.BaseClass;

public class ToVerifyReceiverThanksCount extends BaseClass {
	//HomePage obj;
	Profile obj;

	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new Profile(driver);
	}

	@Test
	public void testUserIsAbleToEditProfile() throws Exception {
		obj.toVerifyThanksReceived();
	}

	@AfterTest
	public void killApp() {
		driver.closeApp();

	}

}
