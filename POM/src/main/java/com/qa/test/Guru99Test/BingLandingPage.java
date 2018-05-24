package com.qa.test.Guru99Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingLandingPage {

	@FindBy(name = "q")
	private WebElement searchBox;

	@FindBy(xpath = "//*[@id=\"sb_form_go\"]")
	private WebElement gotButton;

	public void searchFor(String text) {

		searchBox.sendKeys(text);
		searchBox.submit();
		gotButton.click();

	}

}
