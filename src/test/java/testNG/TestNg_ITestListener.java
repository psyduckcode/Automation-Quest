//This class implements TestNG ITestListener Interface to monitor test execution

package testNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

	//Implementing ITestListener Interface
	public class TestNg_ITestListener implements ITestListener {


		public void onStart(ITestContext context)
		{
			System.out.println("Test is About to Start:"+ context.getName());		
		}

		public void onTestStart(ITestResult result)
		{
			System.out.println("Run Before Every Test");	
		}
		
		public void onTestSuccess(ITestResult result)
		{
			System.out.println("Yay Test Passed");	
		}
			
		public void onTestFailure(ITestResult result)
		{
			System.out.println("Me Sad Test Fail");	
		}
		
		public void onTestSkipped(ITestResult result)
		{
			System.out.println("Test Skipped");	
		}
		
		public void onFinish(ITestContext context)
		{
			System.out.println("All Test Finished");	
		}
	
	}



