package selenimJavaAdvance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingTheStaticDropdown {
	//static dropdown means which is in the select tag
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		String selectedDropdown;
		
		WebElement staticDrop=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown=new Select(staticDrop);
		dropdown.selectByIndex(2);
		 selectedDropdown=dropdown.getFirstSelectedOption().getText();
		System.out.println(selectedDropdown);
		dropdown.selectByVisibleText("USD");
		selectedDropdown=dropdown.getFirstSelectedOption().getText();
		System.out.println(selectedDropdown);
		
		
		
		
	}

}
