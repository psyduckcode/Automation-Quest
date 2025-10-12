//Selenium TestNG Program: Data Driven Testing using DataProvider

package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNg_DataProvider 
{
	WebDriver driver;
	
	@BeforeClass()
	public void setUp()
	{
		 // Setup Chrome Browser and navigate to login page
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://the-internet.herokuapp.com/login");
			
	}
	
	@Test(dataProvider = "dp")
	public void loginTest(String user, String pass)
	{
		// Clear any existing text in input fields
		driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("password")).clear();
        
        // Enter username and password from DataProvider
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pass);
		
		// Click on the Login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// Capture the message after login attempt
		String msg=driver.findElement(By.xpath("//div[@id='flash']")).getText();
		System.out.println(msg);
		
		Assert.assertTrue(msg.contains("secure"),"Login Failed");
		System.out.println("Login Successfull");
	}
	
	@AfterClass
	public void tearDown()
	{
		 // Close the browser
		driver.quit();
	}
	
	@DataProvider(name = "dp")
	public Object[][] loginData()
	{
		// Provide multiple sets of username/password combinations
			Object[][] data =  { 
					
								{"akash","SuperSecretPassword!"},
								{"tomsmith","SuperSecrect"},
								{"tomsmith","SuperSecretPassword!"}
						
							   };		
			return data;
	}
			
}

		




