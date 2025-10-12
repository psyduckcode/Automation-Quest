//Handel SSL

package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Config_SSL_Handling {

	public static void main(String[] args)
	{
		//Create ChromeOptions object to configure browser settings
		ChromeOptions op = new ChromeOptions();
		
		//Accept insecure SSL certificates (bypass SSL warning pages)
		op.setAcceptInsecureCerts(true);
		
		op.setExperimentalOption("excludeSwitche", new String[] {"enable-automation"});
		
		
		WebDriver driver = new ChromeDriver(op);

		driver.get("https://expired.badssl.com");
		
		System.out.println("Title of Page:"+driver.getTitle());
		
		//Close the Browser
		driver.close();

	}

}
