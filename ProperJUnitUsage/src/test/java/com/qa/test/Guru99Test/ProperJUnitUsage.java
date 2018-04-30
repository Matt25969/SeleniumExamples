package com.qa.test.Guru99Test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProperJUnitUsage {

	WebElement element;
	WebDriver driver;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void layoutTest() {

		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// Selenium Test

		assertNull(element);

		System.out.println("Ending test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
