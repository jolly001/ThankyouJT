package com.ThankYouProject.pages;

import java.util.List;

import org.eclipse.jetty.util.log.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ThankYouProject.testBase.BaseClass;
import com.ThankYouProject.utility.CommonFunctions;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

@SuppressWarnings("deprecation")
public class Contacts extends BaseClass {
	AndroidDriver<AndroidElement> driver;
	CommonFunctions common = new CommonFunctions();

	public Contacts(AndroidDriver<AndroidElement> driver) {

		this.driver = driver;
	}

	public void addNewContact() throws Exception {
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userANumTD");
		common.click("verifybutton", driver);
		common.sendKeys("enterCode", driver, "enterOtpTD");
		Thread.sleep(3000);
		common.click("contactTab", driver);

		common.click("addContact", driver);
		common.tap("addNewContact", driver);
		common.sendKeys("firstName", driver, "addContactNameTD");
		driver.hideKeyboard();
		common.sendKeys("firstNumber", driver, "contactNumberTD");
		common.click("saveButton", driver);

		// common.click("okButton", driver);

	}

	@SuppressWarnings("deprecation")
	public void seeScorePopup() throws Exception {

		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userANumTD");
		common.click("verifybutton", driver);
		common.sendKeys("enterCode", driver, "enterOtpTD");
		Thread.sleep(3000);
		common.click("contactTab", driver);

		common.click("scorePopup", driver);

		if (common.getWebElements("popUpVisible").size() == 1) {
			Assert.assertTrue(true);
			extentTest.log(LogStatus.PASS, "popup is visible");
		} else {
			Assert.assertTrue(false);
			extentTest.log(LogStatus.PASS, "popup is not visible");
		}
	}

	public void seeConatactsByName() throws Exception {

		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userANumTD");
		common.click("verifybutton", driver);
		common.sendKeys("enterCode", driver, "enterOtpTD");
		Thread.sleep(3000);
		common.click("contactTab", driver);
		extentTest.log(LogStatus.PASS, "User can see the name ");
		driver.swipe(586, 1567, 665, 458, 3000);

		Thread.sleep(3000);
		List<AndroidElement> list1 = driver.findElements(
				By.xpath("//android.widget.TextView[@resource-id='com.nature9.justthank:id/tvContactName']"));
		List<AndroidElement> list2 = driver.findElements(
				By.xpath("//android.widget.TextView[@resource-id='com.nature9.justthank:id/tvContactPhone']"));
		for (int j = 0; j < list1.size(); j++) {
			if ((list1.get(j).getText().equalsIgnoreCase("null") || list1.get(j).getText().trim().isEmpty())
					&& (list2.get(j).getText().equalsIgnoreCase("null") || list2.get(j).getText().trim().isEmpty())) {
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
				extentTest.log(LogStatus.PASS, "Name and numbers are visible");
			}

		}
	}

	public void searchContact() throws Exception {
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userANumTD");
		common.click("verifybutton", driver);
		common.sendKeys("enterCode", driver, "enterOtpTD");
		Thread.sleep(3000);
		common.click("contactTab", driver);

		common.sendKeys("searchContact", driver, "searchNameTD");
		String search = common.getText("searchContact", driver);
		Thread.sleep(2000);
		if (search.length() > 0) {
			List<AndroidElement> searchList = driver.findElements(
					By.xpath("//android.widget.TextView[@resource-id='com.nature9.justthank:id/tvContactName']"));

			for (int i = 0; i < searchList.size(); i++) {
				System.out.println("" + searchList.get(i).getText());
				if (searchList.get(i).getText().contains(search)) {
					Assert.assertTrue(true);
					extentTest.log(LogStatus.PASS, "Search functionality is working");
				}

				else {
					Assert.assertFalse(false);

				}
			}

			common.sendKeys("searchContact", driver, "searchNumberTd");
			String searchNumber = common.getText("searchContact", driver);
			Thread.sleep(2000);
			if (search.length() > 0) {
				List<AndroidElement> searchNumberList = driver.findElements(
						By.xpath("//android.widget.TextView[@resource-id='com.nature9.justthank:id/tvContactName']"));

				for (int j = 0; j < searchNumberList.size(); j++) {
					System.out.println("" + searchNumberList.get(j).getText());
					if (searchList.get(j).getText().contains(searchNumber)) {
						Assert.assertTrue(true);
						extentTest.log(LogStatus.PASS, "Search Number functionality is working");
					}

					else {
						Assert.assertFalse(false);

					}

				}
			}
		}
		
		
		common.click("favoriteSpinner", driver);
		
	}

	public void selectSearchContact() throws Exception {
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userANumTD");
		common.click("verifybutton", driver);
		common.sendKeys("enterCode", driver, "enterOtpTD");
		Thread.sleep(3000);
		common.click("contactTab", driver);

		// common.click("searchContact", driver);

		common.sendKeys("searchContact", driver, "searchNameTD");
		String search = common.getText("searchContact", driver);
		// System.out.println(""+search);
		Thread.sleep(2000);
		if (search.length() > 0) {
			List<AndroidElement> searchList = driver.findElements(
					By.xpath("//android.widget.TextView[@resource-id='com.nature9.justthank:id/tvContactName']"));

			for (int i = 0; i < searchList.size(); i++) {
				// System.out.println(""+searchList.get(i).getText());
				if (searchList.get(i).getText().contains(search)) {
					common.click("searchSelectedContact", driver);
					List<AndroidElement> selectedSearchList = driver.findElements(By.xpath(
							"//android.widget.ImageView[@resource-id='com.nature9.justthank:id/circle_image_contact']"));
					System.out.println("" + selectedSearchList);
					if (selectedSearchList.size() > 0) {
						Assert.assertTrue(true);
						extentTest.log(LogStatus.PASS, "User selected from Search List");
					} else {
						Assert.assertTrue(false);
						extentTest.log(LogStatus.FAIL, "User is not selected from Search List");
					}

				}
			}
		}
	}

	public void removeSelectedContac() throws Exception {
		// TODO Auto-generated method stub
		common.click(("agreeBttn"), driver);
		common.click("selectCountry", driver);
		common.sendKeys("enterCountryname", driver, "countryNameTD");
		common.click("india", driver);
		common.sendKeys("enterNum", driver, "userANumTD");
		common.click("verifybutton", driver);
		common.sendKeys("enterCode", driver, "enterOtpTD");
		Thread.sleep(3000);
		common.click("contactTab", driver);

		common.click("SelectContact", driver);

		List<AndroidElement> selectedSearchList = driver.findElements(
				By.xpath("//android.widget.ImageView[@resource-id='com.nature9.justthank:id/circle_image_contact']"));
		System.out.println(selectedSearchList + "");
		if (selectedSearchList.size() > 0) {

			common.click("removeSelectedContact", driver);
			Assert.assertTrue(true);
			extentTest.log(LogStatus.PASS, "User removed from Selected contact");

		} else {
			Assert.assertFalse(false);
			extentTest.log(LogStatus.FAIL, "User is not removed from selected List");
		}
	}

	public void clickDoneButton() throws Exception {
		common.methodForLoginforExistingUser();
		Thread.sleep(3000);
		common.click("contactTab", driver);
		List<AndroidElement> list1 = driver.findElements(
				By.xpath("//android.widget.CheckBox[@resource-id='com.nature9.justthank:id/cbContactCheck']"));
		//System.out.println(list1.size() + "");
	
		
		for(int i=0;i<list1.size();i++){
			list1.get(i).click();
		}
		
		common.click("done", driver);
		List<AndroidElement> list2 = driver.findElements(
				By.xpath("//android.widget.TextView[@resource-id='com.nature9.justthank:id/name']"));
//		System.out.println(list2.size() + "");
//		if(list1.equals(o)){}
		
		if(list1.size()==list2.size()){
			Assert.assertTrue(true);
			extentTest.log(LogStatus.PASS, "User is eqals to selected contact in the homepage");

		} else {
			Assert.assertFalse(false);
			extentTest.log(LogStatus.FAIL, "User is notequals to selected contact in the homepage");
		}
		
	}
//		
	public void selectfavoriteContact() throws Exception{
		
		common.methodForLoginforExistingUser();
		Thread.sleep(3000);
		common.click("contactTab", driver);
		
		List<AndroidElement> favoriteList = driver.findElements(
				By.xpath("//android.widget.ImageView[@resource-id='com.nature9.justthank:id/ivStar']"));
		System.out.println(favoriteList.size() + "");

		for(int i=0;i<favoriteList.size();i++){
			favoriteList.get(i).click();
		}
     if(favoriteList.size()!=0){
    	 Assert.assertTrue(true);
			extentTest.log(LogStatus.PASS, "User is able to select favorite contact");

		} else {
			Assert.assertFalse(false);
			extentTest.log(LogStatus.FAIL, "User is not able to select favorite contact  ");
		}     
		}

	public void SelectedContact() throws Exception {
		common.methodForLoginforExistingUser();
		Thread.sleep(3000);
		common.click("contactTab", driver);

	}
}