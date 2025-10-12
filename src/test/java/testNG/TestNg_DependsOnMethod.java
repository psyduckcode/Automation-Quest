// Selenium TestNG Program: dependsOnMethods Example

package testNG;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNg_DependsOnMethod {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Setup browser and open the login page
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
	}

	@Test(priority = 0)
	public void loginTest() {
		// Perform Login Action
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("akashverma@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("akashverma");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		// Checking if Login Failed by dectecting Error Alert
		try {
			driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
			Assert.fail("Login Failed");
		} catch (Exception e) {
			System.out.println("Login Success");
		}

	}

	@Test(dependsOnMethods = "loginTest")
	public void changeSettings() {
		// This test will run only if loginTest() passes

		// Navigate to Newsletter Subscription settings
		driver.findElement(By.xpath("//a[normalize-space()='Subscribe / unsubscribe to newsletter']")).click();

		// Locate radio buttons for subscription options
		WebElement radioYesInput = driver.findElement(By.id("input-newsletter-yes"));
		WebElement radioNoInput = driver.findElement(By.id("input-newsletter-no"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Use JavaScriptExecutor to handle cases where normal click might fail
		if (radioYesInput.isSelected()) {
			js.executeScript("arguments[0].click();", radioNoInput);
			System.out.println("Toggled from YES → NO");
		} else {
			js.executeScript("arguments[0].click();", radioYesInput);
			System.out.println("Toggled from NO → YES");
		}

		// Click on Continue button after selecting option
		WebElement cont_Btn = driver.findElement(By.xpath("//input[@value='Continue']"));

		js.executeScript("arguments[0].click()", cont_Btn);

		// Wait for Success Alert after saving
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement successAlert = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));

		// Validate Success Message
		String successMessage = successAlert.getText();

		if (successMessage.contains("Success: Your newsletter subscription has been successfully updated!")) {
			System.out.println("Setting Updated Successfully");
		} else {
			System.out.println("Error Occured while updating Settings");
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
