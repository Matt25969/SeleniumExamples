package com.qa.seleniumexamples.MercuryTours.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {

	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")
	private WebElement firstNameField;

	public void fillOutForm(Actions action) {

		firstNameField.sendKeys("Matt");
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("Hunt");
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("01384298365");
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("matthew.hunt@qa.com");
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("15 Baltic Street");
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("Manchester");
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("Not in America yo");
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("M1 M1");
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("UNITED KINGDOM").sendKeys(Keys.ENTER).perform();
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("MattHunt");
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("HuntHunt");
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("HuntHunt").perform();
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.ENTER).perform();

	}

}
