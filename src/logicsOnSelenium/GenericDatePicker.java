package logicsOnSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericDatePicker {
	public static void main(String[] args) throws InterruptedException {

		WebDriver dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dr.manage().window().maximize();
		dr.get("https://www.path2usa.com/travel-companion/");
		Thread.sleep(Duration.ofSeconds(6));
		WebElement dateOtravel = dr.findElement(By.xpath("//input[@placeholder='Date of travel']"));
		Wait wait = new WebDriverWait(dr, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(dateOtravel));
		dateOtravel.click();

		WebElement requiredMonth = dr.findElement(By.xpath("//div[@class='flatpickr-month']/div[@class='flatpickr-current-month']"));
		
	String value=	requiredMonth.getText();
	System.out.println(value);
				
//		//div[@class='flatpickr-month']/div[@class='flatpickr-current-month']
//		while (!requiredMonth.getText().equalsIgnoreCase("October ")) {
//
//			Thread.sleep(Duration.ofSeconds(3));
//
//			dr.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
//		}
//		
//		System.out.println("cam out from whil");
//
//		// selecting the desired date // //
//
//		List<WebElement> allThedays = dr.findElements(By.xpath("//div[@class='flatpickr-days']//following-sibling::span"));
//		for (int i = 0; i < allThedays.size(); i++) {
//			String requiredDay = allThedays.get(i).getText();
//			if (requiredDay.equalsIgnoreCase("19")) { //
//				Thread.sleep(Duration.ofSeconds(3));
//				allThedays.get(i).click();
//				break;
//			}
//		}
//
//		// next month : //span[@class='flatpickr-next-month']
//
//		// month: //div[@class='flatpickr-month']/div[@class='flatpickr-current-month']
//
//		// yer xpah :
//		// //div[@class='flatpickr-month']/div[@class='flatpickr-current-month']/div/input[@class='numInput
//		// cur-year']
//		// month xpath :
//		// //div[@class='flatpickr-month']/div[@class='flatpickr-current-month']/span[@class='cur-month']
//	}

}
	
}
