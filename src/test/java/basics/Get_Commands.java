//Browser get() Commands

package basics;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Get_Commands {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		
		// get() method
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		
		

		// getTitle() method
		String title = driver.getTitle();
		System.out.println(title);

		// getURL() method
		String url = driver.getCurrentUrl();
		System.out.println(url);

		// getPageSource
		String source = driver.getPageSource();
		System.out.println(source);

		// getWindowHandle() of first page
		String orginalhandel = driver.getWindowHandle();
		System.out.println("First Window Handel" + orginalhandel);

		// Open second URL in Another Window
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://testautomationpractice.blogspot.com/");

		// getWindowHandles() of both the pages (return set of string due to unique id)
		Set<String> windowsid = driver.getWindowHandles();
		System.out.println(windowsid);

		// Switching Back to Original Page
		driver.switchTo().window(orginalhandel);

		driver.quit();

	}

}
