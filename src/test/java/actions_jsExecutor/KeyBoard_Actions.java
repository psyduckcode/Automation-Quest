//Pratice KeyBoard Action

package actions_jsExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoard_Actions {

	public static void main(String[] args) {
	
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
        Actions act = new Actions(driver);
        
        act.click(registerLink).perform();
        
        
        WebElement gender=driver.findElement(By.xpath("//input[@id='gender-male']"));
        
        //Select Gender
        act.click(gender)
        .sendKeys(Keys.TAB)
        
        //Enter First Name
        .sendKeys("Akash").perform();
        String fname = driver.findElement(By.xpath("//input[@id='FirstName']")).getText();
        
        
        //Enter Last Name
        act.keyDown(Keys.TAB)
        .sendKeys("Verma")
        
        //Enter EmailID
        .keyDown(Keys.TAB)
        .sendKeys(fname.toLowerCase()+"@gmail.com").perform();
        
        
     

	}

}
