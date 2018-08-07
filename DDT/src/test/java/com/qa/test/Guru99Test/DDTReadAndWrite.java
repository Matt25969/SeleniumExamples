package com.qa.test.Guru99Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DDTReadAndWrite {

	WebDriver driver;
	ExtentTest testReport;

	@Before
	public void setUp() throws Exception {
		ExcelUtils.setExcelFile(Constants.pathTestData + Constants.fileTestData, 0);

		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		ExtentReports report = new ExtentReports(
				"C:\\Users\\Admin\\Desktop\\SeleniumExamples\\ExcelUtilsDemoTestReport.html", true);

		for (int i = 1; i < ExcelUtils.getExcelWSheet().getPhysicalNumberOfRows(); i++) {

			testReport = report.startTest("Excel Data Test: " + i);

			testReport.log(LogStatus.INFO, "Opening Browser");

			Thread.sleep(1000);

			driver.get(Constants.websiteURL);

			testReport.log(LogStatus.INFO, "Navigated to thedemosite.co.uk");

			testReport.log(LogStatus.INFO, "Set up Excel Utils path - Opened file stream");

			driver.get(Constants.registerURL);
			testReport.log(LogStatus.INFO, "Clicked on link to addUser page");
			WebElement addUser = driver.findElement(By.xpath(
					"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
			addUser.click();
			addUser.sendKeys(ExcelUtils.getCellData(i, 0));
			testReport.log(LogStatus.INFO, "Input Username");
			WebElement addPass = driver.findElement(By.xpath(
					"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
			addPass.click();

			addPass.sendKeys(ExcelUtils.getCellData(i, 1));
			testReport.log(LogStatus.INFO, "Input password");
			WebElement save = driver.findElement(By.xpath(
					"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
			save.click();
			testReport.log(LogStatus.INFO, "Created New User");

			driver.get(Constants.loginURL);
			testReport.log(LogStatus.INFO, "Navigated to login page");
			WebElement username = driver.findElement(By.xpath(
					"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
			username.click();
			username.sendKeys(ExcelUtils.getCellData(i, 0));
			testReport.log(LogStatus.INFO, "Input Username");
			WebElement password = driver.findElement(By.xpath(
					"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
			password.click();
			password.sendKeys(ExcelUtils.getCellData(i, 1));
			testReport.log(LogStatus.INFO, "Input password");
			WebElement loginButton = driver.findElement(By.xpath(
					"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
			loginButton.click();
			testReport.log(LogStatus.INFO, "Logged In");

			Actions action = new Actions(driver);

			action.moveByOffset(10, 10).perform();

			Thread.sleep(1000);

			String title = driver
					.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"))
					.getText();
			String expected = "**Successful Login**";

			if (!title.equals(expected)) {
				testReport.log(LogStatus.FAIL, "Demo Site Login Test");
				report.endTest(testReport);
				report.flush();
				ExcelUtils.setCellData("Fail", i, 2);
			}

			assertEquals(expected, title);

			ExcelUtils.setCellData("Pass", i, 2);
			testReport.log(LogStatus.PASS, "Demo Site Login Test");
			report.endTest(testReport);
		}

		report.flush();
	}

}