package Demofw.Demofw;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

public class Listeners  extends TestListenerAdapter{
  @Test
  public void onTestStart(ITestResult tr) 
  {
	  System.out.println("Test Started");
  }
  public void onTestSuccess(ITestResult tr)
  {
	  System.out.println("Test Passed");
  }
  public void onTestFailure(ITestResult tr)
  {
	  System.out.println("Test Failed");
  }
  public void onTestSkipped(ITestResult tr)
  {
	  System.out.println("Test Skipped");
  }
}
