// Selenium TestNG Program: Parallel Execution using Parameters in XML

package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNg_ParallelTestUsingXML 
{
	WebDriver driver;
	
	@BeforeMethod()
	@Parameters({"browser"})
	public void setupMethod(String br) 
	{
		// Selenium TestNG Program: Parallel Execution using Parameters in XML
		switch(br.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver();
		break;
		case "edge" : driver = new EdgeDriver();
		break;
		default: System.out.println("Invalid Browser");
		}
		
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/"); 
		System.out.println("Before Method: Navigating to login page");
	}
	
	
	@Test
	public void testValidLogin() 
	{
		// Enter valid username and password
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		
		// Click on the submit button
		driver.findElement(By.id("submit")).click();

		// Verify if the page title matches after successful login
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Logged In Successfully | Practice Test Automation");
		
		System.out.println("Valid Login Test Passed");
	}
	
	@AfterClass
	public void tearDown() 
	{
		
	// Close the browser 
	driver.quit();
	
	}

}
