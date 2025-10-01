package alerts_frames_windows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows_Tabs {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		//Open WebPage
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println("Opened: " + driver.getTitle());
		
		//Open WebPage in New Tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Opened in new TAB: " + driver.getTitle());
		
		//Open WebPage in new Window
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://the-internet.herokuapp.com/");
		System.out.println("Opened in new WINDOW: " + driver.getTitle());
		
		
		//Close Browser
		driver.quit();

	}

}
