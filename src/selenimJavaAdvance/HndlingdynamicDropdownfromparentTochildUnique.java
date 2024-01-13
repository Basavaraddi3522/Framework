package selenimJavaAdvance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HndlingdynamicDropdownfromparentTochildUnique {
	
	public static void main(String[] args) {
		
//		Scanner sc=new Scanner(System.in);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement originField=driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		originField.click();
		
		
		WebElement orginLocation=driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[text()=' Belagavi (IXG)']"));
		orginLocation.click();
		WebElement destinationField=driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
		destinationField.click();
		
		WebElement destinationLoc=driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[text()=' Ahmedabad (AMD)']"));
		destinationLoc.click();
		
		
	}

}
