package selenimJavaAdvance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollTillElementinWebPage {
	public static void main(String[] args) throws InterruptedException {
		
WebDriver dr=new ChromeDriver();
		
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dr.manage().window().maximize();
		dr.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(Duration.ofSeconds(5));
		WebElement button=dr.findElement(By.id("mousehover"));
		
		JavascriptExecutor j=(JavascriptExecutor)dr;
		j.executeScript("arguments[0].scrollIntoView(true)", button);
		
		
	}

}
