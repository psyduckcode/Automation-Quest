//This is the main TestNG test class on which we are using ITestListener

package testNG;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNg_ListenerMain 
{
	
WebDriver driver;
	
	@BeforeClass
	void setup() throws InterruptedException 
	{
		//Setup Browser and Open Website
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().fullscreen();
	}
	
	@Test
	void GetImage()
	{	
		//Check Image
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> check = mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.xpath("//img[@alt='company-branding']"))));
		Boolean status = check.getFirst().isDisplayed();
		Assert.assertTrue(status);
	}
	
	@Test
	void GetTitle()
	{			
		//Set Title and Make Test Fail Intentionally
		System.out.println(driver.getTitle());
		Assert.fail();
	}
	
	
	@Test(dependsOnMethods = {"GetTitle"})
	void MakeMethodSkip()
	{
		//Getting Current URL of Page and Making Test Skip
		driver.getCurrentUrl();	
	}
	
	@AfterClass
	void EndApp()
	{
		//Close the Browser
		driver.quit();
	}
	
}
