//Selenium Program for Data-Driven Testing using Apache POI and Excel

package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dataDrivenTesting {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();

		// Open WebSite
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		
	

		// Locate Username, Password Input Fields and Login Button
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));

		// Load Excel File Containing Multiple Login Credential
		FileInputStream file = new FileInputStream(".\\testData\\loginCredentials.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int totalRows = sheet.getLastRowNum(); // Total data rows in Excel

		// Loop through each row to perform Login Testing
		for (int i = 1; i <= totalRows; i++) {
			XSSFRow row = sheet.getRow(i);
			String result; // Variable to store Pass/Fail result

			// Read Username and Password from Excel
			String userFeild = row.getCell(0).toString();
			String passFeild = row.getCell(1).toString();

			username.sendKeys(userFeild);
			password.sendKeys(passFeild);
			button.click();

			// Verify Login Result
			if (!driver.findElements(By.xpath("//div[@id='error']")).isEmpty())
			{

				System.out.println("Login Failed");
				result = "Fail";

			}
			else
			{

				System.out.println("Login Success");
				result = "Pass";
				System.out.println("Username:" + userFeild);
				System.out.println("Password:" + passFeild);
				WebElement logOut = driver
						.findElement(By.xpath("//div[@class='wp-block-button aligncenter is-style-fill']"));
				logOut.click();
			
			}

			// If Result Column does not exist, create it
			if (row.getCell(2) == null) 
			{
				row.createCell(2);
			}

			// Write Pass/Fail Result Back to Excel
			row.getCell(2).setCellValue(result);
		}

		
		// Save the updated Excel File and Close Resources
		FileOutputStream output = new FileOutputStream(".\\testData\\loginCredentials.xlsx");
		workbook.write(output);
		workbook.close();
		output.close();
		file.close();

		// Close the browser after all testing
		driver.close();

		System.out.println("Data-driven login test completed successfully.");

	}

}
