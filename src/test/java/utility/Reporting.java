package utility;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterClass;

public class Reporting extends TestListenerAdapter{
	public ExtentSparkReporter htmlReports;
	public ExtentReports xReports;
	public ExtentTest xTests;
	public void onStart(ITestContext testContext)
	{
		String datestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(0));
		String repname="Test-Automation-Report-"+datestamp+".html";
		htmlReports = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/"+repname);
		htmlReports.config().setDocumentTitle("Test Automation Report");
		htmlReports.config().setReportName("Functional Report");
		htmlReports.config().setTheme(Theme.DARK);
		
		xReports=new ExtentReports();
		xReports.attachReporter(htmlReports);
		xReports.setSystemInfo("QA NAME", "Bhawana");
		xReports.setSystemInfo("OS", "WINDOWS 10");
		xReports.setSystemInfo("Host Name", "Local Host");
		
		
		
	}
	public void onFinish(ITestContext testContext)
	{
		xReports.flush();
	}
	public void onTestSuccess(ITestResult tr)
	{
		xTests=xReports.createTest(tr.getName());
		xTests.log(Status.PASS, "Test is Passed");
		xTests.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult tr)
	{
		xTests=xReports.createTest(tr.getName());
		xTests.log(Status.FAIL, "Test is Failed");
		xTests.log(Status.FAIL, tr.getThrowable());
		xTests.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		String ssPath=System.getProperty("user.dir")+"/Screenshot/"+tr.getName()+".png";
		File file=new File(ssPath);
		if(file.exists())
			try{
				xTests.fail("Screenshot of the failed test case is:"+ xTests.addScreenCaptureFromPath(ssPath));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	
			

	}
			
		
		
		public void onTestSkipped(ITestResult tr)
		{
			xTests=xReports.createTest(tr.getName());
			xTests.log(Status.SKIP,"Test is Skipped");
			xTests.log(Status.SKIP, tr.getThrowable());
			xTests.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.BLUE));
		}
			
	
	

  
}
