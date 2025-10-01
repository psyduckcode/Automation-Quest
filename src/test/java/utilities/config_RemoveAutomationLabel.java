//Remove "Chrome is being controlled by automated test software" Label in Selenium


package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class config_RemoveAutomationLabel {

    public static void main(String[] args) 
    {
        // Create ChromeOptions object to configure browser settings
        ChromeOptions op = new ChromeOptions();

        // Remove "Chrome is being controlled by automated test software" info bar
        op.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

        // Launch Chrome browser with the configured options
        WebDriver driver = new ChromeDriver(op);

        // Maximize the browser window for better visibility
        driver.manage().window().maximize();

        // Navigate to the login page
        driver.get("https://the-internet.herokuapp.com/login");

        // Enter Username
        driver.findElement(By.name("username")).sendKeys("tomsmith");

        // Enter Password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        // Click on Login Button to submit the form
        driver.findElement(By.cssSelector(".radius")).click();

        // Print confirmation to console for verification
        System.out.println("Login Successful");
        System.out.println("Page Title: " + driver.getTitle());

        // Close the browser to end the session
        driver.quit();
    }
}
