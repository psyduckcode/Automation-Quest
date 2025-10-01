//Selenium Program to Select Future Date

package dropdowns_tables_datepickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Date_FutureDate {

    // Method to select a specific future date from the Datepicker
	static void selectDate(WebDriver driver, String month, String year, String date) 
	{
		// Loop until the desired month and year appear in the Datepicker
		while (true) {
			String curr_month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String curr_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (curr_month.equals(month) && curr_year.equals(year)) {
				break; // Desired month and year found, exit loop
			}
			
			// Click the next button to move to the next month
			driver.findElement(By.xpath("//a[@data-handler='next']")).click();
		}
		
		// Get all available dates in the currently displayed month
		List<WebElement> curr_date = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		
		// Loop through the dates to find and click the desired one
		for (WebElement tempdate : curr_date) {
			if (tempdate.getText().equals(date)) {
				tempdate.click();
				break;	// Date selected, exit loop
			}

		}

	}

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Open URL
		driver.get("https://jqueryui.com/datepicker/");
		
		//Switch to Frame
		driver.switchTo().frame(0);
		
		//Click Datepicker to open calendar
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		//Call method to select a future date
		selectDate(driver, "January", "2026", "1");
		
		//Print Selected Date
		String chkDate=driver.findElement(By.xpath("//input[@id='datepicker']")).getAttribute("value");
		System.out.println(chkDate);

	}

}
