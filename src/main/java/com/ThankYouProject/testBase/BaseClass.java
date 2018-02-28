package com.ThankYouProject.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.IExtentTestClass;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	public static Properties loc, test;
	public static File file;
	public static FileInputStream filereader;
	public static AndroidDriver<AndroidElement> driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;


	public void initialization() throws IOException {
		loadProperties();
		driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		/*extent = new ExtentReports(System.getProperty("user.dir") + "/src/test/java/com/ThankYouProject/testReport/"
				+ formater.format(calendar.getTime()) + ".html", false);*/
		extent = new ExtentReports(System.getProperty("user.dir") + "/src/test/java/com/ThankYouProject/testReport/"
				+ "ThankyouProjectAutomationReport" + ".html", true);
		
	}

	public void getresult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, result.getName() + " test is pass");
			String PassLabel = "<span style='border:1px solid green;border-radius: 5px; padding:1px;background:green;color:white;margin-right:2px;'>PASS</span>";
			//String html = PassLabel + "<span style='color:green;'>" + " : Test is Pass" + "</span>";
			extentTest.log(LogStatus.PASS, PassLabel);

		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP,result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());
			String FailLabel = "<span style='border:1px solid red;border-radius: 5px; padding:1px;background:red;color:white;margin-right:2px;'>FAIL</span>";
			//String html = FailLabel + "<span style='color:red;'>" + " : Test is Failed" + "</span>";

			extentTest.log(LogStatus.FAIL, FailLabel);
			String FailLabel1 = "<span style='border:1px solid red;border-radius: 5px; padding:1px;background:red;color:white;margin-right:2px;'>FAIL SCREENSHOT</span>";

			extentTest.log(LogStatus.FAIL, FailLabel1);
		
			extentTest.log(LogStatus.FAIL, extentTest.addBase64ScreenShot("data:image/png;base64," + CaptureScreenForReport_Base64()));

		} else if (result.getStatus() == ITestResult.STARTED) {
			extentTest.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}
	
	public static String CaptureScreenForReport_Base64() {
       return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        
      }

	
	@AfterMethod()
	public void afterMethod(ITestResult result) throws IOException {
		getresult(result);
	}

	@BeforeMethod()
	public void beforeMethod(Method result) {
		//extentTest = extent.startTest(result.getName());

		//extentTest = extent.startTest((this.getClass().getSimpleName() + "::" + result.getName()), result.getName());
		extentTest = extent.startTest(result.getName());
		//extentTest = extent.startTest(result.getClass().getName());
		
		//extentTest = extent.startTest((this.getClass().getSimpleName()), result.getName());
		extentTest.log(LogStatus.INFO, result.getName() + " test Started");

		extentTest.assignAuthor("Nature9");
		// extentTest.assignCategory("Regression Test");
	}

	@AfterClass(alwaysRun = true)
	public void endTest() {
		// driver.quit();
		extent.endTest(extentTest);
		extent.flush();
	}

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

		File appDir = new File("src");
		File app = new File(appDir, "app-release.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, test.getProperty("EmulatorNameTD"));
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability("autoAcceptAlerts", true);
		capabilities.setCapability("autoGrantPermissions", "true");
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		return driver;

	}

	public static void loadProperties() throws IOException {
		test = new Properties();
		file = new File(
				System.getProperty("user.dir") + "/src/main/java/com/ThankYouProject/config/testdata.properties");
		filereader = new FileInputStream(file);
		test.load(filereader);

		loc = new Properties();
		file = new File(
				System.getProperty("user.dir") + "/src/main/java/com/ThankYouProject/config/locator.properties");
		filereader = new FileInputStream(file);
		loc.load(filereader);
	}

}
