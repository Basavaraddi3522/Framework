package miscellaneousTopicFromCourse;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingTheCookies {
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// to delete all the cookies
		driver.manage().deleteAllCookies();
		
		// To delete the specific cookie
		
		driver.manage().deleteCookieNamed("The cookie name");
		
	}

}
