package selenimJavaAdvance;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingTheDynamicDropdown {
	static int numOfAdult;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number of adults for the trip");
		numOfAdult=sc.nextInt();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement passenger=driver.findElement(By.id("divpaxinfo"));
		passenger.click();
		HandlingTheDynamicDropdown.addingTheadult(driver);
		
		
		
		WebElement done=driver.findElement(By.id("btnclosepaxoption"));
		done.click();
		
		 passenger=driver.findElement(By.id("divpaxinfo"));
		String passinfo=passenger.getText();
		System.out.println(passinfo);
		Assert.assertEquals(numOfAdult+" "+"Adult",passinfo);
	}
	
	
	public static void addingTheadult(WebDriver driver) {
		for(int i=1;i<numOfAdult;i++)
		{
		WebElement selectAdult=driver.findElement(By.id("hrefIncAdt"));
		selectAdult.click();		}
	}

}
