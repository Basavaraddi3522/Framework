package itroductionToSelenium4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class TakingTheScreenshotOfWebElement {


	public static void main(String[] args) throws IOException {
		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://rahulshettyacademy.com/angularpractice/");
		
		// for tab
		//d.switchTo().newWindow(WindowType.TAB);
		
		// for NewWindow
		d.switchTo().newWindow(WindowType.WINDOW);
		// now the tab will be opened but we need to take the id to pass the other url and switch the concentration
		
		Set<String>windows=d.getWindowHandles();
		Iterator<String> allwindowId=windows.iterator();
		 String Parentwindowid= allwindowId.next();
		 String ChildwindowId=allwindowId.next();
		 d.switchTo().window(ChildwindowId);
		 d.get("https://rahulshettyacademy.com/");
		 WebElement fromtheseconUrl=d.findElement(By.xpath("//span[text()='why we are']"));
		 String textIs=fromtheseconUrl.getText();
		 d.switchTo().window(Parentwindowid);
		 WebElement nameTextfield=d.findElement(By.xpath("//input[@name='name']"));
		 nameTextfield.sendKeys(textIs);
		/// To ake the element screenShot use the webElementName
		File src =nameTextfield.getScreenshotAs(OutputType.FILE);
		
		Files.copy(src, new File("C:\\Users\\Admin\\Downloads\\SeleniumScreenshot\\EnteredName_.png"));
		
		// if we want to show in Eclipse folder structure 
		//Files.copy(src, new File("EnteredName.png"));
		
		
		 

		 
	}

}


