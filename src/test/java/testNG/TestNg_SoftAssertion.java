//Selenium Program for TestNG Soft Assertion Demonstration

package testNG;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNg_SoftAssertion {

	WebDriver driver;

	@BeforeClass
	public void setUp() 
	{
		// Setup Envoirment
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
	}

	@Test
	void loginTest()
	{
		// Locate Username, Password feild, and Login Button
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));

		SoftAssert sa = new SoftAssert();

		// Find Username,Password Feild and Login Button
		sa.assertTrue(username.isDisplayed(), "Username not Visible");
		sa.assertTrue(password.isDisplayed(), "Passoword not Visible");
		sa.assertTrue(button.isDisplayed(), "Button not Visible");

		// Print Home Title
		System.out.println("Home Page Title:" + driver.getTitle());

		// Check Button Clickable or Not
		sa.assertTrue(button.isEnabled(), "Login Button Not Clickable");

		// Enter credentials
		username.sendKeys("tomsmith"); // correct username
		password.sendKeys("SuperSecretPassword"); // correct password
		button.click();

		List<WebElement> successMsg = driver.findElements(By.xpath("//div[contains(@class,'success')]"));

		// Using Soft Assertion to Check for Success Message
		if (!successMsg.isEmpty() && successMsg.get(0).isDisplayed()) 
		{
			sa.assertTrue(successMsg.get(0).getText().contains("You logged into a secure area!"),
					"Success Message Mismatch");
			System.out.println("Login Success");
		} 
		else 
		{
			// Fail Test Explicitly
			sa.fail("Login Failed");
			System.out.println("Login Failed Check Credentials");
		}

		// Evaluate all Soft Assertions
		sa.assertAll();
	}

	@AfterClass
	public void tearDown() 
	{
		// Close the Browser
		driver.quit();
	}

}
