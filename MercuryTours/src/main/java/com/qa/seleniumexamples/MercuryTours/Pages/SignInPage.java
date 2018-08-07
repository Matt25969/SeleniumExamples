package com.qa.seleniumexamples.MercuryTours.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td[2]/input")
	private WebElement userNameField;

	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")
	private WebElement passwordField;

	public void enterDetails(Actions action) {

		userNameField.sendKeys("MattHunt");
		passwordField.sendKeys("HuntHunt");
		action.sendKeys(Keys.TAB).perform();

		action.sendKeys(Keys.ENTER).perform();

	}

}
