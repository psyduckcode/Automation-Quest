// Mouse Hover Action Example in Selenium

package actions_jsExecutor;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse_HoverAction {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		// Maximize browser window
		driver.manage().window().maximize();

		// Set implicit wait (wait up to 5 seconds for elements to appear)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Open practice page
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#top");

		// Locate the element that shows options when hovered
		WebElement MouseHover = driver.findElement(By.id("mousehover"));

		// Locate the "Top" link that appears after hover
		WebElement Go_Top = driver.findElement(By.xpath("//div//a[text()='Top']"));

		// Create Actions class object to perform mouse actions
		Actions act = new Actions(driver);

		// Move to "Mouse Hover" element then move to "Top" then click
		act.moveToElement(MouseHover).moveToElement(Go_Top).click().build().perform();
		

		// Close the Browser
		driver.quit();

	}

}
