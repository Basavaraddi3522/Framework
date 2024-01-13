package selenimJavaAdvance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ValidtingEnabledorDisabledsing {
	public static void main(String[] args) throws InterruptedException {
		
	

	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	Thread.sleep(Duration.ofSeconds(3));
	
	
	
	// we use this we disable enable method doesnt work because of the latest technology
	WebElement roundtrip=driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1"));
	roundtrip.click();
	
	WebElement enableordisableBystyle=driver.findElement(By.id("Div1"));
	String val=enableordisableBystyle.getAttribute("style");
	if(val.contains("1")) {
		Assert.assertTrue(true);
		System.out.println("it is enabled");
		
		
		
	}
	else {
		Assert.assertFalse(true);
	}
	

}
}