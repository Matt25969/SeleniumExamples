package com.qa.test.Guru99Test;

import org.junit.After;
import org.junit.Before;
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
	Actions action = null;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		action = new Actions(driver);

	}

	@Test
	public void layoutTest() throws InterruptedException {
		driver.get("https://qa-trials641.orangehrmlive.com/auth/login");
		driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("AdminAdmin");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/a/span[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewEmployeeList\"]/span[2]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]/span[2]")).click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//*[@id=\"pimAddEmployeeForm\"]/div[2]/a[2]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]/span[2]")).click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("This");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"middleName\"]")).sendKeys("This");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("This");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"location_inputfileddiv\"]/div/input")).click();
		Thread.sleep(3000);

		action.sendKeys(Keys.DOWN).perform();

		action.sendKeys(Keys.DOWN).perform();

		action.sendKeys(Keys.DOWN).perform();

		action.sendKeys(Keys.ENTER).perform();

		driver.findElement(By.xpath("//*[@id=\"systemUserSaveBtn\"]")).click();
		Thread.sleep(30000);

		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewEmployeeList\"]/span[2]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"employee_name_quick_filter_employee_list_value\"]")).sendKeys("this");
		Thread.sleep(3000);

		action.sendKeys(Keys.ENTER).perform();

		action.sendKeys(Keys.ENTER).perform();

		driver.findElement(By.xpath("//*[@id=\"employeeListTable\"]/tbody/tr/td[3]")).click();
		Thread.sleep(30000);

	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
