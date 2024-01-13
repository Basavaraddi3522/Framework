package selenimJavaAdvance;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SumOfthescrosInthetable {
	public static void main(String[] args) throws InterruptedException {
		WebDriver dr = new ChromeDriver();

		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dr.manage().window().maximize();
		dr.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor)dr;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(Duration.ofSeconds(4));
		List<WebElement> scroes=dr.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
		int sum=0;
		for(int i=0;i<scroes.size();i++) {
			int sc=Integer.parseInt(scroes.get(i).getText());
			//System.out.println(sc);
			sum=sum+sc;
		}
		System.out.println(sum);
		
		WebElement total=dr.findElement(By.xpath("//div[@class='totalAmount']"));
	String messg=total.getText();
	
	String []arr=messg.split(":");
	int val=Integer.parseInt(arr[1].trim());
	Assert.assertEquals(sum, val);
	
		

	}

}