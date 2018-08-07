package com.qa.seleniumexamples.CookieClicker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class CookieTest {

	WebDriver driver = null;

	Actions action = null;

	@Before
	public void method() {
		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);

		driver.get("http://orteil.dashnet.org/cookieclicker/");

		driver.manage().window().maximize();

	}

	@Test
	public void testBingSearch() throws InterruptedException {

		CookiePageWithAjax page = PageFactory.initElements(driver, CookiePageWithAjax.class);
		page.method(driver);

	}

	@After
	public void tearDown() throws InterruptedException {

		Thread.sleep(3000);
		driver.close();

	}

}
