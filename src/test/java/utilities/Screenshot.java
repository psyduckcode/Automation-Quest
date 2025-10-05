// Selenium Java Program to capture a screenshot of a Website


package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = null;
		
		try
		{		
		// Get current date and time for unique screenshot name
		Date dt1 = new Date();
		String filename  = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(dt1);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		// Take screenshot and store it as a file
		TakesScreenshot sh = (TakesScreenshot)driver;
		File sourceFile = sh.getScreenshotAs(OutputType.FILE);
		
		
		// Define destination path and file name
		File destFile = new File(".\\screenshot\\"+"Page_"+filename+".png");
		
		// Copy screenshot to destination
		FileUtils.copyFile(sourceFile, destFile);
		
		System.out.println("Screenshot Taken Sucessfully");
		
		
	
		}catch(Exception e)
		{
			System.out.println("No SceenShot Taken");
		}
		
		driver.quit();
	}

}
