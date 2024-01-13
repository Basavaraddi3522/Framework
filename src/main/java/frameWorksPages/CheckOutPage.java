package frameWorksPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import reusableComponents.Reusablemethods;

public class CheckOutPage extends Reusablemethods {
	WebDriver d;

	public CheckOutPage(WebDriver d) {
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']")
	WebElement allThecountryList;

	@FindBy(xpath = "(//button[@class='ta-item list-group-item ng-star-inserted'])[2]")
	WebElement desiredCountry;

	@FindBy(xpath = "//div[@class='actions']//a")
	WebElement placeOrder;

	public void selectTheCounty(String countryName) {
		country.sendKeys(countryName);
		JavascriptExecutor js=(JavascriptExecutor)d;
		js.executeScript("window.scrollBy(0,350);", "");
		
		waitTillVisibilityByElement(allThecountryList);
		
		Actions a = new Actions(d);
		/*
		 * WebElement desiredCountry = d .findElement(By.
		 * xpath("(//button[@class='ta-item list-group-item ng-star-inserted'])[2]"));
		 * a.moveToElement(desiredCountry).click().build().perform();
		 */
		a.sendKeys(desiredCountry, countryName).click().build().perform();

	}
	
	public ConfirmationPage clickOnProceed(int maxTries) throws InterruptedException {
		int tryCount = 0;

		while (tryCount < maxTries) {
			try {
			placeOrder.click();
				break; // If click is successful, exit the loop
			} catch (ElementClickInterceptedException e) {
				tryCount++;

				Thread.sleep(1000); // Wait for a moment before retrying
			}
			System.out.println(tryCount);
		}
		
		return new ConfirmationPage(d);
	}

}
