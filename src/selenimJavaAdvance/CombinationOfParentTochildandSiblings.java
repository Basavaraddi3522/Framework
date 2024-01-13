package selenimJavaAdvance;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CombinationOfParentTochildandSiblings {
	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/practice-project");
		
		//From parent to sibiling combilantion
//		WebElement practice=driver.findElement(By.xpath("(//ul[@class=\"navigation clearfix\"])[1]/li[1]/following-sibling::li[6]//a[text()='Practice']"));
//		String text=practice.getText();
		
		//from parent child and child to parent and siblings combination
		WebElement  practice=driver.findElement(By.xpath("(//ul[@class=\"navigation clearfix\"])[1]/li[1]/parent::ul/parent::div/ul/li[1]/following-sibling::li[6]/a"));
		String text=practice.getText();
		System.out.println(text);
	}

}
