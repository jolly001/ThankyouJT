package com.ThankYouProject.testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.testBase.BaseClass;

public class VerifyAbleToVisitHomePage extends BaseClass {

	HomePage obj;

	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new HomePage(driver);
	}

	@Test
	public void verifyAbleToVisitHomePage() throws Exception {

		obj.visitHomePage();

	}

	 @AfterTest
	 public void killApp() {
	 driver.closeApp();
	 
	 }
}
