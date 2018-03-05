package com.ThankYouProject.testCases.profile;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.testBase.BaseClass;

public class TotestUserIsAbleToEditProfile extends BaseClass {
	HomePage obj;

	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new HomePage(driver);
	}

	@Test
	public void testUserIsAbleToEditProfile() throws Exception {
		obj.userIsAbleToEditProfile();

	}

	@AfterTest
	public void killApp() {
		driver.closeApp();

	}

}
