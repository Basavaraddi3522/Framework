package handlingActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WorkingOnMouseOver {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		WebElement mouseOver=driver.findElement(By.xpath("//div[@id='nav-tools']//a[@id='nav-link-accountList']"));
		Thread.sleep(Duration.ofSeconds(2));
		Actions act=new Actions(driver);
		act.moveToElement(mouseOver).build().perform();
		
		
		
	}

}
