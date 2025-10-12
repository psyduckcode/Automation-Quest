//Pratice Pagination Tabel

package dropdowns_tables_datepickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination_Table 
{

    public static void main(String[] args) 
    {

        // Launch Chrome browser and open the page
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");

        // Count rows and columns in the table
        int rowCount = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
        System.out.println("Rows: " + rowCount);

        int colCount = driver.findElements(By.xpath("//table[@id='productTable']//th")).size();
        System.out.println("Columns: " + colCount);

        // Count number of pagination links
        int totalPages = driver.findElements(By.xpath("//ul[@id='pagination']//li")).size();
        System.out.println("Total Pages: " + totalPages);

        int selectedCount = 0; // Counter for selected items

        // Loop through each page
        for (int i = 1; i <= totalPages; i++) 
        {
        	
            if (i > 1) 
            {
                // Click on the page number
                driver.findElement(By.xpath("//ul[@id='pagination']//li[" + i + "]//a")).click();
            }

            // Loop through each row of the table
            for (int j = 1; j <= rowCount; j++) 
            {

                // Get item details
                String id = driver.findElement(By.xpath("//table[@id='productTable']//tr[" + j + "]/td[1]")).getText();
                String name = driver.findElement(By.xpath("//table[@id='productTable']//tr[" + j + "]/td[2]")).getText();
                String price = driver.findElement(By.xpath("//table[@id='productTable']//tr[" + j + "]/td[3]")).getText();

                System.out.println(id + "\t" + name + "\t" + price);

                // Select item if it matches certain criteria
                if (name.equalsIgnoreCase("Television") || name.equalsIgnoreCase("Smartwatch") ||
                    name.equalsIgnoreCase("Soundbar") || name.equalsIgnoreCase("Router") ||
                    price.equalsIgnoreCase("$10.99")) {

                    WebElement chkbox = driver.findElement(By.xpath("//table[@id='productTable']//tr[" + j + "]//td[4]//input"));
                    chkbox.click(); // Click checkbox
                    selectedCount++;

                    // Optional: capture item text
                    String itemText = driver.findElement(By.xpath("//table[@id='productTable']//tr[" + j + "]")).getText();
                    System.out.println("Selected Item: " + itemText);
                }
            }
        }

        System.out.println("Total Items Selected: " + selectedCount);

        // Close browser
        driver.quit();
    }
}
