package com.qa.test.Guru99Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingLandingPage {
	
WebDriver driver;
	
	

	@FindBy(name = "q")
	private WebElement searchBox;

	public void searchFor(WebDriver driver, String text) {
		this.driver = driver;
		searchBox.sendKeys(text);
		searchBox.submit();
	}

}
