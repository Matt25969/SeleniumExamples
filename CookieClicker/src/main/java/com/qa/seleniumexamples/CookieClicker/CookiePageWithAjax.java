package com.qa.seleniumexamples.CookieClicker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	@FindBy(xpath = "//*[@id=\"shimmers\"]")
	private WebElement shimmer;

	public void method(WebDriver driver) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		List<WebElement> productsList = driver.findElements(By.cssSelector(".product"));

		Actions action = new Actions(driver);

		for (int i = 0; i < 20; i++) {

			cookie.click();

		}

		driver.findElement(By.xpath("//*[@id=\"product0\"]")).click();

		while (true) {

			if (shimmer.isDisplayed() == true) {

				action.moveToElement(shimmer).click().perform();

			}

			cookie.click();

			for (WebElement product : productsList) {

				if (product.getAttribute("class").equals("product unlocked enabled")) {

					if (firstUpgradeButton.isDisplayed()
							&& firstUpgradeButton.getAttribute("class").equals("crate upgrade enabled")) {
						firstUpgradeButton.click();

					}

					product.click();
				}

			}

		}

	}

}
