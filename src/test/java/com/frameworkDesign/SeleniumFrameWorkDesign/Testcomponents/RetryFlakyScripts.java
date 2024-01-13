package com.frameworkDesign.SeleniumFrameWorkDesign.Testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFlakyScripts implements IRetryAnalyzer{

	
	//Note: Untill the retry method returns True the script or@Test method wher you have added the parameter It will run
	
	// Example @Test(retryAnalyzer=RetryFlakyscript.Class)
	
	
	int initilCount=0;
	int maximumNoOftries=1;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(initilCount<maximumNoOftries) {
			initilCount ++;
			return true;
			
		}
		
		return false;
	}

}
