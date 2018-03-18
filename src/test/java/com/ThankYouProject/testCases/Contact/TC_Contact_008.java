package com.ThankYouProject.testCases.Contact;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.Contacts;
import com.ThankYouProject.testBase.BaseClass;

public class TC_Contact_008 extends BaseClass {
	Contacts obj;

	@BeforeTest
	public void setup() throws IOException {
		initialization();
		obj = new Contacts(driver);
	}

	@Test
	public void userIsAbleToAddContact() throws Exception {
		obj.scrollingContactsInHomePage();
	}

//	@AfterTest
//	public void killApp() {
//		driver.closeApp();
//
//	}
	


}




