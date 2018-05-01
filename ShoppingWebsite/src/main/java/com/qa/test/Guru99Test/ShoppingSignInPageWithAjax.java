package com.qa.test.Guru99Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ShoppingSignInPageWithAjax {
	public ShoppingSignInPageWithAjax(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	@FindBy(xpath = "//*[@id=\"email_create\"]")
	private WebElement emailField;

	@FindBy(xpath = "//*[@id=\"SubmitCreate\"]")
	private WebElement subButton;

	@FindBy(xpath = "//*[@id=\"id_gender1\"]")
	private WebElement genderRadio;

	// *[@id=\"id_gender1\"]

	public void filloutForm() {

		emailField.sendKeys("hu@gmail.com");

		subButton.click();
		genderRadio.click();
	}

}
