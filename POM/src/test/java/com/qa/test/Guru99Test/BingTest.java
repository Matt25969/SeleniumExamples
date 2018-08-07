package com.qa.test.Guru99Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class BingTest {

	WebDriver driver = null;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void testBingSearch() {
		driver.get("http://www.bing.com/");

		BingLandingPage page = PageFactory.initElements(driver, BingLandingPage.class);

		page.searchFor("Selenium");

		WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));

		assertEquals("Selenium", checkElement.getText());

	}

	@After
	public void tearDown() throws InterruptedException {

		Thread.sleep(3000);
		driver.close();

	}

}
