package com.qa.seleniumexamples.CookieClicker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CookiePageWithAjax {
	public CookiePageWithAjax(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	@FindBy(id = "bigCookie")
	private WebElement cookie;

	@FindBy(xpath = "//*[@id=\"cookies\"]")
	private WebElement numberOfCookies;

	@FindBy(xpath = "//*[@id=\"upgrade0\"]")
	private WebElement firstUpgradeButton;

	@FindBy(xpath = "//*[@id=\"product0\"]")
	private WebElement firstButton;

	@FindBy(xpath = "//*[@id=\"product1\"]")
	private WebElement secondButton;

	@FindBy(xpath = "//*[@id=\"product2\"]")
	private WebElement thirdButton;

	@FindBy(xpath = "//*[@id=\"product3\"]")
	private WebElement fourthButton;

	@FindBy(xpath = "//*[@id=\"product4\"]")
	private WebElement fifthButton;

	@FindBy(xpath = "//*[@id=\"product5\"]")
	private WebElement sixthButton;

	@FindBy(xpath = "//*[@id=\"prefsButton\"]")
	private WebElement options;

	@FindBy(xpath = "//*[@id=\"formatButton\"]")
	private WebElement numberOptions;

	@FindBy(xpath = "//*[@id=\"shimmers\"]")
	private WebElement shimmer;

	public void method() throws InterruptedException {

		int check = 0;

		int cheapest = 0;

		while (true) {

			if (shimmer.isDisplayed() == true) {

				shimmer.click();
			}

			cookie.click();

			String s1 = numberOfCookies.getText();

			if (s1.lastIndexOf("cookies") >= 3) {

				String[] stringArray = s1.substring(0, s1.lastIndexOf("cookies") - 1).split(",");

				String sTest = "";

				for (String s : stringArray) {

					sTest = sTest + s;

				}

				check = Integer.parseInt(sTest);

			}

			if (check >= cheapest) {

				if (firstButton.isDisplayed() && firstButton.getAttribute("class").equals("product unlocked enabled")) {
					firstButton.click();
					cheapest = check;
					continue;
				}
				if (secondButton.isDisplayed()
						&& secondButton.getAttribute("class").equals("product unlocked enabled")) {
					secondButton.click();
					cheapest = check;
					continue;
				}
				if (thirdButton.isDisplayed() && thirdButton.getAttribute("class").equals("product unlocked enabled")) {
					thirdButton.click();
					cheapest = check;
					continue;
				}
				if (fourthButton.isDisplayed()
						&& fourthButton.getAttribute("class").equals("product unlocked enabled")) {
					fourthButton.click();
					cheapest = check;
					continue;
				}
				if (fifthButton.isDisplayed() && fifthButton.getAttribute("class").equals("product unlocked enabled")) {
					fifthButton.click();
					cheapest = check;
					continue;
				}
				if (sixthButton.isDisplayed() && sixthButton.getAttribute("class").equals("product unlocked enabled")) {
					sixthButton.click();
					cheapest = check;
					continue;
				}

				if (check >= 18 && firstUpgradeButton.isDisplayed()
						&& firstUpgradeButton.getAttribute("class").equals("crate upgrade enabled")) {
					firstUpgradeButton.click();

					cheapest = check;
					continue;

				}

			}

		}

	}

}
