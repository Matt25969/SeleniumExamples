package com.qa.test.Guru99Test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class ShoppingTest {

	String url;
	WebDriver driver;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		url = "http://automationpractice.com/index.php";

	}

	@After
	public void teardown() throws InterruptedException {

		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void elementsTest() throws InterruptedException {

		driver.get(url);

		ShoppingLandingPageWithAjax page = PageFactory.initElements(driver, ShoppingLandingPageWithAjax.class);

		page.clickSignIn();

		ShoppingSignInPageWithAjax signInPage = PageFactory.initElements(driver, ShoppingSignInPageWithAjax.class);

		signInPage.filloutForm();
	}

}
