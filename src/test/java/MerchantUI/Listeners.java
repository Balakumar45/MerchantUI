package MerchantUI;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener {

	public static Logger Log = LogManager.getLogger(ITestListener.class.getName());

	public ExtentTest test;

	ExtentReports extent=ExtentReporterNG.getReportObject();

	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {

	// TODO Auto-generated method stub

	test= extent.createTest(result.getMethod().getMethodName());

	Log.info("*** Test Suite " + result.getName() + " ending ***");

	extentTest.set(test);

	}



	public void onTestSuccess(ITestResult result) {

	// TODO Auto-generated method stub

	//extentTest.get().log(Status.PASS, "Test Passed");

	//ITestListener.super.onTestSuccess(result);

	extentTest.get().log(Status.PASS, "Test passed");

	String testMethodNamesuccess =result.getMethod().getMethodName();

	try {

	driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());

	}catch (Exception e)

	{



	}

	try {

	extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodNamesuccess, driver), result.getMethod().getMethodName());

	} catch (IOException e) {

	e.printStackTrace();

	}

	}



	public void onTestFailure(ITestResult result) {

	// TODO Auto-generated method stub

	//Screenshot

	extentTest.get().fail(result.getThrowable());

	WebDriver driver =null;

	String testMethodName =result.getMethod().getMethodName();

	try {

	driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());

	} catch(Exception e)

	{

	}

	try {

	extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());

	} catch (IOException e) {

	// TODO Auto-generated catch block

	e.printStackTrace();

	}

	}



	public void onTestSkipped(ITestResult result) {

	// TODO Auto-generated method stub

	}



	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	// TODO Auto-generated method stub

	}



	public void onStart(ITestContext context) {

	// TODO Auto-generated method stub

	}



	public void onFinish(ITestContext context) {

	// TODO Auto-generated method stub

	extent.flush();

	}
}
	