// Drag and Drop Action Example in Selenium


package actions_jsExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Mouse_DragAndDrop {

	public static void main(String[] args) {
	
        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Open demo site and maximize window
        driver.get("https://testautomationpractice.blogspot.com/#");
        driver.manage().window().maximize();

        // Locate draggable and droppable elements
        WebElement target = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement destination = driver.findElement(By.xpath("//div[@id='droppable']"));

        // Get initial location of draggable element
        Point before = target.getLocation();
        System.out.println("Before Drag: " + before);

        // Create Actions object
        Actions act = new Actions(driver);

        // Perform drag-and-drop
        Action myact = act.dragAndDrop(target, destination).build();
        myact.perform();
        System.out.println("Successfully Dragged");

        // Get location after drag
        Point after = target.getLocation();
        System.out.println("After Drag: " + after);

        // Calculate offset to move element back
        int finalX = before.getX() - after.getX();
        int finalY = before.getY() - after.getY();

        // Move element back to original position
        act.dragAndDropBy(target, finalX, finalY).perform();
        System.out.println("Element moved back to original position");

        // Close browser
        driver.quit();


	}

}
