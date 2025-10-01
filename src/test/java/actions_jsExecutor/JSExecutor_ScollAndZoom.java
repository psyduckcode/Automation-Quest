package actions_jsExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JSExecutor_ScollAndZoom {

	public static void main(String[] args) throws InterruptedException 
	{

		ChromeOptions op = new ChromeOptions();
		op.addArguments("--headless=new");
		
		
		
		WebDriver driver = new ChromeDriver(op);

		// Maximize Window
		driver.manage().window().maximize();
		
		// Open WebSite
		driver.get("https://testautomationpractice.blogspot.com/ ");

		// Create JavascriptExecutor object
		JavascriptExecutor js = (JavascriptExecutor) driver;
		

		// Scroll Down By Pixel Number(X,Y)
		js.executeScript("window.scrollBy(0,500)");

		// Return Value of Y(How Much Moved)
		System.out.println("Y Moved : "+js.executeScript("return window.pageYOffset;"));
		

		// Scrolling to End of Page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		

		// Scrolling to Top of Page
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		Thread.sleep(3000);

	
		// Scrolling Until Specific Element is Visible
		WebElement visibleElement = driver.findElement(By.xpath("//h2[normalize-space()='Visitors']"));
		js.executeScript("arguments[0].scrollIntoView();", visibleElement);
		
		Thread.sleep(3000);

		// Zoom In 
		js.executeScript("document.body.style.zoom='50%'");

		Thread.sleep(2000);

		// Zoom Out
		js.executeScript("document.body.style.zoom='100%'");
		
		
		//Close the Browser
		driver.quit();
		
	}

}
