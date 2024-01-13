package com.frameworkDesign.SeleniumFrameWorkDesign.Testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.frameworkDesign.SeleniumFrameWorkDesign.resources.Extentreport;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;

	// created the object for extentreport class to access the getThereportObject
	Extentreport ex = new Extentreport();
	ExtentReports e = ex.getThereportObject();
	// to avoid the concurence when the execution is paralle we go for ThreadLocal

	ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test = e.createTest(result.getMethod().getMethodName());
		extent.set(test); // which will generate the unique id for the test
		System.out.println("Execution is initilized");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		//test.log(Status.PASS, "the test case pass");
		
		extent.get().log(Status.PASS, "test case is Pass");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		//test.fail(result.getThrowable()); // to get the exception becuase of hich reaosn the script is failed
		 extent.get().fail(result.getThrowable());
		try {
			d = (WebDriver) result.getTestClass().getRealClass().getField("d").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String pathOfScreenshotStordInWorksapce = null;
		try {

			pathOfScreenshotStordInWorksapce = getSceenShot(result.getMethod().getMethodName(), d);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//test.addScreenCaptureFromPath(pathOfScreenshotStordInWorksapce, result.getMethod().getMethodName());
		extent.get().addScreenCaptureFromPath(pathOfScreenshotStordInWorksapce, result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		e.flush();
	}

}
