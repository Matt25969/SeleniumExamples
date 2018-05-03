package com.qa.test.Guru99Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SimpleActions {

	WebDriver driver = null;

	Actions action = null;

	@Before

	public void setUp() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");

		driver = new ChromeDriver();

		action = new Actions(driver);

		driver.get("http://demoqa.com/");

		driver.manage().window().maximize();

	}

	@Test

	public void dragAndDropTest() throws InterruptedException {

		driver.get("http://demoqa.com/draggable/");

		WebElement dragMeAround = driver.findElement(By.cssSelector("#draggable > p"));

		Thread.sleep(1500);

		action.dragAndDropBy(dragMeAround, 100, 100).perform();

		Thread.sleep(1500);
	}

	@After
	public void tearDown() {

		driver.quit();

	}
}
