package handlingWindowsInselenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingToChildAndgetTheUserName {
	public static void main(String[] args) {
		
		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		WebElement lintoToswitch=d.findElement(By.xpath("//a[contains(text(),'Free Access to InterviewQue')]"));
		lintoToswitch.click();
		
		Set<String> windows=d.getWindowHandles();
		
		Iterator<String> it=windows.iterator();
		String parentId=it.next();
		String childId=it.next();
		d.switchTo().window(childId);
		WebElement requiredEmail=d.findElement(By.xpath("//p[@class='im-para red']"));
		String email=requiredEmail.getText();
	String t=email.split("at")[1].trim();
	String h=t.split(" ")[0];
	System.out.println(h);
	d.switchTo().window(parentId); 
	WebElement userName=d.findElement(By.id("username"));
	userName.sendKeys(h);
	
	
		
		
	}

}
