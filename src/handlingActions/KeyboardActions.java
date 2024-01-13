package handlingActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Actions a = new Actions(driver);
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		a.moveToElement(search).keyDown(Keys.SHIFT).sendKeys("hhhhh").keyUp(Keys.SHIFT);

		Thread.sleep(Duration.ofSeconds(2));
		a.doubleClick();
		//System.out.println("done double click");
		
		Thread.sleep(Duration.ofSeconds(2));
		a.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL);
		Thread.sleep(Duration.ofSeconds(2));
		//System.out.println("done with contrl x");
		a.keyDown(Keys.CONTROL).sendKeys("v").build().perform();
		//System.out.println("donewith control v");

	}

}
