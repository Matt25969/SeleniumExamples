package com.qa.seleniumexamples.MercuryTours.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightPage {

	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")
	private WebElement signOffButton;

	public String checkButton() {

		return signOffButton.getText();
	}

}
