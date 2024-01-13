package com.frameworkDesign.SeleniumFrameWorkDesign;

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

import frameWorksPages.LandingPage;

public class EndtoEndTc {
	public static void main(String[] args) throws InterruptedException {
		String productName = "adidas original";
		
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get("https://rahulshettyacademy.com/client");
		LandingPage l=new LandingPage(d);
		WebElement userName = d.findElement(By.id("userEmail"));
		userName.sendKeys("sampawar@gmail.com");
		WebElement password = d.findElement(By.id("userPassword"));
		password.sendKeys("Password@123");
		WebElement login = d.findElement(By.id("login"));
		login.click();
		//System.out.println("sdjand");)

		// List<WebElement>element=d.findElements(By.cssSelector(".mb-3")); //dp this by
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> element = d.findElements(By.cssSelector(".mb-3"));

		WebElement eleText = element.stream()
				.filter(elemen -> elemen.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst()
				.orElse(null);
		eleText.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebElement toasterMessage = d.findElement(By.id("toast-container"));
		wait.until(ExpectedConditions.invisibilityOf(toasterMessage));
		// eleText.findElement(By.xpath("//div[@class='card-body']//button[text()=' Add
		// To Cart']")).click();
		WebElement cart = d.findElement(By.xpath(" //button[contains(text(),' Cart ')]"));
		cart.click();

		List<WebElement> cartProducts = d.findElements(By.xpath("//div[@class='cartSection']/h3"));
		boolean matchIs=cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(matchIs);
		WebElement checkOut=d.findElement(By.xpath("//li[@class='totalRow']/button[text()='Checkout']"));
		checkOut.click();
		//Thread.sleep(Duration.ofSeconds(4));
		
		
		WebElement country=d.findElement(By.xpath("//input[@placeholder='Select Country']"));
		country.sendKeys("india");
		
		//to scroll till bottom
		JavascriptExecutor js=(JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,350);","" );
		
		WebElement t=d.findElement(By.xpath("//section[@class='ta-results list-group ng-star-inserted']"));
		wait.until(ExpectedConditions.visibilityOf(t));
		Actions a=new Actions(d);
		WebElement desiredCountry=d.findElement(By.xpath("(//button[@class='ta-item list-group-item ng-star-inserted'])[2]"));
		a.moveToElement(desiredCountry).click().build().perform();
		int maxTries = 3;
		int tryCount = 0;

		while (tryCount < maxTries) {
		    try {
		    	WebElement placeOrder=d.findElement(By.xpath("//div[@class='actions']//a"));
		    	placeOrder.click();
		        break; // If click is successful, exit the loop
		    } catch (ElementClickInterceptedException e) {
		        tryCount++;
		        
		        Thread.sleep(1000); // Wait for a moment before retrying
		    }
		    System.out.println(tryCount);
		}
//		
//		WebElement placeOrder=d.findElement(By.xpath("//div[@class='actions']//a"));
//		//Thread.sleep(Duration.ofSeconds(2));
//		WebDriverWait w=new WebDriverWait(d, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
		//placeOrder.click();
//		WebElement elemen = d.findElement(By.xpath("//div[@class='actions']//a"));
//		((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", elemen);
//		elemen.click();
		
		
		WebElement sucessMessage=d.findElement(By.xpath("//h1[@class='hero-primary']"));
		
		  Assert.assertTrue(sucessMessage.getText().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	

	}

}
