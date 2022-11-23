package objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookPage {
	WebDriver driver;

	public FacebookPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By username_editbox = By.id("email");
	By password_editbox = By.id("pass");
	By login_btn = By.name("login");
	
	
	public void EnterUsername() {
		try {
			driver.findElement(username_editbox).clear();
			driver.findElement(username_editbox).sendKeys("Testuser");
			Thread.sleep(3000);
		}catch(Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
	}
	
	public void EnterPassword() {
		try {
			driver.findElement(password_editbox).clear();
			driver.findElement(password_editbox).sendKeys("Tester123");
			Thread.sleep(3000);
		}catch(Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
	}
	
	public void VerifyLogin() {
		try {
			Thread.sleep(3000);
			driver.findElement(login_btn).click();
			String title = driver.getTitle();
			assertEquals(title, "Facebook – log in or sign up");
		}catch(Exception e) {
			System.out.println("Exception occured"+e.getMessage());
			
		}
	}
	
}
