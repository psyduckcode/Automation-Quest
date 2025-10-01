//Pratice KeyBoard Action Pressing Multiple Keys

package actions_jsExecutor;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardAction_MultipleKeysPress {

	public static void main(String[] args) {

	
		WebDriver driver = new ChromeDriver();

		// Implicit wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Open the test website
		driver.get("https://play2.automationcamp.ir/");

		// Maximize the window
		driver.manage().window().maximize();

		// Create Actions object 
		Actions act = new Actions(driver);

		// Locate Element
		WebElement username_field = driver.findElement(By.xpath("//input[@id='uname']"));

		// Click on the username field to focus
		act.moveToElement(username_field).click().perform();

		// Type username
		act.sendKeys(username_field, "test").perform();

		// Copy username using Ctrl + A (select all) + Ctrl + C
		act.keyDown(Keys.CONTROL).sendKeys("A").sendKeys("C").keyUp(Keys.CONTROL).perform();

		// Press TAB to move to password field and paste the copied text (Ctrl + V)
		act.sendKeys(Keys.TAB).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

		// Press TAB to move to Login button and press ENTER to submit
		act.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

		// Print page title to confirm login success
		System.out.println(driver.getTitle());

		// close the browser
		 driver.quit();
	}
}
