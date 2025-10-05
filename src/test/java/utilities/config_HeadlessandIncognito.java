//Program to Pratice Headless and Incognito

package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Config_HeadlessandIncognito {

	public static void main(String[] args) 
	{
		//Create ChromeOptions object to configure browser settings
		ChromeOptions op = new ChromeOptions();
		
		//Enable headless mode (runs Chrome in background without GUI)
		op.addArguments("--headless=new");
		
		
		//Enable incognito mode for private browsing
		
		/*	 op.addArguments("incognito");   */
		
		
		
		//Launch Browser
		WebDriver driver = new ChromeDriver(op);

		//Open WebSite
		driver.get("https://the-internet.herokuapp.com/login");
		
		//Enter UserName and Password
		driver.findElement(By.name("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		
		//Click on Login Button
		driver.findElement(By.cssSelector(".radius")).click();
		
		//Print Success Message and Title
		System.out.println("Login Sucess " + "\n" + "Title:" + driver.getTitle());
		
		//Close Browser	
		driver.quit();
	}

}
