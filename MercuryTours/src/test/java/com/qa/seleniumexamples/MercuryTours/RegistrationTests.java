package com.qa.seleniumexamples.MercuryTours;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.qa.seleniumexamples.MercuryTours.Pages.CreateAccountSuccess;
import com.qa.seleniumexamples.MercuryTours.Pages.FlightPage;
import com.qa.seleniumexamples.MercuryTours.Pages.LandingPage;
import com.qa.seleniumexamples.MercuryTours.Pages.RegistrationPage;
import com.qa.seleniumexamples.MercuryTours.Pages.SignInPage;
import com.qa.seleniumexamples.MercuryTours.Utility.Constant;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RegistrationTests {

	WebDriver driver = null;
	Actions action = null;
	ExtentReports report = null;
	ExtentTest test = null;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", Constant.driverLocation);

		driver = new ChromeDriver();
		action = new Actions(driver);

		report = new ExtentReports(Constant.folderPath + Constant.reportFile, true);

		test = report.startTest("Mercury Tours Registration");

		driver.get("http://newtours.demoaut.com/");

	}

	@Test
	public void regTest() {

		LandingPage page = PageFactory.initElements(driver, LandingPage.class);

		test.log(LogStatus.INFO, "Clicking Registration Button");

		page.clickReg();

		RegistrationPage regPage = PageFactory.initElements(driver, RegistrationPage.class);

		test.log(LogStatus.INFO, "Filling out the form");

		regPage.fillOutForm(action);

		CreateAccountSuccess successPage = PageFactory.initElements(driver, CreateAccountSuccess.class);

		successPage.clickLink();

		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);

		test.log(LogStatus.INFO, "Attempting to sign in with new credentials");

		signInPage.enterDetails(action);

		FlightPage flightPage = PageFactory.initElements(driver, FlightPage.class);

		try {
			assertEquals("SIGN-OFF", flightPage.checkButton());

			test.log(LogStatus.PASS, "Successfully logged in");
		} catch (Exception E) {

			test.log(LogStatus.FAIL, "Unable to Login");

		} finally {
			report.endTest(test);
			report.flush();

		}

	}

	@After
	public void tearDown() {

		driver.close();

	}

}
