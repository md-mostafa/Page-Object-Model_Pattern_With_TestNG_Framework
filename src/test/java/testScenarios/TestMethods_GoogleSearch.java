package testScenarios;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.FacebookPage;
import objects.GoogleSearchPage;

public class TestMethods_GoogleSearch {
	WebDriver driver  = null;
	GoogleSearchPage objectrepo = null;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

	}

	@Test(priority = 0)
	public void SearchOperation() {
		GoogleSearchPage page = new GoogleSearchPage(driver);
		page.searchGoogle("facebook");

	}

	@Test(priority = 1)
	public void VerifyAndAccessFacebook() {
		objectrepo = new GoogleSearchPage(driver);
		objectrepo.clickFacebook();
		
	}	
	
	@Test(priority = 2)
	public void VerifyLogin() {
		FacebookPage page =  new FacebookPage(driver);
		page.EnterUsername();
		page.EnterPassword();
		page.VerifyLogin();
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
