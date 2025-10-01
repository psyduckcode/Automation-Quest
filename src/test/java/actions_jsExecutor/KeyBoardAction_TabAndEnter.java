//Pratice KeyBoard Action Tab and Enter


package actions_jsExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardAction_TabAndEnter {

	public static void main(String[] args) 
	{
		
		// Launch Chrome browser
		WebDriver driver = new ChromeDriver();
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		// Open the login page
		driver.get("https://the-internet.herokuapp.com/login");
		
		 // Locate the username input field
		WebElement username=driver.findElement(By.name("username"));
		
		// Create Actions class object to perform keyboard actions
		Actions act = new Actions(driver);
		
		//Type Username press TAB then type Password then press TAB and press Enter key
		act.sendKeys(username, "tomsmith")
		.sendKeys(Keys.TAB)
		.sendKeys("SuperSecretPassword!")
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.ENTER).perform();
		
		
		 // Close the browser after execution
        driver.quit();
	
		
		
		
		

	}

}
