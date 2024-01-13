package com.frameworkDesign.SeleniumFrameWorkDesign.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport {
	
	public   ExtentReports getThereportObject() {

		String location_path = System.getProperty("user.dir") + "\\extReport\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(location_path);
		

		// configuration for the HTML report
		reporter.config().setDocumentTitle("My Automation scripts reports");

		ExtentReports exte = new ExtentReports();

		// attach all the configuration

		exte.attachReporter(reporter);
		//setting tester name
		exte.setSystemInfo("Tester", "Sachin");
		
		return exte;
		

	}

}
