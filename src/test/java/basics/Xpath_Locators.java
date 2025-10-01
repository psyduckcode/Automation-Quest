//Locating WebElement Using Xpath

package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_Locators {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
		
		
		// 1 (insted of TagName we can just write //* )
		boolean check1 = driver.findElement(By.xpath("//input[@name='firstname']")).isDisplayed();
		System.out.println("1:"+check1);
		

		// 2 Xpath with Multiple Attribute
		boolean check2 = driver.findElement(By.xpath("//input[@name='lastname'][@id='input-lastname']")).isDisplayed();
		System.out.println("2:"+check2);
		
		
		//3 Xpath with AND operator (Both Condition Should be True)
		boolean check3 = driver.findElement(By.xpath("//input[@type='email' and @id='input-email']")).isDisplayed();
		System.out.println("3:"+check3);
		
		
		//4 Xpath with OR operator (One Condition Should Be True)
		boolean check4=driver.findElement(By.xpath("//input[@type='t' or @name='telephone']")).isDisplayed();
		System.out.println("4:"+check4);
		
		
		//5 Xpath with contains()
		boolean check5=driver.findElement(By.xpath("//input[contains(@name,'conf')]")).isDisplayed();
		System.out.println("5:"+check5);
		
		//6 Xpath with stats-with()
		boolean check6=driver.findElement(By.xpath("//input[starts-with(@name,'pass')]")).isDisplayed();
		System.out.println("6:"+check6);
		
		
		//7 Xpath with text()
		boolean check7=driver.findElement(By.xpath("//button[text()='Search']")).isDisplayed();
		System.out.println("7:"+check7);
		
		driver.quit();

	}

}
