package frameExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class SwitchingToIframe {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement drage=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		
		Actions a=new Actions(driver);
		a.dragAndDrop(drage, drop).build().perform();
		// now switching back to the normal web and performing the actions
		
		driver.switchTo().defaultContent();
		
		WebElement afterSwitchingback=driver.findElement(By.xpath("//a[text()='Autocomplete']"));
		afterSwitchingback.click();
		String currentTitle=driver.getTitle();
		Assert.assertEquals(currentTitle, "Autocomplete | jQuery UI");
		driver.close();
		
		}

}
