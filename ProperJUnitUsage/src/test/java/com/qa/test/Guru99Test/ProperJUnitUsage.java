package com.qa.test.Guru99Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProperJUnitUsage {

	WebElement element;
	WebDriver driver;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	// *[@id="tsf"]/div[2]/div[3]/center/input[1]

	@Test
	public void layoutTest() {
		//
		// System.out.println("Starting test " + new Object() {
		// }.getClass().getEnclosingMethod().getName());

		// Selenium Test

		driver.get("https://www.google.com/");

		// assertNull(element);
		//
		// System.out.println("Ending test " + new Object() {
		// }.getClass().getEnclosingMethod().getName());
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
