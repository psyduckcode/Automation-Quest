//Implicit Wait

package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Implicit_Wait {

	public static void main(String[] args) {
		Boolean check;
		WebDriver driver = new ChromeDriver();

		// Implicit wait of 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.hyrtutorials.com/p/waits-demo.html?m=1");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[@id='btn1']")).click();

		// Wait 5 Seconds for Element to Load
		check = driver.findElement(By.xpath("//h3//input[@id='txt1']")).isDisplayed();
		System.out.println(check);

		// Close the Browser
		driver.quit();
	}

}
