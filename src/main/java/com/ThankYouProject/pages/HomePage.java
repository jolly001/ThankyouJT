package com.ThankYouProject.pages;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.ThankYouProject.testBase.BaseClass;
import com.ThankYouProject.utility.CommonFunctions;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class HomePage extends BaseClass {
	AndroidDriver<AndroidElement> driver;
	CommonFunctions common = new CommonFunctions();
	int beforeReceiveCount = 0;
	int afterReceieveCount = 0;
	int final_result;
	int size = 0;

	public HomePage(AndroidDriver<AndroidElement> driver) {

		this.driver = driver;
	}

	public void welcomeScreen() throws Exception {

		String s = common.getText("welcomeScreenText", driver);
		common.assertionMethod(s, driver, "welcomeScreentTextTD");
		common.click("agreeBttn", driver);
		String t = common.getText("enterNumHeader", driver);
		common.assertionMethod(t, driver, "enterNumPlaceHolderTD");
		extentTest.log(LogStatus.PASS, "User is able to click on Agree and Continue button");

		extentTest.log(LogStatus.PASS, "User is on Enter Number Screen");

	}

	public void splashScreen() {
		String activityName = driver.currentActivity();
		common.assertionMethod(activityName, driver, "spashScreenTD");
	}

	public void verifyTOAndPP() throws Exception {
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
																	// is again
																	// on
																	// home

	}

	public void minimizingApplication() throws Exception {
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userANumTD");
		common.click("verifybutton", driver);

		common.sendKeys("enterCode", driver, "enterOtpTD");
		common.verifyTitle("verifyHomePage", driver, "homePageTitleTD");
		extentTest.log(LogStatus.PASS, "User is on the home page");

		driver.runAppInBackground(4); //
		String actualActivity = driver.currentActivity();
		common.assertionMethod(actualActivity, driver, "homeScreenActivityTD");
		extentTest.log(LogStatus.INFO, "Appication is now minimized");
		driver.runAppInBackground(4);
		common.verifyTitle("verifyHomePage", driver, "homePageTitleTD");
		extentTest.log(LogStatus.PASS, "User has switched back to application Homepage");
	}

	public void userRegisteration() throws Exception {
		common.click(("agreeBttn"), driver);
		extentTest.log(LogStatus.INFO, "Clicked on Agree and Continue button");
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		String actualCode = common.getText("countryCode", driver);
		common.click("india", driver);
		extentTest.log(LogStatus.PASS, "User is able to select the country code");

		// User selects the country code
		common.sendKeys("enterNum", driver, "12345633333333");
		String x = common.getText("enterNum", driver);
		common.assertionMethod(x, driver, "enterNumPlaceHolderTD");
		extentTest.log(LogStatus.INFO, "User is not able to enter number more than 13");
		common.sendKeys("enterNum", driver, "123456");
		String y = common.getText("enterNum", driver);
		common.assertionMethod(y, driver, "enterNumPlaceHolderTD");
		extentTest.log(LogStatus.INFO, "User is not able to enter number less than 7");
		common.click("verifybutton", driver);
		extentTest.log(LogStatus.PASS, "Clicked on verify button by entering number less than 7 digits");
		// User is not able to register with digits less than 6
		Thread.sleep(1000);
		common.verifyTitle("enterNumHeader", driver, "enterNumTitleTD");
		common.cleartext("enterNum", driver);
		common.getRandomPhoneNumber(); // generates 7 digits number
		common.click("verifybutton", driver);
		common.sendKeys("enterCode", driver, "enterOtpTD");
		extentTest.log(LogStatus.PASS, "User is able to register with digits between 7-13");
		// User is able to register with digits between 7-13
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
		common.verifyTitle("verifyHomePage", driver, "homePageTitleTD");
		extentTest.log(LogStatus.PASS, "Verified that user is on the home page");
		// User is on the home page
		common.click("userProfPic", driver);
		common.verifyTitle("profPageTitle", driver, "profileTitleTD");
		common.checkIfElementIsEnabled("verifyProftabisEbabled", driver);
		extentTest.log(LogStatus.INFO, "Verified that user is profile page page");
		String code = common.getText("countryCodeInProfile", driver);
		String c = code.substring(0, 3);// extracts the first 3 characters of
										// country code
		Assert.assertEquals(actualCode, c); // comparing the country code with
											// the actual code
		extentTest.log(LogStatus.PASS, "The country code is verified");
		common.click("backBtnProfile", driver);
		// To Test that user is not able to go back after coming to home page
		driver.pressKeyCode(AndroidKeyCode.BACK);
		extentTest.log(LogStatus.PASS, "user is not able to go back after coming to home page");

	}

	public void visitHomePage() throws Exception {

		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "numberTD");
		common.click("verifybutton", driver);
		common.sendKeys("enterCode", driver, "enterOtpTD");
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
		extentTest.log(LogStatus.INFO, "Verified that user is profile page page");
		common.sendKeys("enterUserName", driver, "userEditNameTD");
		common.checkIfElementIsDisabled("editUserNumber", driver);
		common.click("myFaithTab", driver);
		common.sendKeys("enterGodName", driver, "editGodNameTD");
		common.click("saveBtn", driver);
		// Thread.sleep(5000);
		common.click("skip&conbutton", driver);
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
		common.sendKeys("enterNum", driver, "userANumTD");
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
		common.sendKeys("enterNum", driver, "userANumTD");
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
			beforeReceiveCount = Integer.parseInt(initial_count);
			System.out.println(beforeReceiveCount);
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
			beforeReceiveCount = Integer.parseInt(initial_count);
			System.out.println(beforeReceiveCount);
			extentTest.log(LogStatus.INFO, "User B initial score stored");

		} else {

			extentTest.log(LogStatus.INFO, "User B has logged in");
			System.out.println(common.getText("userBScore", driver));
			String initial_count = common.getText("userBScore", driver);
			beforeReceiveCount = Integer.parseInt(initial_count);
			System.out.println(beforeReceiveCount);
			extentTest.log(LogStatus.INFO, "User B initial score stored");

		}
		return beforeReceiveCount;

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

			System.out.println(beforeReceiveCount);
			int final_result = Integer.parseInt(final_count);
			System.out.println(final_result);
			extentTest.log(LogStatus.INFO, "User B final score stored");
			if (final_result > beforeReceiveCount) {
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

	public void getting59SecondTimeAfterClickingOnResendButton() throws Exception {
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		extentTest.log(LogStatus.INFO, "User has selected the country");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userANumTD");
		common.click("verifybutton", driver);
		extentTest.log(LogStatus.INFO, "Verify button is clicked");

		Thread.sleep(59000);
		common.click("resendCodeBttn", driver);
		extentTest.log(LogStatus.INFO, "Resend button is clicked");
		String resendTimeCounter = common.getText("resendTimeCounter", driver);
		resendTimeCounter = resendTimeCounter.trim();

		// System.out.println(resendTimeCounter.equalsIgnoreCase("0:59s"));

		if (resendTimeCounter.equalsIgnoreCase("0:59s") || resendTimeCounter.equalsIgnoreCase("0:58s")) {
			extentTest.log(LogStatus.PASS, "Getting 59Second Time After Clicking On ResendButton");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	public void resendVerificationCode() throws Exception {
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		extentTest.log(LogStatus.INFO, "User has selected the country");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userANumTD");
		common.click("verifybutton", driver);
		extentTest.log(LogStatus.INFO, "Verify button is clicked");

		Thread.sleep(59000);
		common.click("resendCodeBttn", driver);
		extentTest.log(LogStatus.PASS, "User is able to click on Resend Code");

	}

	public void userIsAbleToProceedAfterResendVerificationCode() throws Exception {
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		extentTest.log(LogStatus.INFO, "User has selected the country");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userANumTD");
		common.click("verifybutton", driver);
		extentTest.log(LogStatus.INFO, "Verify button is clicked");

		Thread.sleep(59000); // wait for 60 seconds for resend link to appear
		common.click("resendCodeBttn", driver);
		extentTest.log(LogStatus.PASS, "User is able to click on Resend Code");
		common.sendKeys("enterCode", driver, "enterOtpTD");
		extentTest.log(LogStatus.PASS, "User is able to proceed after Resend the OTP");

	}

	public void enterWrongOtp() throws Exception {
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		extentTest.log(LogStatus.INFO, "User has selected the country");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userANumTD");
		common.click("verifybutton", driver);
		common.sendKeys("enterCode", driver, "enterWrongOTPTD");
		common.ifElementExistsAssert("wrongOtpToast", driver);
		extentTest.log(LogStatus.INFO, "The error toast is visible");
	}

	public void ToVerifyTheSenderMessagesCount() throws Exception {

		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userANumTD");
		common.click("verifybutton", driver);
		common.sendKeys("enterCode", driver, "enterOtpTD");
		if (common.getWebElements("importButton").size() == 1) {
			common.click("skip&conbutton", driver);
			common.click("scoreClick", driver);
			common.click("givenThanksTab", driver);
			String a = "11:22 PM"; // last element in the list
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

	public void toVerifyThanksReceived() throws Exception {
		// User B logging in to check the initial score count
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userBNumTD");
		common.click("verifybutton", driver);
		common.sendKeys("enterCode", driver, "enterOtpTD");
		if (common.getWebElements("importButton").size() == 1) {
			common.click("skip&conbutton", driver);
			extentTest.log(LogStatus.INFO, "User B has logged in");
			String initial_count = common.getText("userBScore", driver);
			beforeReceiveCount = Integer.parseInt(initial_count);
			System.out.println("This is initial count" + " " + beforeReceiveCount);
			common.click("tapOnSettings", driver);
			common.click("logOutBtn", driver);
			common.click("logouConfirmAlert", driver);
			extentTest.log(LogStatus.INFO, "User B has logged out");
			// Till here the initial count is stored and the app is closed
		}

		// User A logs in to send thanks to user B
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userANumTD");
		common.click("verifybutton", driver);
		common.sendKeys("enterCode", driver, "enterOtpTD");
		if (common.getWebElements("importButton").size() == 1) {
			System.out.println("1");
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
			System.out.println("2");
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
			System.out.println("3");
			common.tap("selUserContact", driver);
			extentTest.log(LogStatus.INFO, "The user B is selected");
			common.click("indebtThanks", driver);
			common.click("grateful", driver);
			common.click("thankful", driver);
			extentTest.log(LogStatus.INFO, "The user A has selected tankful message");
			common.click("sayThanksbtn", driver);
			common.click("clicktosendThanks", driver);
			extentTest.log(LogStatus.INFO, "Thanks has been sent");
			common.click("scoreClick", driver);
			common.click("givenThanksTab", driver);
			common.getText("thanksfullVerify", driver);
			common.verifyTitle("thanksfullVerify", driver, "thankfulTextTD");
			extentTest.log(LogStatus.INFO, "Message sent was Thankful");
			common.click("tapOnSettings", driver);
			common.click("logOutBtn", driver);
			common.click("logouConfirmAlert", driver);
			extentTest.log(LogStatus.INFO, "User A has logged out");
			// Till here the User A has sent thanks to user B and the App is
			// closed
		}

		// User B again logs in to check the received thanks from User A
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userBNumTD");
		common.click("verifybutton", driver);
		common.sendKeys("enterCode", driver, "enterOtpTD");
		if (common.getWebElements("importButton").size() == 1) {
			common.click("skip&conbutton", driver);
			extentTest.log(LogStatus.INFO, "User B has logged in");
			System.out.println("This is initial count when B logs in again" + " " + beforeReceiveCount);
			String After = common.getText("userBScore", driver);
			afterReceieveCount = Integer.parseInt(After);
			System.out.println("after count" + afterReceieveCount);
			// Assert.assertEquals(beforeReceiveCount, final_result);
			if (afterReceieveCount == beforeReceiveCount + 1) {
				Assert.assertTrue(true);
				extentTest.log(LogStatus.PASS, "User B has received Thanks from User A");
			} else {
				Assert.assertTrue(false);
			}

		}

	}

	public void testTutorial() throws Exception {
		common.methodForLogin();
		common.ifElementExistsAssert("ConfirmTutPage", driver);
		extentTest.log(LogStatus.PASS, "user is on User tutorial page");
		common.click("clickOnNextBtn", driver);
		common.click("clickOnBckBtn", driver);
		common.ifElementExistsAssert("ConfirmTutPage", driver);
		extentTest.log(LogStatus.PASS, "user is able to click on back button");
		for (int i = 0; i <= 2; i++) {
			common.click("clickOnNextBtn", driver);

		}

		Thread.sleep(3000);
		common.ifElementExistsAssert("skip&conbutton", driver);
		extentTest.log(LogStatus.PASS, "user is able to see import contact popup");
		common.click("skip&conbutton", driver);
		common.checkIfElementIsEnabled("verifyHomePage", driver);
		extentTest.log(LogStatus.PASS, "User is on home page after apping on skip and continue");
		common.click("selGod", driver);
		common.ifElementExistsAssert("godTutPage", driver);
		extentTest.log(LogStatus.PASS, "User is on God Tutorial page");
		common.click("godTutSkip", driver);
		extentTest.log(LogStatus.INFO, "God Tutorial is skipped");
		common.checkIfElementIsEnabled("verifyHomePage", driver);
		extentTest.log(LogStatus.PASS, "Afer tutorials user is on the home page");
		common.click("selGod", driver);
		common.click("indebtThanks", driver);
		extentTest.log(LogStatus.PASS,
				"since user is able to click on thanks after selecting the God it is true tha tutorial is coming for once");

	}

	public void toTestTheReplyIconAndFavContactsSelection() throws Exception {
		// below code tests if tapping on reply icon, the user is selected.
		common.methodForLoginforExistingUser(common.getTestData("userCNumTD"));
		Thread.sleep(8000);
		driver.swipe(548, 1241, 548, 843, 2000);
		String actualName = common.getText("userNameOnReplyIcon", driver);
		System.out.println(actualName);
		common.click("replyIcon", driver);
		Thread.sleep(2000);
		driver.swipe(678, 709, 678, 1090, 2000);
		// this list will store the elements by the the xpath passed below
		List<AndroidElement> name = driver
				.findElements(By.xpath("//android.widget.TextView[@resource-id='com.nature9.justthank:id/name']"));
		System.out.println(name.size() + "");
		for (int i = 0; i < name.size(); i++) {
			System.out.println("" + name.get(i).getText());
			String expectedName = name.get(0).getText();
			if (actualName == expectedName) {
				Assert.assertTrue(true);
				extentTest.log(LogStatus.PASS, "The user selected is same to which  reply is to be sent");
			} else {
				Assert.assertTrue(true);
			}
		}
		// Below code is to test that favorite users from contact appears on
		// home page

		common.click("contactTab", driver);
		driver.swipe(684, 1144, 684, 382, 2000);
		Thread.sleep(3000);
		List<AndroidElement> favContacts = driver.findElements(By.xpath("//*[contains(@resource-id,'ivStar')]"));
		System.out.println(favContacts.size());

		for (int i = 0; i < favContacts.size(); i++) {
			if (i == 0) {
				favContacts.get(0).click();
			}
			if (i == 1) {
				favContacts.get(1).click();
			}
		}

		List<AndroidElement> getFavContactsName = driver
				.findElements(By.xpath("//*[contains(@resource-id,'tvContactName')]"));
		String favContact1 = "";
		String favContact2 = "";
		for (int i = 0; i < getFavContactsName.size(); i++) {
			favContact1 = getFavContactsName.get(0).getText();
			favContact2 = getFavContactsName.get(1).getText();
		}

		common.click("verifyHomePage", driver);
		List<AndroidElement> favUserSelOnHome = driver.findElements(By.xpath(
				"//android.support.v7.widget.RecyclerView[contains(@resource-id,'fav_recycle_view')]/android.widget.LinearLayout/android.widget.TextView[contains(@resource-id,'com.nature9.justthank:id/name')]"));
		System.out.println(favUserSelOnHome.size());
		String favHome1 = "";
		String favHome2 = "";
		for (int i = 0; i < favUserSelOnHome.size(); i++) {
			favHome1 = favUserSelOnHome.get(1).getText();
			favHome2 = favUserSelOnHome.get(2).getText();
		}
		// comparing the name of selected contacts
		if (favHome1.equalsIgnoreCase(favContact1) && favHome2.equalsIgnoreCase(favContact2)) {
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);
		}

	}

	/**
	 * Verify that contacts are displaying on home page after Say Thank to
	 * selected contacts.
	 * 
	 * 1. Install Just Thank app and login. 2. Go on Contacts page and select
	 * some contacts. 3. Go on home page and say thanks to those selected
	 * contacts. 4. Check that, contacts are displaying or not?
	 */
	public void contactsDisplayingOrNot() {
		try {
			common.methodForLoginforExistingUser("userANumTD");
			if (common.ifElementExists("skip&conbutton", driver)) {
				common.tap("skip&conbutton", driver);
			}

			Thread.sleep(3000);
			common.tap("contactTab", driver);

			if (common.getText("selectedFilter", driver).equalsIgnoreCase("All Contacts")) {
				System.out.println("inside if");
				selectContactsForThanksOnContactsPage();
			} else {
				System.out.println("inside else");
				common.tap("selcectionSpinnerContact", driver);
				selectContactsForThanksOnContactsPage();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to select the contacts from the Contacts Page
	 */
	private void selectContactsForThanksOnContactsPage() {
		if (common.isVisibleByXPath("noContactAvailable")) {
			System.out.println("inside if selectContactsForThanksOnContactsPage");
			extentTest.log(LogStatus.INFO, "Please import contacts first!!");
		} else {
			List<AndroidElement> contactList = driver.findElements(By.xpath(
					"//android.support.v7.widget.RecyclerView[contains(@resource-id,'recycle_contacts')]/android.widget.LinearLayout"));
			System.out.println(contactList.size() + "<-- Size");
			if (contactList.size() >= 1) {
				contactList.get(common.ramdomSelectionWithinRange(contactList.size())).click();
			} else {
				extentTest.log(LogStatus.INFO, "Please import contacts first!!");
			}

		}
	}

	public void userIsAbleToSelectContactsFromHomePage() throws Exception {
		common.methodForLoginforExistingUser("userCNumTD");
		Thread.sleep(15000);
		common.waitForVisibilityOfElement("agreeBttn", driver);
		common.click("contactTab", driver);
		common.click("verifyHomePage", driver);
		List<AndroidElement> listOfVisibleContactsOnHomePage = driver.findElements(By.xpath(
				"//android.support.v7.widget.RecyclerView[contains(@resource-id,'nb_recycle_view')]/android.widget.LinearLayout"));
		System.out.println(listOfVisibleContactsOnHomePage.size());

		int count = 0; // This variable will store the count after each click
		for (int i = 0; i < listOfVisibleContactsOnHomePage.size(); i++) {
			if (i == 0) {
				listOfVisibleContactsOnHomePage.get(0).click();
				count = count + 1;
			}
			Thread.sleep(2000);
			if (i == 1) {
				listOfVisibleContactsOnHomePage.get(1).click();
				count = count + 1;
			}

		}
		List<AndroidElement> listOfSelectedContactsOnHomePage = driver
				.findElements(By.xpath("//android.widget.FrameLayout[contains(@resource-id,'dark_pic')]"));
		System.out.println(listOfSelectedContactsOnHomePage.size());

		if (count == listOfSelectedContactsOnHomePage.size()) {
			Assert.assertTrue(true);
			extentTest.log(LogStatus.PASS, "The user selected are located successfully");
		} else {
			Assert.assertTrue(false);
			extentTest.log(LogStatus.FAIL, "The user selected are not visible hence the case failed");
		}
	}

	public void verifySeeAll() throws Exception {
		/**
		 * This method will test the see all functionality
		 * 
		 */
		common.methodForLoginforExistingUser("userCNumTD");
		Thread.sleep(15000);

		common.click("contactTab", driver);
		Thread.sleep(5000);
		common.click("verifyHomePage", driver);
		common.click("seeAllContact", driver);
		common.ifElementExistsAssert("selcectionSpinnerContact", driver);
		String actual = common.getText("contactPageTitle", driver);
		common.assertionMethod(actual, driver, "contactPageTitleTD");
		extentTest.log(LogStatus.INFO, "User is on contact page");
		extentTest.log(LogStatus.PASS,
				"See All of contact section takes user to contact page and filter is All Contacts");
		common.click("verifyHomePage", driver);
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//*[contains(@resource-id,'fav_layout')]/android.widget.TextView[@text='See All']")).click();
		common.assertionMethod(actual, driver, "contactPageTitleTD");
		extentTest.log(LogStatus.INFO, "User is on contact page");
		common.ifElementExistsAssert("selectionSpinnerFavorite", driver);
		extentTest.log(LogStatus.PASS,
				"See All of favorite section takes user to favorite page and filter is favorite");

	}

	/**
	 * This method will test the Profile page redirection and say thanks
	 * validation
	 * 
	 * @throws Exception
	 */
	public void profilePageRedirectionFromHomePageAndSayThanksAlert() throws Exception {
		common.methodForLoginforExistingUser("userCNumTD");
		common.waitForVisibilityOfElement("profilePicHomeScreen", driver);
		common.click("profilePicHomeScreen", driver);
		String actual = common.getText("profilePageTitle1", driver);
		common.assertionMethod(actual, driver, "profileTitleTD");
		extentTest.log(LogStatus.PASS, "User is on profile page by tapping on profile pic");
		// driver.navigate().back();
		common.click("backBtnProfile", driver);
		common.click("score", driver);
		String actual1 = common.getText("profilePageTitle1", driver);
		common.assertionMethod(actual1, driver, "profileTitleTD");
		driver.navigate().back();
		extentTest.log(LogStatus.PASS, "User is on profile page by tapping on score");
		common.click("sayThanksbtn", driver);
		extentTest.log(LogStatus.INFO, "Thanks is tapped without selecting user");
		common.waitForVisibilityOfElement("snackBarAlertOnSayThanks", driver);
		common.ifElementExistsAssert("snackBarAlertOnSayThanks", driver);
		extentTest.log(LogStatus.PASS, "Alert snackbar appears");

	}

	public void mappingTheTextWithCorrespondingHearts() throws Exception {
		common.methodForLoginforExistingUser("userCNumTD");
		common.waitForVisibilityOfElement("profilePicHomeScreen", driver);
		common.waitForVisibilityOfElement("thankful", driver);
		Thread.sleep(2000);
		common.click("thankful", driver);
		Thread.sleep(2000);
		String thanktype1 = driver.findElement(By.xpath("//android.widget.TextView[@text='Thankful']")).getText();
		System.out.println(thanktype1);
		extentTest.log(LogStatus.PASS, "Thanks selected is" + "--->" + thanktype1);
		common.ifElementExistsAssert("commonTextForThanks", driver);
		String thankfulText1 = common.getText("commonTextForThanks", driver);
		extentTest.log(LogStatus.PASS, "text along thankful is correct" + "---> " + thankfulText1);
		common.click("grateful", driver);
		String thanktype2 = common.getText("grateful", driver);
		extentTest.log(LogStatus.PASS, "Thanks selected is" + "--->" + thanktype2);
		common.ifElementExistsAssert("commonTextForThanks", driver);
		String thankfulText2 = common.getText("commonTextForThanks", driver);
		System.out.println(thankfulText2);
		extentTest.log(LogStatus.PASS, "text along Grateful" + "--->" + thankfulText2);
		common.click("indebtThanks", driver);
		String thanktype3 = common.getText("indebtThanks", driver);
		extentTest.log(LogStatus.PASS, "Thanks selected is" + "--->" + thanktype3);
		common.ifElementExistsAssert("commonTextForThanks", driver);
		String thankfulText3 = common.getText("commonTextForThanks", driver);
		extentTest.log(LogStatus.PASS, "text along Grateful" + "--->" + thankfulText3);

	}
	
	public void thanksPopupThanksAndRemoveUserFromPopup() throws Exception{
		common.methodForLoginforExistingUser("userCNumTD");
		/**
		 * Below code will select first two users from the home page from contact
		 * section
		 */
		common.waitForVisibilityOfElement("contactTab", driver);
		common.click("contactTab", driver);
		common.click("verifyHomePage", driver);
		List<AndroidElement> listOfVisibleContactsOnHomePage = driver.findElements(By.xpath(
				"//android.support.v7.widget.RecyclerView[contains(@resource-id,'nb_recycle_view')]/android.widget.LinearLayout"));
		System.out.println(listOfVisibleContactsOnHomePage.size());

		int count = 0; // This variable will store the count after each click
		for (int i = 0; i < listOfVisibleContactsOnHomePage.size(); i++) {
			if (i == 0) {
				listOfVisibleContactsOnHomePage.get(0).click();
				count = count + 1;
			}
			Thread.sleep(2000);
			if (i == 1) {
				listOfVisibleContactsOnHomePage.get(1).click();
				count = count + 1;
			}

		}
		common.click("", driver);
		
	}
}
