//Pratice Authentication Alert


package alerts_frames_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authentication_Alert {

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();

		//send credentials with URL
		driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		String getmessage=driver.findElement(By.tagName("p")).getText();
		 
		 if(getmessage.isEmpty())
		 {
			System.out.println("Fail"); 
		 }
		 else
		 {
			
		     String message=driver.findElement(By.tagName("p")).getText();     
		     
		     if(message.trim().contains("Congratulations! You must have the proper credentials."))
					
					{	
				System.out.println("Login Success");
					}

		 }
		 
		 //Close Browser
		 driver.quit();
	}
		
	}

