package com.ThankYouProject.testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ThankYouProject.pages.Settings;
import com.ThankYouProject.testBase.BaseClass;

public class SettingsPageTest extends BaseClass {
	Settings settings;
	@BeforeTest
	public void setup() throws IOException{
		initialization();
		settings=new Settings(driver);
	}
	@Test
	public void settingsPageTest() throws Exception{
		settings.goToSettingPage();
	}
	@AfterTest
	public void killApp(){
		driver.closeApp();
		//@25feb18
	}
	
}