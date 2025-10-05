// Selenium Java Program to Upload a File and Verify Successful Upload

package utilities;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FieUpload {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = null;
		try 
		{
			
		// Launch Chrome browser
		driver = new ChromeDriver();

		
		//Maximize Window
		driver.manage().window().maximize();
		
		//Open Website
		driver.get("https://practice.expandtesting.com/upload");
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		
		// Prepare the file to upload
		File file = new File("./testData/FileUploadProgramFile.pdf");
		
		//Condition to Check if File Exist
		if(file.exists())
		{
			System.out.println("File Exist");
		}
		else
		System.out.println("No File Exist");
		
		
		//Upload the file by sending absolute path to the input element
		driver.findElement(By.xpath("//input[@id='fileInput']")).sendKeys(file.getAbsolutePath());
	
		
		// Click the Submit button using JavascriptExecutor
		WebElement submitBtn = driver.findElement(By.id("fileSubmit"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", submitBtn);
		

		System.out.println("Page Title: "+  driver.getTitle());
		
		//Verify file upload success
		String check =	driver.findElement(By.xpath("//h1[normalize-space()='File Uploaded!']")).getText();
		
		if(check.equalsIgnoreCase("File Uploaded!"))
			{
				System.out.println("You Upload a File: "+  file.getName());
			}	
			
		}catch(Exception e)
		{
			System.out.println("No File Uploaded");
		}
		
		//Close the Browser
	     driver.quit();
	}
}
