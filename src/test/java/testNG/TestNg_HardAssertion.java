//Selenium Program for TestNG Hard Assertion Demonstration

package testNG;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNg_HardAssertion
{
	WebDriver driver;

	@BeforeClass
	public void setUp() 
	{
		// Setup Envoirment
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/login");
	}

	@Test
	void loginTest() 
	{
		// Locate Username, Password feild, and Login Button
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

		System.out.println("Home Page Title:" + driver.getTitle());

		// Enter Credentials
		username.sendKeys("pratice");
		password.sendKeys("SuperSecretPasswor!");

		// Click the login button using JavaScript Executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", button);

		// Capture Success and Failure Message
		List<WebElement> successMsg = driver.findElements(By.xpath("//b[normalize-space()='You logged into a secure area!']"));
		List<WebElement> failMsg = driver.findElements(By.xpath("//b[normalize-space()='Your password is invalid!']"));

		// Validate Login result using Hard Assertions
		if (!successMsg.isEmpty() && successMsg.get(0).isDisplayed()) 
		{
			System.out.println("Login Success");

			// Assert that page title matches expected secure page title
			Assert.assertEquals(driver.getTitle(), "Secure Page page for Automation Testing Practice",
					"Page title mismatch! Login may have failed.");
		} 
		else if (!failMsg.isEmpty() && failMsg.get(0).isDisplayed()) 
		{
			System.out.println("Login Failed! Check username and password.");

			// Fail the test explicitly
			Assert.fail("Login Failed!");
		} 
		else 
		{
			System.out.println("Neither success nor failure message found!");
			Assert.fail("Login result unknown! No success or failure message displayed.");
		}

	}

	@AfterClass
	public void tearDown() 
	{
		// Close the Browser
		driver.quit();
	}

}
