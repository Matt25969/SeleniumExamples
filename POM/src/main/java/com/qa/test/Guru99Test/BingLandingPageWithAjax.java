package com.qa.test.Guru99Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BingLandingPageWithAjax {
	public BingLandingPageWithAjax(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	@FindBy(name = "q")
	private WebElement searchBox;

	public void searchFor(String text) {

		searchBox.sendKeys(text);
		searchBox.submit();
	}

}
