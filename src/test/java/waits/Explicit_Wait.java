package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicit_Wait {

	public static void main(String[] args) {
	
		Boolean check;
		WebDriver driver = new ChromeDriver();

		//Create Explicit Wait Object
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://www.hyrtutorials.com/p/waits-demo.html?m=1");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[@id='btn2']")).click();

		// Wait 10 Seconds for Element to Load

		WebElement text2 = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3//input[@id='txt2']")));
		check = text2.isDisplayed();
				
		System.out.println(check);

		// Close the Browser
		driver.quit();

	}

}
