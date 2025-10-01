//JavScriptExecutor to Send Keys and Open Link in New Tab to Read Title


package actions_jsExecutor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutor_SendKeysAndNewTab {

    public static void main(String[] args) throws InterruptedException
    {
        
        //Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        
        //Open the login page
        driver.get("https://practicetestautomation.com/practice-test-login/");
        
        //Locate the username, password fields and login button
        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement userPass = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement submitBtn = driver.findElement(By.xpath("//button[@id='submit']"));
        
        //Create JavascriptExecutor object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        //Enter username using JavaScript
        js.executeScript("arguments[0].setAttribute('value','student')", userName);
        
        //Enter password and click login button using JavaScript
        js.executeScript("arguments[0].setAttribute('value','Password123'); arguments[1].click();", userPass, submitBtn);
        
        //Print the page title to verify login
        System.out.println("Page Title after login: " + driver.getTitle());
        
        
        //Open WebSite in New Tab 
        js.executeScript("window.open('https://blazedemo.com/','_blank')");
        
        //Get Window Handels
        Set<String> handel = driver.getWindowHandles();
        
        //Convert Set to String
        List<String> tabs = new ArrayList<>(handel);
        
        //Switch to Second Tab
        driver.switchTo().window(tabs.get(1));
       
        //Get Title of Second Tab and Print
        String title = (String) js.executeScript("return document.title;");
        System.out.println(title);
     

        //Close the browser
        driver.quit();
    }
}
