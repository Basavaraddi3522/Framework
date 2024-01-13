package selenimJavaAdvance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatingReusableMethods {
	public static void main(String[] args) throws InterruptedException {
		
		String name="hello@gmail.com";

		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		d.get("https://rahulshettyacademy.com/locatorspractice/");
		String applicationTitle = d.getTitle();
		System.out.println(applicationTitle);
		String newpassword=CreatingReusableMethods.getpassword(d);
		WebElement gotologin=d.findElement(By.xpath("//button[text()='Go to Login']"));
		gotologin.click();
		Thread.sleep(2000);
		WebElement userName = d.findElement(By.id("inputUsername"));
		userName.sendKeys(name);
		WebElement password=d.findElement(By.name("inputPassword"));
		password.sendKeys(newpassword);
		System.out.println(newpassword);
		WebElement signInButton=d.findElement(By.className("signInBtn"));
		signInButton.click();
		
	
		
	}
	
	
	public static  String getpassword(WebDriver d) throws InterruptedException {
		
		WebElement forgot_ink=d.findElement(By.xpath("//a[text()='Forgot your password?']"));
		forgot_ink.click();
		Thread.sleep(3000);
		WebElement reset=d.findElement(By.xpath("//button[text()='Reset Login']"));
		reset.click();
		WebElement newPassword=d.findElement(By.xpath("//p[text()=\"Please use temporary password 'rahulshettyacademy' to Login.\"]"));
		String resuePass=newPassword.getText();
		String [] sp=resuePass.split("'");
		String p=sp[1].split("'")[0];
		  
		return p;
	}

}
