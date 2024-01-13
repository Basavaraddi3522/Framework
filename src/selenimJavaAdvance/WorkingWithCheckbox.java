package selenimJavaAdvance;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithCheckbox {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(Duration.ofSeconds(3));
		List<WebElement> checkbxes=driver.findElements(By.xpath("//div[@id=\"discount-checkbox\"]/div/label"));
		int checkboxSize=checkbxes.size();
		for(WebElement check:checkbxes) {
			check.click();
			boolean val=check.isSelected();
			System.out.println(val);
			
		}
		
	}

}
