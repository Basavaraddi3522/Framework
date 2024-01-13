package selenimJavaAdvance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_intro {
	public static void main(String[] args) {
//		WebDriver d = new ChromeDriver();
//	     d.get("https://rahulshettyacademy.com");
//	     d.manage().window().maximize();
//	   System.out.println(d.getTitle());
//	    System.out.println(d.getCurrentUrl());
//	    d.close(); // closes the current or driver where it is concentarting 
//	    
//	    // Launch in the fireFox Driver
//		
//		WebDriver driver =new FirefoxDriver();
//		  driver.get("https://rahulshettyacademy.com"); // d.manage().window().maximize();
//		   System.out.println(driver.getTitle()); //
//		  System.out.println(driver.getCurrentUrl());
//		  driver.close();
		
 // Launch in the EdgeDriver
		
		WebDriver driver =new EdgeDriver();
		  driver.get("https://rahulshettyacademy.com"); // d.manage().window().maximize();
		   System.out.println(driver.getTitle()); //
		  System.out.println(driver.getCurrentUrl());
		  driver.close();
		 
	    
	}

}
