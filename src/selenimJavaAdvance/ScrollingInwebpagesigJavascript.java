package selenimJavaAdvance;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingInwebpagesigJavascript {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver dr=new ChromeDriver();
		
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dr.manage().window().maximize();
		dr.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js= (JavascriptExecutor) dr;
		//scrolling vertically 
		Thread.sleep(Duration.ofSeconds(3));
		//js.executeAsyncScript("window.scrollBy(0,800)");
		Thread.sleep(Duration.ofSeconds(3));
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		
	}

}
