package selenimJavaAdvance;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WorkinginAddingtheMultipleProduct {
	public static void main(String[] args) {
		String[] veggiesToadd = { "Cucumber", "Carrot", "Beetroot" };
		String couponCode = "rahulshettyacademy";

		WebDriver d = new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/seleniumPractise");
		addIteam(d, veggiesToadd);
		WebElement cartIco = d.findElement(By.xpath("//a[@class='cart-icon']"));
		cartIco.click();
		WebElement proceedToPay = d.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
		proceedToPay.click();
		WebElement promocode = d.findElement(By.xpath("//div[@class='promoWrapper']/input"));
		promocode.sendKeys(couponCode);

		WebElement applyButton = d.findElement(By.xpath("//div[@class='promoWrapper']/button"));
		applyButton.click();
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(5));

		WebElement promoCodeMessage = d.findElement(By.cssSelector("span.promoInfo"));

		wait.until(ExpectedConditions.visibilityOf(promoCodeMessage));
		String couponMeassage = promoCodeMessage.getText();
		System.out.println(couponMeassage);

	}

	public static void addIteam(WebDriver d, String[] veggiesToadd) {
		int j = 0;
		List<WebElement> veggieName = d.findElements(By.xpath("//div[@class='product']//h4[@class='product-name']"));

		for (int i = 0; i < veggieName.size(); i++) {
			String[] indiVeggie = veggieName.get(i).getText().split("-");
			String updatedIndiveggies = indiVeggie[0].trim(); // cucu

			List toBytheVeggie = Arrays.asList(veggiesToadd);
			// beforing trimming //Cucumber Cucumber -1Kg

			if (toBytheVeggie.contains(updatedIndiveggies)) {
				j++; // 1
				List<WebElement> addToCart = d.findElements(By.xpath("//div[@class='product-action']/button"));
				addToCart.get(i).click();
				// j++; //1
				if (j == veggiesToadd.length) {
					break;
				}

			}

		}
		System.out.println("done with the code");
	}

}
