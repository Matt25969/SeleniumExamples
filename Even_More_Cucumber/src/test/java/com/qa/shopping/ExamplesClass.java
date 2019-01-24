package com.qa.shopping;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExamplesClass {

	WebDriver driver;
	
	ExtentTest test;

	String url = "";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		test = TestRunner.report.startTest("New Test");
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) {
		bingHomePage page = PageFactory.initElements(driver, bingHomePage.class);
		page.sendKeysToSearch(arg1);
		test.log(LogStatus.INFO, arg1 + " Test started");
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search() {
		// Write code here that turns the phrase above into concrete actions
		
		System.out.println(url);
		
		System.out.println(driver.getCurrentUrl());
		
		test.log(LogStatus.PASS, "Test passed");
		
		assertTrue(!url.equals(driver.getCurrentUrl()));
	}

	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) {
		// Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
//		url = driver.getCurrentUrl();
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		
		
	}
}
