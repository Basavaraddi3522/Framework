package reusableComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameWorksPages.CartPage;
import frameWorksPages.MyOrdersPage;

public class Reusablemethods {
	WebDriver d;
	
	

	public Reusablemethods(WebDriver d) {
		// TODO Auto-generated constructor stub
		this.d=d;
		PageFactory.initElements( d,this);
	}
	@FindBy(xpath = " //button[contains(text(),' Cart ')]")
	WebElement cart;
	@FindBy(xpath = "//button[contains(text(),' Sign Out ')]")
	WebElement signOut;
	@FindBy(xpath = "//button[contains(text(),' ORDERS')]")
	WebElement order;
	
	public CartPage gotoCart() {
		cart.click();
		// since pon clicking the go to cart it is navigation 
		return new CartPage(d);
		
	}
	public void SingOut(int maxtry) {
		
		int trycount=0;
				while (trycount < maxtry) {
					try {
						signOut.click();;
					}
					catch (Exception e) {
						trycount++;
						// TODO: handle exception
					}
				}
	}
	
	public MyOrdersPage gotoMyorders() {
		order.click();
		return new MyOrdersPage(d);
	}

	public void waittillVisibility(By locatorStertegy){
	WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(locatorStertegy));
	}
	
	public void waitTillVisibilityByElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
//	wait.until(ExpectedConditions.invisibilityOf(toasterMessage));
	public void waitTillInvisibility(WebElement elementIS) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(elementIS));
		
	}
	
}
