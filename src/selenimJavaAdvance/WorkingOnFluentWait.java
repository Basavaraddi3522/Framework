package selenimJavaAdvance;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WorkingOnFluentWait {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// demo to handle sanchronization through fluent wait
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.manage().window().maximize();
		WebElement startButton = driver.findElement(By.cssSelector("[id='start'] button"));
		startButton.click();

		WebElement dynamicElement = driver.findElement(By.xpath("//div[@id='finish']/h4"));

		Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		WebElement foo = w.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if (dynamicElement.isDisplayed()) {
					System.out.println(dynamicElement.getText());
					return dynamicElement;
				} else
					return null;

			}

		});
		System.out.println(dynamicElement.isDisplayed());
	}

}
