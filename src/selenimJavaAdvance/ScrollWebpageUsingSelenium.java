package selenimJavaAdvance;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollWebpageUsingSelenium {
	public static void main(String[] args) {
		WebDriver dr=new ChromeDriver();
		
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dr.manage().window().maximize();
		dr.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Actions act=new Actions(dr);
		act.scrollByAmount(0, 800).perform();
		
	}
	
	

}
