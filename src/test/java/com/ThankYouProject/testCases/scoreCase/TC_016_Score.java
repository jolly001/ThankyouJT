package com.ThankYouProject.testCases.scoreCase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.testBase.BaseClass;

public class TC_016_Score extends BaseClass {
	HomePage obj;
	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new HomePage(driver);
	}

	@Test
	public void toTestPreviousScore() throws Exception {
		obj.toVerifyThanksReceived();

	}

//	@AfterTest
//	public void killApp() {
//		driver.closeApp();
//	}
}
