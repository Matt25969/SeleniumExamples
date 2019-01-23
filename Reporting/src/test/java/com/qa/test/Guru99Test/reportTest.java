package com.qa.test.Guru99Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class reportTest {

	public ExtentReports report;
	public ExtentTest test;
	
	public WebDriver driver;
	
	@After
	public void tearDown() {
		
		driver.quit();
		
	}

	@Test
	public void verifyHomePageTitle() {

		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AutomationReports\\BasicReport.html", true);

		test = report.startTest("Verify application Title");

		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// add a note to the test
		test.log(LogStatus.INFO, "Browser started");

		driver.get("https://www.qa.com/");
		String title = driver.getTitle();


		if (title.equals(" Training | Project Management Training | Business Skills Training | QA")) {
			// report the test as a pass
			test.log(LogStatus.PASS, "verify Title of the page");
		} else {
			test.log(LogStatus.FAIL, "verify Title of the page");
		}
		
		report.endTest(test);
		report.flush();
		
		assertEquals("IT Training | Project Management Training | Business Skills Training | QA",title);

	}

}
