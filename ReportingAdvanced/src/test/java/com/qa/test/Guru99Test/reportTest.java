package com.qa.test.Guru99Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class reportTest {

	public static ExtentReports report;
	public ExtentTest test;

	public WebDriver driver;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@After
	public void tearDown() {

		driver.quit();

	}

	@BeforeClass

	public static void setupClass() {

		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AutomationReports\\BasicReport.html", true);

	}
	
	@AfterClass
	
	public static void tearDownClass() {
		
		report.flush();
		
	}

	@Test
	public void verifyHomePageTitle() {

		test = report.startTest("Verify application Title");

		test.log(LogStatus.INFO, "Browser started");

		driver.get("https://www.google.com/");
		
		String title = driver.getTitle();

		HelperMethods.screenshot(driver);
		
		test.log(LogStatus.INFO, "Screenshot took");

		if (title.equals("Google")) {
			// report the test as a pass
			test.log(LogStatus.PASS, "Title Matches");
		} else {
			test.log(LogStatus.FAIL, "Title does not match");
		}

		report.endTest(test);
		

		assertEquals("Google", title);

	}
	
	@Test
	public void verifyLogoHeight() {

		test = report.startTest("Verify Logo Height");

		test.log(LogStatus.INFO, "Browser started");

		driver.get("https://www.google.com/");
		
		String testString = driver.findElement(By.id("hplogo")).getAttribute("height");

		HelperMethods.screenshot(driver);

		test.log(LogStatus.INFO, "Screenshot took");

		if (testString.equals("92")) {
			// report the test as a pass
			test.log(LogStatus.PASS, "Height is correct");
		} else {
			test.log(LogStatus.FAIL, "Height is not correct");
		}

		report.endTest(test);
		

		assertEquals("92", testString);

	}

}
