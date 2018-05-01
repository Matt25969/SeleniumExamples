package com.qa.test.Guru99Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingLandingPage {

	@FindBy(name = "q")
	private WebElement searchBox;

	public void searchFor(String text) {

		searchBox.sendKeys(text);
		searchBox.submit();
	}

}
