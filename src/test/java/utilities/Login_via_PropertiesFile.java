// Selenium Program: Login Automation using Properties File for Credentials

package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_via_PropertiesFile {

	public static void main(String[] args) throws IOException {

		// Launch Chrome browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Load the properties file containing website URL, username, and password
		Properties pobj = new Properties();
		FileInputStream file = new FileInputStream("./testData/credential.properties");
		pobj.load(file);

		// Open the website from properties file
		driver.get(pobj.getProperty("website"));

		// Retrieve username and password from properties file
		String name = pobj.getProperty("username");
		String pass = pobj.getProperty("password");

		// Enter login credentials
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);

		// Click on the login button
		driver.findElement(By.xpath("//button[@id='submit']")).click();

		// Verify login success or failure
		if (!driver.findElements(By.xpath("//div[@id='error']")).isEmpty())
		{
			System.out.println("Login Failed");
		} 
		else 
		{
			System.out.println("Login Success");
		}

		// Close the browser
		driver.close();
	}
}
