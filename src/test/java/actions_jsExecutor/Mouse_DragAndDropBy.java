 //Drag and Drop Action Example in Selenium


package actions_jsExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class Mouse_DragAndDropBy {

    public static void main(String[] args) {
        
        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        driver.get("https://www.globalsqa.com/demoSite/practice/slider/colorpicker.html");
         
        //ColorBox Web Element
        WebElement color_Box = driver.findElement(By.xpath("//div[@id='swatch']"));
        
        //Get Color Before Slide
        String get_Col = color_Box.getCssValue("background-color");
        
        //Convert RGB color value to HEX format
        String before_Col = Color.fromString(get_Col).asHex();
        
        System.out.println("Original Color in Box:"+ before_Col);
        
     
        // Locate slider handle
        WebElement leftside = driver.findElement(By.xpath(
        "//div[@id='red']//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
        
    
        //  Initial Location of the Slider Handle
        System.out.println("Initial Slider Location: " + leftside.getLocation());
        
        // Create Actions object
        Actions act = new Actions(driver);
        
        // Move the slider handle
        act.dragAndDropBy(leftside, -200, 71).perform();
        
        //Get Color After Slide
        String fn_Col = color_Box.getCssValue("background-color");
        
        //Convert RGB color value to HEX format
        String after_Col = Color.fromString(fn_Col).asHex();
        
        System.out.println("Color in Box After Slide:"+ after_Col);
        
   
        //Close browser 
         driver.quit();
    }
}
