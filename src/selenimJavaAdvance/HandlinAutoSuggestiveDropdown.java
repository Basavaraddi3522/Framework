package selenimJavaAdvance;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlinAutoSuggestiveDropdown {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement autosuggestionBox = driver.findElement(By.id("autosuggest"));
		autosuggestionBox.sendKeys("ind");

		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item'] /a"));

//		options.forEach(option -> {
//			if (option.getText().equalsIgnoreCase("India")) {
//				option.click();
//				
//			//break;
//				
//			}
//				
//		// do research on how to break the iterator for each
//			
//			     
//
//		});
		
		for(WebElement o:options) {
			if (o.getText().equalsIgnoreCase("India")) {
				Thread.sleep(Duration.ofSeconds(1));
				o.click();
			break;
			}
		}

	}

}
