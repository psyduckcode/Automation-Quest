// Selenium Java Program to capture a screenshot of a specific WebElement

package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screeshot_WebElement {

	public static void main(String[] args) 
	{
		WebDriver driver=null;
		
		try
		{
		// Get current date and time for unique screenshot name
		Date dt1 = new Date();
		String filename  = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(dt1);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement label = driver.findElement(By.xpath("//h2[normalize-space()='SVG Elements']"));
		
		// Take screenshot and store it as a file
		//TakesScreenshot sh = (TakesScreenshot)driver;
		
		File sourceFile = label.getScreenshotAs(OutputType.FILE);
		
		
		// Define destination path and file name
		File destFile = new File(".\\screenshot\\"+"Element_"+filename+".png");
		
		// Copy screenshot to destination
		FileUtils.copyFile(sourceFile, destFile);
		
		System.out.println("Screenshot Taken Sucessfully");
		
		}catch(Exception e)
		{
			System.out.println("No SceenShot Taken");
		}
		
		//Close Browser
		driver.quit();
	}

}
