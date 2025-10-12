//Pratice Static Tabel

package dropdowns_tables_datepickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Static_Table {

	public static void main(String[] args)
	{

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		// Number of Rows
		int rows = driver.findElements(By.xpath("//table[normalize-space(@name)='BookTable']//tr")).size();
		System.out.println("Number of Rows:" + rows);

		// Number of Column
		int col = driver.findElements(By.xpath("//table[normalize-space(@name)='BookTable']//th")).size();
		System.out.println("Number of Columns:" + col);

		// Print Specific Data
		String specificData = driver.findElement(By.xpath("//table[normalize-space(@name)='BookTable']//tr[5]//td[3]")).getText();
		System.out.println("Specific Data:" + specificData);

		/*
		 * //Printing Specific Row Data
		 * 
		 * for(int i=2;i<=rows;i++) { String rowData = driver.findElement(By.xpath(
		 * "//table[normalize-space(@name)='BookTable']//tr["+i+"]//td[1]")).getText();
		 * System.out.println(rowData); }
		 */

		// Print Table Header

		for (int j = 1; j <= col; j++) 
		{
			String headervalue = driver
					.findElement(By.xpath("//table[normalize-space(@name)='BookTable']//th[" + j + "]")).getText();
			System.out.print(headervalue + "\t");
		}
		
		System.out.println();

		// Print All Table Data
		for (int i = 2; i <= rows; i++) 
		{
			for (int j = 1; j <= col; j++) 
			{
				System.out.print(driver
						.findElement(
								By.xpath("//table[normalize-space(@name)='BookTable']//tr[" + i + "]//td[" + j + "]"))
						.getText() + "\t");
				System.out.print(" ");
			}
			System.out.println(" ");
		}

		// Specific Author with Book
		for (int i = 2; i <= rows; i++) 
		{
			String value = driver
					.findElement(By.xpath("//table[normalize-space(@name)='BookTable']//tr[" + i + "]//td[2]")).getText();
			
			if (value.contains("Mukesh")) 
			{
				System.out.println(value);
				String BookName = driver
						.findElement(By.xpath("//table[normalize-space(@name)='BookTable']//tr[" + i + "]//td[1]"))
						.getText();
				System.out.println(BookName);
			}

		}

		// Total Price
		int total = 0;
		for (int i = 2; i <= rows; i++)
		{
			String price = driver
					.findElement(By.xpath("//table[normalize-space(@name)='BookTable']//tr[" + i + "]//td[4]"))
					.getText();
			total = total + Integer.parseInt(price);
		}
		System.out.println("Total:" + total);

		driver.quit();
	}

}
