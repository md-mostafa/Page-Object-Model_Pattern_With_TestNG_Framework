package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

	WebDriver driver;

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	By searchBox = By.xpath("//input[@name=\'q\']");
	By searchBtn = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[1]");
	By facebookLink = By.xpath("(//a[contains(@href,'https://www.facebook.com')])[1]");

	public void searchGoogle(String searchInput) {

		try {
			driver.findElement(searchBox).sendKeys(searchInput);
			Thread.sleep(3000);
			driver.findElement(searchBtn).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Exception caught " + e.getMessage());
		}

	}

	public void clickFacebook() {
		try {
			driver.findElement(facebookLink).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Exception caught " + e.getMessage());
		}
	}
}
