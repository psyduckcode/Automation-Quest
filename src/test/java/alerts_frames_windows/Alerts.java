//Managing Different Type Of Alerts

package alerts_frames_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		// Open WebSite
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		

		// Simple Alert
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		driver.switchTo().alert().accept();
		
		
		Thread.sleep(5000);
		

		//Conformation Altert   {Ok and Cancel Option}
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		driver.switchTo().alert().dismiss();
		
		
		Thread.sleep(5000);
		
		
		//Prompt Alert
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		Alert myalert = driver.switchTo().alert();
		myalert.sendKeys("Akash");
		myalert.accept();
		
	
		//Close the Browser
		driver.quit();
		
	}

}
