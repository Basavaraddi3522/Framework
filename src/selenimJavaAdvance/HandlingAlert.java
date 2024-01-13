package selenimJavaAdvance;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingAlert {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String name = "sachin";
		WebElement alertName = driver.findElement(By.cssSelector("input#name"));
		alertName.sendKeys(name);
		WebElement confirmButton = driver.findElement(By.xpath("//input[@id='alertbtn']/following-sibling::input"));
		confirmButton.click();
		// handlin the alert

		// 1st one
		// driver.switchTo().alert().accept();
		// or you can use
		Alert ale = driver.switchTo().alert();
		String alertext = ale.getText();
		System.out.println(alertext);

		// to accept the alert
		// ale.accept();

		Assert.assertEquals(alertext, "Hello" + " " + name + "," + " " + "Are you sure you want to confirm?");
		Thread.sleep(Duration.ofSeconds(2));
		ale.accept();

		// to reject the alert
		// ale.dismiss();
		Thread.sleep(Duration.ofSeconds(2));

		WebElement normalAlert = driver
				.findElement(By.xpath("//input[@id='confirmbtn']/preceding-sibling::input[@id='alertbtn']"));
		normalAlert.click();
		Alert ale2 = driver.switchTo().alert();
		String normalAlText = ale2.getText();
		System.out.println(normalAlText);
		Assert.assertEquals(normalAlText, "Hello , share this practice page and share your knowledge");

		ale2.accept();

	}

}
