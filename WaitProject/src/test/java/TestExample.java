import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Page.HomePage;

public class TestExample {
	
	WebElement element;
	WebDriver driver;
	Actions action;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		action = new Actions(driver);

	}

	@Test
	@Ignore
	public void basicElementTest() throws InterruptedException {

		driver.get("http://automationpractice.com/index.php");
		WebElement check = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"));
		action.moveToElement(check).perform();
		WebElement toClick = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a"));
		toClick.click();

	}
	
	@Test
	@Ignore
	public void basicElementTestWithWait()   {

		driver.get("http://automationpractice.com/index.php");
		WebElement check = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"));
		action.moveToElement(check).perform();
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a")));
		myDynamicElement.click();
		

	}

	@Test
	public void waitWithPOM() {
		
		driver.get("http://automationpractice.com/index.php");

		HomePage page = PageFactory.initElements(driver, HomePage.class);
		
		page.clickButton(action, driver);
		
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
