//Selenium Java Program: Fluent Wait Example

package waits;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Fluent_Wait {

	public static void main(String[] args) 
	{
		
		// Launch Chrome browser
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Fluent Wait: timeout 20s, polling every 2s, ignoring NoSuchElementException
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // Wait for username input field
        WebElement username = wait.until(drv -> drv.findElement(By.id("username")));
        username.sendKeys("student");

        // Wait for password input field
        WebElement password = wait.until(drv -> drv.findElement(By.id("password")));
        password.sendKeys("Password123");

        // Wait for submit button
        WebElement submitBtn = wait.until(drv -> drv.findElement(By.id("submit")));
        submitBtn.click();

        System.out.println("Login attempted using Fluent Wait");
        System.out.println("Page Title: " + driver.getTitle());

        //Close the Browser
        driver.quit();
	}

}
