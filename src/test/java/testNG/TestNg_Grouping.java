// Selenium TestNG Program: Groups Exampl


package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNg_Grouping 
{
	WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ecommerce-playground.lambdatest.io/");
		System.out.println("Browser Launched and Site Opened");
	}

	
	// ------------------- SMOKE TESTS -------------------
	@Test(groups = { "Smoke" })
	public void verifyHomePageTitle() {
		String title = driver.getTitle();
		
		//Verify Title of Home Page
		Assert.assertTrue(title.contains("Your Store"), "Home page title mismatch!");
		System.out.println("Smoke Test: Home Page Title Verified");
	}

	@Test(groups = { "Smoke" })
	public void verifyLoginPageAccessible() {
		driver.findElement(By.linkText("My account")).click();
		driver.findElement(By.linkText("Login")).click();
		
		//Verify if "My Account" present in Current URL
		Assert.assertTrue(driver.getCurrentUrl().contains("account/login"), "Login page not accessible!");
		System.out.println("Smoke Test: Login Page Accessible");
		driver.navigate().back();
	}

	// ------------------- REGRESSION TESTS -------------------
	@Test(groups = { "Regression" })
	public void searchProduct() {
		WebElement searchBox = driver.findElement(By.name("search"));
		searchBox.clear();
		searchBox.sendKeys("iPhone");
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
		
		//Verify if "Search" present in Current URL
		Assert.assertTrue(driver.getTitle().contains("Search"), "Search page not displayed!");
		System.out.println("Regression Test: Search Functionality Working");
		driver.navigate().back();
	}

	@Test(groups = { "Regression" })
	public void addToCartTest() throws InterruptedException 
	{
		
		Actions act = new Actions(driver);
		WebElement megaMenu = driver.findElement(By.xpath("//span[normalize-space()='Mega Menu']"));
		WebElement menu = driver.findElement(By.xpath("//a[@title='Desktop']"));

		act.moveToElement(megaMenu).moveToElement(menu).click().perform();

		WebElement item = driver.findElement(By.xpath("//div[@class='carousel-item active']//img[@title='MacBook']"));
		act.moveToElement(item).click().perform();

		//Verify if "Label" is Displayed
		Boolean label = driver.findElement(By.xpath("//h1[normalize-space()='MacBook']")).isDisplayed();

		System.out.println(label);
		Assert.assertTrue(label, "Element Not Visible");
		System.out.println("Regression Test: Product Added to Cart Successfully");
	}

	
	// ------------------- SANITY TEST -------------------
	@Test(groups = { "Sanity" })
	public void verifyLogoVisible() 
	{
		WebElement logo = driver.findElement(By.cssSelector("img[alt='Poco Electro']"));
		
		//Verify if "Logo" is Displayed
		Assert.assertTrue(logo.isDisplayed(), "Logo not visible!");
		System.out.println("Sanity Test: Logo Displayed");
	}

	
	@AfterClass(alwaysRun=true)
	public void tearDown() 
	{
		//Close the Browser
		driver.quit();
		System.out.println("Browser Closed");
	}
}
