package dropdowns_tables_datepickers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_Select {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		

		WebElement chkbox = driver.findElement(By.xpath("//select[@id='country']"));
		Select mychkbox = new Select(chkbox);
		

		// ::: Different ways to Select Value from DropDown ::: \\

		/* 1 **Select By Visible Text** */
		mychkbox.selectByVisibleText("India");
		

		/* 2 **Select By Value** */
		// mychkbox.selectByValue("china");
		

		/* 3 **Select By Index** */
		// mychkbox.selectByIndex(5);
		

		// Check Size of Drop Down
		List<WebElement> drop_size = mychkbox.getOptions();
		System.out.println("Size of Drop Down List:"+drop_size.size());
		

		// Print All Options

		// **For Loop**\\
		for (int i = 0; i < drop_size.size(); i++) 
		{
			System.out.println(drop_size.get(i).getText());
			
		}
	
		
		// ***Enchance For Loop***\\
		
		/*
		 * 
		 * List<WebElement> options = mychkbox.getOptions(); 
		 * for (WebElement op : options) 
		 * { 
		 * System.out.println(op.getText()); 
		 * }
		 * 
		 */
		
		
		
		// Close the Browser
		driver.quit();

	}

}
