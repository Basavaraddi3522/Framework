package itroductionToSelenium4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org. openqa. selenium. support. locators. RelativeLocator. with;

public class RelativeLocators {
	public static void main(String[] args) {
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameTextField=d.findElement(By.xpath("//input[@name='name']"));
		
		WebElement nameText=d.findElement(with(By.tagName("label")).above(nameTextField));
		String textIs=nameText.getText();
		System.out.println(textIs);
		
		// using below()
		
		WebElement passwordText=d.findElement(By.xpath("//label[text()='Date of Birth']"));
		
		d.findElement(with(By.tagName("input")).below(passwordText)).click();
		
		// using leftOf()
		
		WebElement icreamText=d.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		WebElement leftoficream=d.findElement(with(By.tagName("input")).toLeftOf(icreamText));
		leftoficream.click();
		// using toRightOf
		
		WebElement radiobutton=d.findElement(By.id("inlineRadio1"));
		WebElement rightofRadiobutton=d.findElement(with(By.tagName("label")).toRightOf(radiobutton));
		String textofRadioIs=rightofRadiobutton.getText();
		System.out.println(textofRadioIs);
	}
	
	// Relative locatrs are not applicable for flex component  , it will go and perform action for subsequent element

}
