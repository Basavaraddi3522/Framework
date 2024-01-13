package selenimJavaAdvance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class Loctors2 {
	public static void main(String[] args) throws InterruptedException {
		String name="hello@gmail.com";

		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		d.get("https://rahulshettyacademy.com/locatorspractice/");
		String applicationTitle = d.getTitle();
		System.out.println(applicationTitle);
		WebElement userName = d.findElement(By.id("inputUsername"));
		userName.sendKeys(name);
		WebElement password = d.findElement(By.name("inputPassword"));
		password.sendKeys("rahulshettyacademy");
		WebElement signInButton=d.findElement(By.className("signInBtn"));
		signInButton.click();
		Thread.sleep(2000);
		WebElement loginScreen=d.findElement(By.tagName("p"));
		String sucessfullMessage=loginScreen.getText();
		System.out.println(sucessfullMessage);
		Assert.assertEquals(sucessfullMessage,"You are successfully logged in.");
		WebElement useNameverification=d.findElement(By.cssSelector("div h2"));
		String user=useNameverification.getText();
		System.out.println(user);
		Assert.assertEquals(user, "Hello "+name+",");
		WebElement logout=d.findElement(By.xpath("//button[text()='Log Out']"));
		logout.click();
		d.close();
		
	}

}
