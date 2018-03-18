package com.ThankYouProject.testCases.homeCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.HomePage;
import com.ThankYouProject.testBase.BaseClass;

public class TC_018_Home_1 extends BaseClass {
	HomePage obj;
	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new HomePage(driver);
	}

	@Test
	public void tC_018_replyButton() throws Exception {
		Thread.sleep(6000);
		obj.toTestTheReplyIconAndFavContactsSelection();
	}

	@AfterTest
	public void killApp() {
		driver.closeApp();

	}

}
