package com.ThankYouProject.testCases.RegisterationCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.testBase.BaseClass;

public class TC_001_Registeration extends BaseClass {
	HomePage obj;

	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new HomePage(driver);
	}

	@Test
	public void TC_001_Registeration() throws Exception {
		extentTest.setDescription("To test if the user is able to register successfully and lands on to the home page");
		System.out.println("User reg");
		obj.userRegisteration();
		
	}

	@AfterTest
	public void killApp() {
		driver.closeApp();

	}

}
