package com.ThankYouProject.testCases.installCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.testBase.BaseClass;

public class ToTestTermsAndConditionsAndPrivacyPolicy extends BaseClass {
	HomePage obj;

	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new HomePage(driver);
	}

	@Test
	public void testid_005_Install() throws Exception {
		extentTest.setDescription("To verify the Terms and conditions and provacy policy");
		obj.verifyTOAndPP();
	}
	
	@AfterTest
	public void killApp(){
		driver.closeApp();
	}

}
