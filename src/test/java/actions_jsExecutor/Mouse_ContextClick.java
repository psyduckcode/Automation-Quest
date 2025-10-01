// Context Click (Right-Click) Action Example in Selenium

package actions_jsExecutor;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse_ContextClick {

	public static void main(String[] args) throws InterruptedException {

		// Launch Chrome browser
		WebDriver driver = new ChromeDriver();
		
		// Maximize browser window
		driver.manage().window().maximize();


		// Set implicit wait (wait up to 5 seconds for elements to appear)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Open practice page for context menu
		driver.get("https://practice.expandtesting.com/context-menu");

		
		// Locate the element where right-click (context click) to be performed
		WebElement context = driver.findElement(By.xpath("//div[@id='hot-spot']"));

		// Create Actions class object 
		Actions act = new Actions(driver);

		// Perform right-click (context click) on Element
		act.contextClick(context).perform();
		
		Thread.sleep(5000);

		// Switch to the alert popup and accept it
		driver.switchTo().alert().accept();
		
	
		// Close the browser
		driver.quit();
	}
}
