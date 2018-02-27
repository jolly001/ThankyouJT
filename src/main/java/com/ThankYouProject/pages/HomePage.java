package com.ThankYouProject.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.testng.Assert;

import com.ThankYouProject.testBase.BaseClass;
import com.ThankYouProject.utility.CommonFunctions;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomePage extends BaseClass {
	AndroidDriver<AndroidElement> driver;
	CommonFunctions common = new CommonFunctions();
	int initial_result;
	int size = 0;

	public HomePage(AndroidDriver<AndroidElement> driver) {

		this.driver = driver;
	}

	public void spalshScreen() {
		//// common.applywait();
		try {
			if (driver
					.findElement(By.xpath("//android.widget.ProgressBar[contains(@resource-id,'splash_progress_bar')]"))
					.isDisplayed() == true) {
				Assert.assertTrue(true, "You are on the splash screen and the progress bar is detected");
			} else
				Assert.assertTrue(false, "splash screen not detected");

		} catch (InvalidSelectorException e) {
			System.out.println(e);
		}

	}

	public void welcomeScreen() throws Exception {
		// common.applywait();
		common.verifyTitle("welcomePage", driver, "welcomeTextTD");
		common.click("termsOfServ", driver);
		common.verifyTitle("tosTitle", driver, "termOfServTitleTD");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		common.click("backButton", driver);
		common.verifyTitle("welcomePage", driver, "welcomeTextTD"); // to
																	// verify
																	// user
																	// is on
																	// home
		//// common.applywait();
		common.click("privacyPolicy", driver);
		common.verifyTitle("privacypolicyHeader", driver, "privacyPolicyTitleTD");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		common.click("backButton", driver);
		common.verifyTitle("welcomePage", driver, "welcomeTextTD"); // to
																	// verify
																	// the
																	// user
																	// is on
																	// home

	}

	public void userRegisteration() throws Exception {
		common.click(("agreeBttn"), driver);
		extentTest.log(LogStatus.INFO, "Clicked on Agree and Continue button");
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "123456");
		common.click("verifybutton", driver);
		extentTest.log(LogStatus.INFO, "Clicked on verify button");
		Thread.sleep(1000);
		// for (int i = 0; i < 5; i++) {
		// common.click("allowPopup", driver);
		// }
		common.verifyTitle("enterNumHeader", driver, "enterNumTitleTD");
		common.cleartext("enterNum", driver);
		common.randomnumgen();
		common.click("verifybutton", driver);
		// common.applywait();
		common.sendKeys("enterCode", driver, "enterOtpTD");
		// common.applywait();
		common.sendKeys("enterUserName", driver, "newUserTD");
		extentTest.log(LogStatus.INFO, "user is on profile and has entered his name");
		common.click("myFaithTab", driver);
		common.sendKeys("enterGodName", driver, "newGodTD");
		extentTest.log(LogStatus.INFO, "user is on God's profile and has entered God's name");
		common.click("saveBtn", driver);
		Thread.sleep(5000);
		common.click("userTutorial", driver);
		// common.applywait();
		common.click("skip&conbutton", driver);
		extentTest.log(LogStatus.INFO, "user has skipped user tutorial");

	}

	public void visitHomePage() throws Exception {

		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "numberTD");
		common.click("verifybutton", driver);

		// for (int i = 0; i < 5; i++) {
		// common.click("allowPopup", driver);
		// }
		common.sendKeys("enterCode", driver, "enterOtpTD");
		// common.applywait();
		// if the user is a new user

		if (common.getWebElements("profPageTitle").size() == 1) {
			extentTest.log(LogStatus.INFO, "Verified that this user is a new user");
			common.sendKeys("enterUserName", driver, "userANameTD");
			common.click("myFaithTab", driver);
			common.sendKeys("enterGodName", driver, "userAGodTD");
			// common.applywait();
			common.click("saveBtn", driver);

			Thread.sleep(5000);

			common.click("userTutorial", driver);
			Thread.sleep(5000);
			common.click("skip&conbutton", driver);
			Thread.sleep(10000);
			common.click("selGod", driver);
			// common.applywait();
			common.click("godTutSkip", driver);
			extentTest.log(LogStatus.INFO, "Skipped God's tutorial");
			common.checkIfElementIsEnabled("verifyHomePage", driver);
			// if the same user is logging in again and has not imported the
			// contacts
		} else if (common.getWebElements("importButton").size() == 1) {
			common.click("skip&conbutton", driver);
			common.verifyTitle("verifyHomePage", driver, "homePageTitleTD");
			extentTest.log(LogStatus.PASS, "Verified that user is on the home page");

		} else {
			// if the same user has imported all the contacts this code will run
			common.verifyTitle("verifyHomePage", driver, "homePageTitleTD");
			extentTest.log(LogStatus.PASS, "Verified that user is on the home page");
		}

	}

	public void userIsAbleToEditProfile() throws Exception {
		visitHomePage();
		common.click("userProfPic", driver);
		common.verifyTitle("profPageTitle", driver, "profileTitleTD");
		common.checkIfElementIsEnabled("verifyProftabisEbabled", driver);
		extentTest.log(LogStatus.INFO, "Verified that user is Home page");
		common.sendKeys("enterUserName", driver, "userEditNameTD");
		common.checkIfElementIsDisabled("editUserNumber", driver);
		common.click("myFaithTab", driver);
		common.sendKeys("enterGodName", driver, "editGodNameTD");
		common.click("saveBtn", driver);
		// Thread.sleep(5000);
		// common.click("skip&conbutton", driver);
		common.click("userProfPic", driver);
		common.verifyTitle("enterUserName", driver, "confirmUsernameTD");
		extentTest.log(LogStatus.INFO, "The user name is edited successfully");
		common.click("myFaithTab", driver);
		common.verifyTitle("enterGodName", driver, "confirmGodName");
		extentTest.log(LogStatus.INFO, "The God's name is edited successfully");

	}

	public void userASendsGratefulMessage() throws Exception {
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "user1NumTD");
		common.click("verifybutton", driver);
		// for (int i = 0; i < 5; i++) {
		// common.click("allowPopup", driver);
		// }
		common.sendKeys("enterCode", driver, "enterOtpTD");
		if (common.getWebElements("importButton").size() == 1) {
			common.click("skip&conbutton", driver);
			common.click("selUserContact", driver);
			common.click("indebtThanks", driver);
			common.click("grateful", driver);
			common.click("sayThanksbtn", driver);
			common.click("clicktosendThanks", driver);
			common.click("grateful", driver);
			extentTest.log(LogStatus.INFO, "Thanks has been sent");
			common.getText("gratefulVerify", driver);
			common.verifyTitle("gratefulVerify", driver, "gratefulTextTD");
			extentTest.log(LogStatus.INFO, "Message sent was Grateful");

		} else if (common.getWebElements("profPageTitle").size() == 1) {
			common.sendKeys("enterUserName", driver, "userANameTD");
			common.click("myFaithTab", driver);
			common.sendKeys("enterGodName", driver, "userAGodTD");
			common.click("saveBtn", driver);
			System.out.println("Save is clicked");
			Thread.sleep(5000);
			common.click("userTutorial", driver);
			Thread.sleep(5000);
			common.click("skip&conbutton", driver);
			Thread.sleep(10000);
			common.click("selGod", driver);
			// common.applywait();
			common.click("godTutSkip", driver);
			common.tap("selUserContact", driver);
			extentTest.log(LogStatus.INFO, "The user name is selected");
			common.click("indebtThanks", driver);
			common.click("grateful", driver);
			extentTest.log(LogStatus.INFO, "The user has selected tankful message");
			common.click("sayThanksbtn", driver);
			common.click("clicktosendThanks", driver);
			extentTest.log(LogStatus.INFO, "Thanks has been sent");
			common.getText("thanksfullVerify", driver);
			common.verifyTitle("gratefulVerify", driver, "gratefulTextTD");
			extentTest.log(LogStatus.INFO, "Message sent was Grateful");

		} else {

			common.tap("selUserContact", driver);
			extentTest.log(LogStatus.INFO, "The user name is selected");
			common.click("indebtThanks", driver);
			common.click("grateful", driver);
			extentTest.log(LogStatus.INFO, "The user has selected tankful message");
			common.click("sayThanksbtn", driver);
			common.click("clicktosendThanks", driver);
			extentTest.log(LogStatus.INFO, "Thanks has been sent");
			common.click("scoreClick", driver);
			common.click("givenThanksTab", driver);
			common.getText("thanksfullVerify", driver);
			common.verifyTitle("gratefulVerify", driver, "gratefulTextTD");
			extentTest.log(LogStatus.INFO, "Message sent was Grateful");
		}

	}

	public void userASendsThankfulMessage() throws Exception {
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "user1NumTD");
		common.click("verifybutton", driver);
		// for (int i = 0; i < 5; i++) {
		// common.click("allowPopup", driver);
		// }
		common.sendKeys("enterCode", driver, "enterOtpTD");
		if (common.getWebElements("importButton").size() == 1) {
			common.click("skip&conbutton", driver);
			common.click("selUserContact", driver);
			common.click("indebtThanks", driver);
			common.click("grateful", driver);
			common.click("thankful", driver);
			common.click("sayThanksbtn", driver);
			common.click("clicktosendThanks", driver);
			common.click("grateful", driver);
			extentTest.log(LogStatus.INFO, "Thanks has been sent");
			common.getText("thanksfullVerify", driver);
			common.verifyTitle("thanksfullVerify", driver, "thankfulTextTD");
			extentTest.log(LogStatus.INFO, "Message sent was Thankful");

		} else if (common.getWebElements("profPageTitle").size() == 1) {
			common.sendKeys("enterUserName", driver, "userANameTD");
			common.click("myFaithTab", driver);
			common.sendKeys("enterGodName", driver, "userAGodTD");
			common.click("saveBtn", driver);
			System.out.println("Save is clicked");
			Thread.sleep(5000);
			common.click("userTutorial", driver);
			Thread.sleep(5000);
			common.click("skip&conbutton", driver);
			Thread.sleep(10000);
			common.click("selGod", driver);
			// common.applywait();
			common.click("godTutSkip", driver);
			common.tap("selUserContact", driver);
			extentTest.log(LogStatus.INFO, "The user name is selected");
			common.click("indebtThanks", driver);
			common.click("grateful", driver);
			common.click("thankful", driver);
			extentTest.log(LogStatus.INFO, "The user has selected tankful message");
			common.click("sayThanksbtn", driver);
			common.click("clicktosendThanks", driver);
			extentTest.log(LogStatus.INFO, "Thanks has been sent");
			common.getText("thanksfullVerify", driver);
			common.verifyTitle("thanksfullVerify", driver, "thankfulTextTD");
			extentTest.log(LogStatus.INFO, "Message sent was Thankful");

		} else {

			common.tap("selUserContact", driver);
			extentTest.log(LogStatus.INFO, "The user name is selected");
			common.click("indebtThanks", driver);
			common.click("grateful", driver);
			common.click("thankful", driver);
			extentTest.log(LogStatus.INFO, "The user has selected tankful message");
			common.click("sayThanksbtn", driver);
			common.click("clicktosendThanks", driver);
			extentTest.log(LogStatus.INFO, "Thanks has been sent");
			common.click("scoreClick", driver);
			common.click("givenThanksTab", driver);
			common.getText("thanksfullVerify", driver);
			common.verifyTitle("thanksfullVerify", driver, "thankfulTextTD");
			extentTest.log(LogStatus.INFO, "Message sent was Thankful");
		}

	}

	public int userBReceivesThankfulMessage() throws Exception {
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userBNumTD");
		common.click("verifybutton", driver);
		// for (int i = 0; i < 5; i++) {
		// common.click("allowPopup", driver);
		// }
		common.sendKeys("enterCode", driver, "enterOtpTD");
		if (common.getWebElements("importButton").size() == 1) {
			common.click("skip&conbutton", driver);
			extentTest.log(LogStatus.INFO, "User B has logged in");
			String initial_count = common.getText("userBScore", driver);
			initial_result = Integer.parseInt(initial_count);
			System.out.println(initial_result);
			extentTest.log(LogStatus.INFO, "User B initial score stored");

		} else if (common.getWebElements("profPageTitle").size() == 1) {
			common.sendKeys("enterUserName", driver, "userBNameTD");
			common.click("myFaithTab", driver);
			common.sendKeys("enterGodName", driver, "userBGodTD");
			common.click("saveBtn", driver);
			System.out.println("Save is clicked");
			Thread.sleep(5000);
			common.click("userTutorial", driver);
			Thread.sleep(5000);
			common.click("skip&conbutton", driver);
			Thread.sleep(10000);
			common.click("selGod", driver);
			// common.applywait();
			common.click("godTutSkip", driver);
			extentTest.log(LogStatus.INFO, "User B has logged in");
			String initial_count = common.getText("userBScore", driver);
			initial_result = Integer.parseInt(initial_count);
			System.out.println(initial_result);
			extentTest.log(LogStatus.INFO, "User B initial score stored");

		} else {

			extentTest.log(LogStatus.INFO, "User B has logged in");
			System.out.println(common.getText("userBScore", driver));
			String initial_count = common.getText("userBScore", driver);
			initial_result = Integer.parseInt(initial_count);
			System.out.println(initial_result);
			extentTest.log(LogStatus.INFO, "User B initial score stored");

		}
		return initial_result;

	}

	public void userBlogin() throws Exception {
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userBNumTD");
		common.click("verifybutton", driver);
		// for (int i = 0; i < 5; i++) {
		// common.click("allowPopup", driver);
		// }
		common.sendKeys("enterCode", driver, "enterOtpTD");
		if (common.getWebElements("importButton").size() == 1) {
			common.click("skip&conbutton", driver);
			extentTest.log(LogStatus.INFO, "User B has logged in");
			String final_count = common.getText("userBScore", driver);

			System.out.println(initial_result);
			int final_result = Integer.parseInt(final_count);
			System.out.println(final_result);
			extentTest.log(LogStatus.INFO, "User B final score stored");
			if (final_result > initial_result) {
				extentTest.log(LogStatus.INFO, "User B has received thanks");
			} else {
				extentTest.log(LogStatus.FAIL, "User B has not received thanks");
			}
			common.click("scoreClick", driver);
			common.click("receivedThanksTab", driver);
			common.getText("thanksfullVerify", driver);
			common.verifyTitle("thanksfullVerify", driver, "thankfulTextTD");

		}
	}

	public void ToVerifyTheSenderMessagesCount() throws Exception {

		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userANumTD");
		common.click("verifybutton", driver);
		// for (int i = 0; i < 5; i++) {
		// common.click("allowPopup", driver);
		// }
		common.sendKeys("enterCode", driver, "enterOtpTD");
		if (common.getWebElements("importButton").size() == 1) {
			common.click("skip&conbutton", driver);
			common.click("scoreClick", driver);
			common.click("givenThanksTab", driver);
			String a = "11:22 PM"; /// last element in the list
			Boolean found_result = false;

			while (!found_result) {

				List<AndroidElement> ele = driver
						.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'tvTime')]"));

				Thread.sleep(2000);

				size = size + ele.size();
				System.out.println(size);
				Thread.sleep(2000);
				// System.out.println("before For ---->" + size);

				for (int i = 0; i <= 2; i++) {

					String s = ele.get(i).getText();
					if (s.equals(a)) {
						found_result = true;
						// System.out.println("Before Break" + size);
						break;
					}

				}
				if (!found_result) {
					// find startx,starty, and Endy
					driver.swipe(540, 1435, 540, 358, 3000);
				}

			}
			String t = common.getText("givenThankTabCount", driver);
			int p = Integer.parseInt(t);
			Assert.assertEquals(size, p, "The given thanks count is correct");
			extentTest.log(LogStatus.PASS, "The given thanks count is correct ");

		} else if (common.getWebElements("profPageTitle").size() == 1) {
			common.sendKeys("enterUserName", driver, "userANameTD");
			common.click("myFaithTab", driver);
			common.sendKeys("enterGodName", driver, "userAGodTD");
			common.click("saveBtn", driver);
			System.out.println("Save is clicked");
			Thread.sleep(5000);
			common.click("userTutorial", driver);
			Thread.sleep(5000);
			common.click("skip&conbutton", driver);
			Thread.sleep(10000);
			common.click("selGod", driver);
			// common.applywait();
			common.click("godTutSkip", driver);
			common.click("scoreClick", driver);
			common.click("givenThanksTab", driver);

			String a = "11:22 PM"; /// last element in the list
			Boolean found_result = false;

			while (!found_result) {

				List<AndroidElement> ele = driver
						.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'tvTime')]"));

				Thread.sleep(2000);

				size = size + ele.size();
				// System.out.println(size);
				Thread.sleep(2000);
				// System.out.println("before For ---->" + size);

				for (int i = 0; i <= 2; i++) {

					String s = ele.get(i).getText();
					if (s.equals(a)) {
						found_result = true;
						// System.out.println("Before Break" + size);
						break;
					}

				}
				if (!found_result) {
					// find startx,starty, and Endy
					driver.swipe(540, 1435, 540, 358, 3000);
				}

			}
			String t = common.getText("givenThankTabCount", driver);
			int p = Integer.parseInt(t);
			Assert.assertEquals(size, p, "The given thanks count is correct");
			extentTest.log(LogStatus.PASS, "The given thanks count is correct ");
		}

		else {

			common.click("scoreClick", driver);
			common.click("givenThanksTab", driver);

			String a = "11:22 PM"; /// last element in the list
			Boolean found_result = false;

			while (!found_result) {

				List<AndroidElement> ele = driver
						.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'tvTime')]"));

				Thread.sleep(2000);

				size = size + ele.size();
				// System.out.println(size);
				Thread.sleep(2000);
				// System.out.println("before For ---->" + size);

				for (int i = 0; i <= 2; i++) {

					String s = ele.get(i).getText();
					if (s.equals(a)) {
						found_result = true;
						// System.out.println("Before Break" + size);
						break;
					}

				}
				if (!found_result) {
					// find startx,starty, and Endy
					driver.swipe(540, 1435, 540, 358, 3000);
				}

			}

			String t = common.getText("givenThankTabCount", driver);
			int p = Integer.parseInt(t);
			Assert.assertEquals(size, p, "The given thanks count is correct");
			extentTest.log(LogStatus.PASS, "The given thanks count is correct ");
		}

	}

}
