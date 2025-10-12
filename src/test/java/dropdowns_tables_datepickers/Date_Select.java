//Selenium Program to Select Date

package dropdowns_tables_datepickers;
import java.time.Month;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Date_Select {

	
		// Convert short month string (e.g., "Jan") to Java Month enum
	    static Month MonthConvertor(String month) {
	        HashMap<String, Month> monthmap = new HashMap<>();
	        monthmap.put("Jan", Month.JANUARY);
	        monthmap.put("Feb", Month.FEBRUARY);
	        monthmap.put("Mar", Month.MARCH);
	        monthmap.put("Apr", Month.APRIL);
	        monthmap.put("May", Month.MAY);
	        monthmap.put("Jun", Month.JUNE);
	        monthmap.put("Jul", Month.JULY);
	        monthmap.put("Aug", Month.AUGUST);
	        monthmap.put("Sep", Month.SEPTEMBER);
	        monthmap.put("Oct", Month.OCTOBER);
	        monthmap.put("Nov", Month.NOVEMBER);
	        monthmap.put("Dec", Month.DECEMBER);

	        Month vmonth = monthmap.get(month);
	        if (vmonth == null) {
	            System.out.println("Invalid Month: " + month);
	        }
	        return vmonth;
	    }

	    // Method to select a date dynamically
	    static void selectDate(WebDriver driver, String year, String Month, String Date) {

	        // Select Year from dropdown
	        WebElement dropdownYear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
	        Select targetYear = new Select(dropdownYear);
	        targetYear.selectByVisibleText(year);

	        // Navigate months until the desired month is visible
	        while (true) {
	            WebElement selectMonthElement = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
	            Select selectMonth = new Select(selectMonthElement);
	            String visibleMonth = selectMonth.getFirstSelectedOption().getText();

	            Month targetMonth = MonthConvertor(Month);
	            Month currentMonth = MonthConvertor(visibleMonth);
	            int result = targetMonth.compareTo(currentMonth);

	            if (result > 0) { // Future Month
	                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	            } else if (result < 0) { // Past Month
	                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
	            } else { // Month matched
	                break;
	            }
	        }

	        // Select Date
	        driver.findElement(By.xpath("//table//*[@data-date=" + Date + "]")).click();
	        System.out.println("Selected Date: " + Date + " " + Month + " " + year);
	    }

	    public static void main(String[] args) {
	        // Launch Chrome Browser
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Open test page with date picker
	        driver.get("https://testautomationpractice.blogspot.com/");

	        // Open date picker
	        driver.findElement(By.id("txtDate")).click();

	        // Select specific date
	        selectDate(driver, "2023", "Jul", "31");

	        // Close browser
	        driver.quit();

	}

}
