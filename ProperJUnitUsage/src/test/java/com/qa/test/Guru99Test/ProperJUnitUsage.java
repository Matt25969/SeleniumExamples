package com.qa.test.Guru99Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ProperJUnitUsage {

	WebElement element;
	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	@Ignore
	public void basicDriverTest() throws InterruptedException {

		driver.get("https://www.google.com/");
		Thread.sleep(3000);

	}

	@Test
	public void basicElementTest() throws InterruptedException {

		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys("QA Consulting");
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
		
		ele.click();

	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
