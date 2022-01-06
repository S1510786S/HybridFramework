package com.mcd.qa.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mcd.qa.base.TestBase;

public class ListenerClass1 extends TestBase implements ITestListener {

	public void onStart(ITestContext testContext)
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/myExtentReport.html");//specify location of the report
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Swapnil");
		
		htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		htmlReporter.config().setReportName("Functional Testing"); // name of the report
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.STANDARD);

	}
	
	public void onTestStart(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
	}
	
	public void onTestSuccess(ITestResult tr) {

		System.out.println("========Test '" + tr.getName() + "' PASSED========");		
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	}

	public void onTestFailure(ITestResult tr) {

		System.out.println("========Test '" + tr.getName() + "' FAILED========");
		//System.out.println("Priority of this method is " + tr.getMethod().getPriority());
		//logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		logger.log(Status.FAIL,"FAILED REASON :" + tr.getThrowable());
	
	}

	public void onTestSkipped(ITestResult tr) 
	{
		System.out.println("========Test '" + tr.getName() + "' SKIPPED========");
		//logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}
