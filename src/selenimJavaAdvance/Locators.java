package selenimJavaAdvance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		d.get("https://rahulshettyacademy.com/locatorspractice/");
		String applicationTitle=d.getTitle();
		System.out.println(applicationTitle);
		WebElement userName=d.findElement(By.id("inputUsername"));
		userName.sendKeys("hello");
		WebElement password=d.findElement(By.name("inputPassword"));
		password.sendKeys("wwww");
		WebElement signInButton=d.findElement(By.className("signInBtn"));
		signInButton.click();
	
		WebElement errormessage=d.findElement(By.xpath("//p[text()=\"* Incorrect username or password\"]"));
		System.out.println(errormessage.getText());
		WebElement forgot_ink=d.findElement(By.xpath("//a[text()='Forgot your password?']"));
		forgot_ink.click();
		Thread.sleep(3000);
		WebElement reset=d.findElement(By.xpath("//button[text()='Reset Login']"));
		reset.click();
		WebElement newPassword=d.findElement(By.xpath("//p[text()=\"Please use temporary password 'rahulshettyacademy' to Login.\"]"));
		System.out.println(newPassword.getText());
		d.close();
		
	}

}
