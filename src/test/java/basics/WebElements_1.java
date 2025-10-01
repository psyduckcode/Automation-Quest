//Interacting with Basic Web Elements

package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements_1 {

	public static void main(String[] args) throws InterruptedException {

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the test page
		driver.get("https://testautomationpractice.blogspot.com/");

		// 1️ TextBox - Enter text
		WebElement nameField = driver.findElement(By.xpath("//input[@id='name']"));
		nameField.sendKeys("Sunny");
		Thread.sleep(2000); // Wait for 2 seconds

		// 2️ Radio Button - Select option
		WebElement maleRadio = driver.findElement(By.xpath("//input[@id='male']"));
		maleRadio.click();
		Thread.sleep(2000); // Wait for 2 seconds

		// 3 Checkbox - Select option
		WebElement mondayCheckbox = driver.findElement(By.xpath("//input[@id='monday']"));
		if (!mondayCheckbox.isSelected()) 
		{
			mondayCheckbox.click();
		}
		Thread.sleep(2000); // Wait for 2 seconds

		// 4️ Button - Click button
		WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='START']"));
		submitButton.click();
		Thread.sleep(2000); // Wait for 2 seconds

		// 5️ Link - Click link
		WebElement homeLink = driver.findElement(By.xpath("//a[normalize-space()='Udemy Courses']"));
		homeLink.click();
		Thread.sleep(2000); // Wait for 2 seconds

		// Close the browser
		driver.quit();

	}

}
