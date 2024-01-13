package com.frameworkDesign.SeleniumFrameWorkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.frameworkDesign.SeleniumFrameWorkDesign.Testcomponents.BaseTest;
import com.frameworkDesign.SeleniumFrameWorkDesign.Testcomponents.RetryFlakyScripts;

import frameWorksPages.CartPage;
import frameWorksPages.CheckOutPage;
import frameWorksPages.ConfirmationPage;
import frameWorksPages.LandingPage;
import frameWorksPages.MyOrdersPage;
import frameWorksPages.ProductListiningPage;
import reusableComponents.Reusablemethods;

public class EndtoEndTc2 extends BaseTest {
	// public static void main(String[] args) throws InterruptedException,
	// IOException {
	public String productName = "adidas original";
//	
	@Test
	public void addProduct() throws IOException, InterruptedException {
		//String productName = "adidas original";
		//LandingPage  l=launchApplicationFromBase();--> insted of this we have written before method in baseTest
		ProductListiningPage p = l.loginActions("sampawar@gmail.com", "Password@123");
		
		List<WebElement> allproducs = p.getproductList();
		p.getProductByName(productName);
		p.addtheproductTocart(productName);
		CartPage c = p.gotoCart();
		// CartPage c=new CartPage(d);
		boolean matchIs = c.verifyIfproductisPresen(productName);
		Assert.assertTrue(matchIs);
		CheckOutPage co = c.goToCheckOut();
		co.selectTheCounty("india");

		ConfirmationPage confirmation = co.clickOnProceed(4);

		String sucessMessge = confirmation.verifySucessMessage();

		Assert.assertTrue(sucessMessge.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		Thread.sleep(Duration.ofSeconds(4));
		l.SingOut(4);
	

	}
	@Test(groups= {"Error"})
	public void addingproductgin() throws InterruptedException {
	
			
			//ProductListiningPage p = l.loginActions("sampawar@gmail.com", "Password@123");
			ProductListiningPage p = l.loginActions("sampawar@gmail.com", "Password@123");
			List<WebElement> allproducs = p.getproductList();
			p.getProductByName(productName);
			p.addtheproductTocart(productName);
			CartPage c = p.gotoCart();
			// CartPage c=new CartPage(d);
			boolean matchIs = c.verifyIfproductisPresen(productName);
			Assert.assertTrue(matchIs);
			CheckOutPage co = c.goToCheckOut();
			co.selectTheCounty("india");

			ConfirmationPage confirmation = co.clickOnProceed(4);

			String sucessMessge = confirmation.verifySucessMessage();

			Assert.assertTrue(sucessMessge.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//			Thread.sleep(Duration.ofSeconds(4));
			l.SingOut(4);
		

		}
	
	@Test(dependsOnMethods = {"addProduct"})
	public void verifyTheProduct() throws InterruptedException {
		//String productName = "";
		ProductListiningPage p = l.loginActions("sampawar@gmail.com", "Password@123");
		Thread.sleep(Duration.ofSeconds(5));
		MyOrdersPage my= p.gotoMyorders();
		Thread.sleep(Duration.ofSeconds(5));
		boolean matchIs=my.verifyproductName(productName);
		Assert.assertTrue(matchIs);
		
	}
	

	}


