package com.qa.test.Guru99Test;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class DDTReadFromFile {

	WebDriver driver;
	static ExtentReports report;
	static ExtentTest test;
	String LoginData = "";
	
	

	@BeforeClass
	public static void beforeClass() {
		report = new ExtentReports(
				"C:\\Users\\Admin\\Desktop\\Course Examples Master\\Automated Testing Repo\\SeleniumExamples"
						+ "\\DDT.html");
	}

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void excelTest() throws IOException, InterruptedException {

		FileInputStream file = new FileInputStream(
				"C:\\Users\\Admin\\Desktop\\Course Examples Master\\Automated Testing Repo\\SeleniumExamples\\LoginData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

			Cell username = sheet.getRow(i).getCell(0);
			Cell password = sheet.getRow(i).getCell(1);

			String user = username.getStringCellValue();
			String pass = password.getStringCellValue();

			test = report.startTest("StartingTest, User:" + user );

			driver.get("http://asp.thedemosite.co.uk/");
			test.log(LogStatus.INFO, "navigate to demosite homepage");

			test.log(LogStatus.INFO, "inputting new username: " + user);

			driver.findElement(By.xpath(
					"/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/small/strong/a[3]"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By
					.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/input"))
					.click();
			driver.findElement(By
					.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/input"))
					.sendKeys(user);

			test.log(LogStatus.INFO, "inputting new password: " + pass);

			driver.findElement(By
					.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/input"))
					.click();
			driver.findElement(By
					.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/input"))
					.sendKeys(pass);

			test.log(LogStatus.INFO, "Saving new user");

			driver.findElement(By
					.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/input"))
					.click();

			test.log(LogStatus.INFO, "navigate to login");

			driver.findElement(By.xpath(
					"/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/small/strong/a[4]"))
					.click();
			Thread.sleep(1000);

			test.log(LogStatus.INFO, "Entering username on login screen");

			driver.findElement(By
					.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[1]/td[2]/input"))
					.click();
			driver.findElement(By
					.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[1]/td[2]/input"))
					.sendKeys(user);

			test.log(LogStatus.INFO, "Entering password in login screen");

			driver.findElement(By
					.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[2]/td[2]/input"))
					.click();
			driver.findElement(By
					.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[2]/td[2]/input"))
					.sendKeys(pass);

			test.log(LogStatus.INFO, "Saving login, testing if it exists");

			driver.findElement(By
					.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[3]/td[2]/input"))
					.click();

			String title = driver.findElement(By.xpath("/html/body/big/blockquote/blockquote/div/h2/font/center/b"))
					.getText();

			String expected = "**Successful Login**";
			assertEquals(expected, title);
			test.log(LogStatus.PASS, "Successfully created a user and logged in with it");

			Thread.sleep(1000);
			report.endTest(test);

		}
	}

	@After
	public void tearDown() {

		driver.quit();

	}

	@AfterClass
	public static void afterClass() {
		report.flush();

	}

}