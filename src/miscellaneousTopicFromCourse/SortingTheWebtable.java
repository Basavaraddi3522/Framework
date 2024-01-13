package miscellaneousTopicFromCourse;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortingTheWebtable {
	public static void main(String[] args) {
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> unsortedvalue=d.findElements(By.xpath("(//tbody)[2]/tr/td[4]"));
		 Stream<String> s=unsortedvalue.stream().map(u->u.getText());
		 Stream<Integer>textValutoInteger= s.map(Integer::parseInt);
		  List<Integer> storingIntegervalue=textValutoInteger.collect(Collectors.toList());
		  //for verification have printed the integervalue
		  
		 // storingIntegervalue.forEach(y->System.out.println(y));
		  List<Integer>SortedValue=storingIntegervalue.stream().sorted().collect(Collectors.toList());
		 // Assert.assertTrue(unsortedvalue.equals(SortedValue));
		  // since it is not sorted it will fail
		  
		  //List<String> cityName=unsortedvalue.stream().filter(l->l.getText().contains("28")).map(l->l.getCityname(l)).collect(Collectors.toList());
		  //unsortedvalue.stream().filter(f->f.getText());
		  List<String> cityName=unsortedvalue. stream().filter(l-> l.getText().contains("28")).map(l -> getCityname(l)).collect(Collectors.toList());
		  cityName.forEach(l->System.out.println(l));

		  
	}

	public static String getCityname(WebElement l) {
	String cityNme=	l.findElement(By.xpath("preceding-sibling::td[1]")).getText();
	return cityNme;
	}
		
		
	
		
		
	}

