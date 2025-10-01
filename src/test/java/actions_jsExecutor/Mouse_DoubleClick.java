// Double Click Action Example in Selenium


package actions_jsExecutor;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse_DoubleClick {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Open demo site
		driver.get("https://testautomationpractice.blogspot.com/#");
		driver.manage().window().maximize();

		// Enter text into first input field
		WebElement textfeild = driver.findElement(By.xpath("//input[@id='field1']"));
		textfeild.clear();
		textfeild.sendKeys("Sunny");
		

		// Locate 'Copy Text' button
		WebElement button = driver.findElement(By.xpath("//button[text()='Copy Text']"));

		// Perform double-click on the button
		Actions act = new Actions(driver);
		act.doubleClick(button).perform();

		// Verify if text is copied into second field
		WebElement textfeild2 = driver.findElement(By.xpath("//input[@id='field2']"));
		String valuefeild2 = textfeild2.getAttribute("value");

		System.out.println(valuefeild2);

		if(valuefeild2.contentEquals("Sunny")) {
		    System.out.println("Successfully Copied");
		} else {
		    System.out.println("Copy Failed");
		}
	

		//Close the Browser
		driver.quit();
		
	}

}
