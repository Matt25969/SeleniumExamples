package com.qa.test.Guru99Test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class findByElements {
	
	String url;
	WebDriver driver;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		url = "https://www.phptravels.net/";

	}

	@After
	public void teardown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void elementsTest() {
		
		driver.get(url);
		
		List<WebElement> listOfWebElements = driver.findElements(By.xpath("//*[@id=\"li_myaccount\"]/a"));
		
		for (WebElement element : listOfWebElements) {
			
			System.out.println("The text for the element is " + element.getText() + ".");
			
		}
		
	}
	
}
