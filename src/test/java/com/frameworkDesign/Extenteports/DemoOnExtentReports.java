package com.frameworkDesign.Extenteports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DemoOnExtentReports {
	ExtentReports exte;

	@BeforeTest
	public void extentReportConfig() {

		String location_path = System.getProperty("user.dir") + "\\extReport\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(location_path);

		// configuration for the HTML report
		reporter.config().setDocumentTitle("Dummy Automation reports");

		 exte = new ExtentReports();

		// attach all the configuration

		exte.attachReporter(reporter);
		//setting tester name
		exte.setSystemInfo("Tester", "Sachin");
		

	}

	@Test
	public void Tc001() {
		ExtentTest te=exte.createTest("TC001");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String titleis= driver.getTitle();
		System.out.println(titleis);
		driver.close();
		
		exte.flush();

	}

}
