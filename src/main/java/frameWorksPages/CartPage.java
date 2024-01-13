package frameWorksPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.Reusablemethods;

public class CartPage extends Reusablemethods {
	WebDriver d;
	
	public CartPage(WebDriver d) {
		super(d);
		this.d=d;
		
		PageFactory.initElements( d,this);
		
		
	}
	//List<WebElement> cartProducts = d.findElements(By.xpath("//div[@class='cartSection']/h3"));
	@FindBy(xpath = "//div[@class='cartSection']/h3")
	List<WebElement> cartProducts;
	
//WebElement checkOut=d.findElement(By.xpath("//li[@class='totalRow']/button[text()='Checkout']"));
	@FindBy(xpath = "//li[@class='totalRow']/button[text()='Checkout']")
	WebElement checkOut;
	
	
	public boolean verifyIfproductisPresen(String productName) {
		boolean match=cartProducts.stream().anyMatch(product->product.getText().
				  equalsIgnoreCase(productName));
		return match;
		
	}
	
	public CheckOutPage goToCheckOut() {
		checkOut.click();
		
		return new CheckOutPage(d);
		
	}
	
	

}
