package com.ThankYouProject.testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.testBase.BaseClass;

public class ToTestUserIsAbleToRegister extends BaseClass {
	HomePage obj;

	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new HomePage(driver);
	}

	@Test
	public void testUserRegisteration() throws Exception {
		System.out.println("User reg");
		obj.userRegisteration();
		
	}

	@AfterTest
	public void killApp() {
		driver.closeApp();

	}

}
