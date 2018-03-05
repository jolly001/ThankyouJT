package com.ThankYouProject.testCases.profile;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.Profile;
import com.ThankYouProject.testBase.BaseClass;

public class TC_004_Profile extends BaseClass {
	Profile obj;

	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new Profile(driver);
	}

	@Test
	public void userSaveProfile() throws Exception {
		obj.userNotAbleToSubmitProfileAfterSavingName();

	}

	@AfterTest
	public void killApp() {
		driver.closeApp();
	}

}
