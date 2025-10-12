//Selenium Program for TestNG Annotations Demonstration

package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNg_Annotations {

	public WebDriver driver;

	// Runs once before the entire test suite starts
	@BeforeSuite
	public void setupSuite() {
		System.out.println(" Before Suite: Setting up environment");
	}

	// Runs before any test defined in the <test> tag of the TestNG XML file
	@BeforeTest
	public void setupTest() {
		System.out.println(" Before Test: Preparing test-specific resources");
	}

	// Runs once before any @Test method in this class
	@BeforeClass
	public void setupClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println(" Chrome Browser Launched");
	}

	// Runs before each @Test method
	@BeforeMethod
	public void setupMethod() {
		System.out.println("Before Method: Navigating to login page");
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}

	// Test Case 1: Validate invalid login attempt
	@Test(priority = 1)
	public void testInvalidLogin() {
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("123Pass");
		driver.findElement(By.id("submit")).click();

		String errorMsg = driver.findElement(By.id("error")).getText();
		Assert.assertTrue(errorMsg.contains("Your password is invalid!"));
		System.out.println("Invalid Login Test Passed (Error validated)");
	}

	// Test Case 2: Validate successful login
	@Test(priority = 2)
	public void testValidLogin() {
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();

		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Logged In Successfully | Practice Test Automation");
		System.out.println("Valid Login Test Passed");
	}

	// Runs after each @Test method
	@AfterMethod
	public void tearDownMethod() {
		System.out.println("After Method: Resetting test state");
		try {
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("password")).clear();
		} catch (Exception e) {
			System.out.println("No fields to clear or already navigated away.");
		}
	}

	// Runs once after all @Test methods in this class
	@AfterClass
	public void tearDownClass() {
		driver.quit();
		System.out.println("Browser Closed");
	}

	// Runs once after all tests under <test> tag are complete
	@AfterTest
	public void tearDownTest() {
		System.out.println("After Test: Cleaning up test resources");
	}

	// Runs once after the entire test suite has finished
	@AfterSuite
	public void tearDownSuite() {
		System.out.println("After Suite: Environment cleanup completed");
	}
}
