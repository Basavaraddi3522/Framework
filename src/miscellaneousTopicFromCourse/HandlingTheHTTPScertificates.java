package miscellaneousTopicFromCourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HandlingTheHTTPScertificates {
	public static void main(String[] args) {
		// ChromeOptions opt=new ChromeOptions();
		// for firefox
		FirefoxOptions opt = new FirefoxOptions();
		// for edge
		// EdgeOptions opt=new EdgeOptions();
		opt.setAcceptInsecureCerts(true);
		WebDriver driver = new FirefoxDriver(opt);
		driver.get("https://expired.badssl.com");
		String title = driver.getTitle();
		System.out.println(title);

		driver.close();
	}

}
