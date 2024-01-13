package selenimJavaAdvance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandingWindowsActions {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.navigate().to("https://rahulshettyacademy.com");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
	}

}
