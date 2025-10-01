//Pratice KeyBoard Action for Control and Click

package actions_jsExecutor;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardAction_ContolAndClick
{

    public static void main(String[] args) throws InterruptedException {
        
        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        
        // Set implicit wait 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Open Website
        driver.get("https://demo.nopcommerce.com/");
        
        // Maximize browser 
        driver.manage().window().maximize();
        
        // Locate the "Register" link
        WebElement registerLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        
        // Create Actions object 
        Actions actions = new Actions(driver);
        
        // Press CONTROL + Click to open the link in a new tab
        actions.keyDown(Keys.CONTROL).click(registerLink).keyUp(Keys.CONTROL).perform();
        
        // Store all window handles in an ArrayList for easy switching
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        
        // Switch to the new tab (Registration page)
        driver.switchTo().window(windowHandles.get(1));
        System.out.println("Registration Window ID: " + windowHandles.get(1));
        
        // Validate if the correct page is opened
        if(driver.getTitle().contains("Register")) 
        {
            System.out.println("Registration Page Title: " + driver.getTitle());
        } 
        else
        {
            System.out.println("Invalid Page Opened!");
        }
        
        // Wait to observe the page (optional)
        Thread.sleep(5000);
        
        
        // Switch back to the original tab (Home page)
        driver.switchTo().window(windowHandles.get(0));
        System.out.println("Home Page Window ID: " + windowHandles.get(0));
        System.out.println("Home Page Title: " + driver.getTitle());
        
        // Close all browser windows
        driver.quit();
    }
}
