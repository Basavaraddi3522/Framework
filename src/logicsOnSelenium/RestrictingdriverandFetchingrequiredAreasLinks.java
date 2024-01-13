package logicsOnSelenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RestrictingdriverandFetchingrequiredAreasLinks {
	public static void main(String[] args) throws InterruptedException {
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--remote-alow-origins=*");
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability(ChromeOptions.CAPABILITY, option);
//		option.merge(cap);
		WebDriver dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dr.manage().window().maximize();
		dr.get("https://rahulshettyacademy.com/AutomationPractice/");
//		String title = dr.getTitle();
//		System.out.println(title);
//		List<WebElement> allLinks = dr.findElements(By.tagName("a"));
//		int linkSize = allLinks.size();
//		System.out.println(linkSize);
//		WebElement minidriver = dr.findElement(By.id("gf-BIG"));
//		List<WebElement> linksOnFooter = minidriver.findElements(By.tagName("a"));
//		int footerLinkSize = linksOnFooter.size();
//		System.out.println(footerLinkSize);
//		
		//identifying the specific links in the coloum 
		WebElement specifictable=dr.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]"));
		List<WebElement> linksinSpecifictable=specifictable.findElements(By.tagName("a"));
		System.out.println(linksinSpecifictable.size());
		
		// clicking on eachlink and verify the page 
//		for(WebElement ClickOn:linksinSpecifictable){
//			ClickOn.click();
//			System.out.println(dr.getTitle());
//			Thread.sleep(Duration.ofSeconds(3));
//			dr.navigate().back();
//			
//			
//		}
//		
		for(int i=1;i<linksinSpecifictable.size();i++) {
			WebElement indilink=linksinSpecifictable.get(i);
		String keyaction=Keys.chord(Keys.CONTROL,Keys.ENTER);
		//specifictable.findElements(By.tagName("a")).get(i).sendKeys(keyaction);
		indilink.sendKeys(keyaction);
		
		}
		Thread.sleep(Duration.ofSeconds(8));
		
		Set<String> allWindow=dr.getWindowHandles();
		
		Iterator<String> ite=allWindow.iterator();
		while(ite.hasNext()) {
			dr.switchTo().window(ite.next());
			String titleIs=dr.getTitle();
			System.out.println(titleIs);
		}
		
		
		
	}

}
