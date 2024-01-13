package com.frameworkDesign.SeleniumFrameWorkDesign;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.frameworkDesign.SeleniumFrameWorkDesign.Testcomponents.BaseTest;
import com.frameworkDesign.SeleniumFrameWorkDesign.Testcomponents.RetryFlakyScripts;

public class ErrorValidation extends BaseTest {

	@Test(dataProvider = "getData")
	public void addProductt(HashMap<String, String> k) throws IOException, InterruptedException {
		l.loginActions(k.get("email"), k.get("pwd"));
		Assert.assertEquals("Incorrect email or password.", l.getErrorMessage());

	}

	// directly providing the email and password through object
	/*
	 * @DataProvider public Object[][] getData() { return new Object[][] { {
	 * "sampawar@gmail.com", "1233" }, { "abcd@gmail.com", "WrongPass" } };
	 * 
	 * }
	 */
	
	// Instanting HashMap and providing the value and catching the map in respecting methods
	
	/*
	 * @DataProvider public Object[][] getData() {
	 * 
	 * HashMap<String, String> m=new HashMap<String, String>(); m.put("email",
	 * "email@gmail.com"); m.put("pwd", "668883");
	 * 
	 * HashMap<String , String> m1=new HashMap<String, String>(); m1.put("email",
	 * "dummy@gmil.com"); m1.put("pwd", "12344");
	 * 
	 * return new Object[][] {{m},{m1}};
	 * 
	 * }
	 */
	
	// through the external file ex: Json 
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String, String>> datais=getjsondataToMap();
		return new  Object[][] {{datais.get(0)},{datais.get(1)}};
	}
	
	
//	// example for retry 
//	@Test(retryAnalyzer = RetryFlakyScripts.class)
//	public void initionallyFailToChek_IretryAnalazer() {
//		l.loginActions("sampawar@gmail.com", "Password@123");
//		Assert.assertEquals("Incorrect email or password.", l.getErrorMessage());
//		
//	}
	
	
}
