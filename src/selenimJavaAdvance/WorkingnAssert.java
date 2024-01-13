package selenimJavaAdvance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WorkingnAssert {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(Duration.ofSeconds(3));
		Assert.assertFalse(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());
		WebElement checkbx1=driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily"));
		checkbx1.click();
		
	 Assert.assertTrue(checkbx1.isSelected(), "selected");
		
	}

}
