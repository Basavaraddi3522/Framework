package logicsOnSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAllThelinks {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-alow-origins=*");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, option);
		option.merge(cap);
		WebDriver dr = new ChromeDriver(option);
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dr.manage().window().maximize();
		dr.get("https://rahulshettyacademy.com/AutomationPractice/");
		String title = dr.getTitle();
		System.out.println(title);
		// Assert.assertEquals(title, "Rahul Shetty Academy - Login page");
		List<WebElement> allLinks = dr.findElements(By.tagName("a"));
		int linkSize = allLinks.size();
		// Assert.assertEquals(linkSize, 3);
		System.out.println(linkSize);
	 //dr.close();
	dr.quit();

	}
}
