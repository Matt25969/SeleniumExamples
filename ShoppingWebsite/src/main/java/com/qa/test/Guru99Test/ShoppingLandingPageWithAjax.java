package com.qa.test.Guru99Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingLandingPageWithAjax {
	public ShoppingLandingPageWithAjax(WebDriver driver) {
		// PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	private WebElement signInButton;

	public void clickSignIn() {

		signInButton.click();
	}

}
