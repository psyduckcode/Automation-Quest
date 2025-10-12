package reports;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main_Class 
{
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/");
	}
	
	@Test
	public void login()
	{
		
	driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
	driver.findElement(By.xpath("//input[@id='login-button']")).click();
	
   List <WebElement> label= driver.findElements(By.xpath("//div[@class='product_label']"));
	System.out.println(label);
	
	List<WebElement> errorLabel = driver.findElements(By.xpath("//h3[@data-test='error']"));

	if(!label.isEmpty() && label.get(0).getText().contains("Products"))
	{
		System.out.println("Success");
		
	}
	
	else if(!errorLabel.isEmpty())     
	{
		System.out.println("Error Login");	
	}
	
	

}
	
	
	
	
	
	
	
}

