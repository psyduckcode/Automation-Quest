//Handel Alert Using Implicit Wait

package alerts_frames_windows;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alert_ExplicitWait {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Implicit Wait
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(3));

		//Open URL
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		

		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		try
		{

			Alert alert = mywait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
			String getText = driver.findElement(By.xpath("//p[@id='result']")).getText();
			System.out.println(getText);

		} catch (TimeoutException timeout)
		{
			System.out.println("No Alert Appear");
		}

		//Close Browser
		driver.quit();
	}

}
