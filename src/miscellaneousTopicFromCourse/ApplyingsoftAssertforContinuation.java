
package miscellaneousTopicFromCourse;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.apache.hc.core5.http.HttpConnection;
import org.bouncycastle.oer.its.etsi102941.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ApplyingsoftAssertforContinuation {
	public static void main(String[] args) throws MalformedURLException, IOException {
			WebDriver dr=new ChromeDriver();
			dr.manage().window().maximize();
			dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			dr.get("https://rahulshettyacademy.com/AutomationPractice/");
			//WebElement linkTocheck=dr.findElement(By.xpath("//a[contains(@href,'brokenlink')]"));
			SoftAssert a=new SoftAssert();
			List<WebElement>allLinks=dr.findElements(By.xpath("//li[@class='gf-li']/a"));
			//String hrefValue=linkTocheck.getAttribute("href");
			for(int i=0;i<allLinks.size();i++) {
				String hrefvalue=allLinks.get(i).getAttribute("href");
				HttpURLConnection con=(HttpURLConnection)new URL(hrefvalue).openConnection();
				con.setRequestMethod("HEAD");
				con.connect();
				int statusCode=con.getResponseCode();
				System.out.println(statusCode);
				a.assertTrue(statusCode>400, "the text of link "+allLinks.get(i).getText());
				
				}
			a.assertAll();
			}
			

}
