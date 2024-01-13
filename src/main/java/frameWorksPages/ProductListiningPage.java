package frameWorksPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import reusableComponents.Reusablemethods;

public class ProductListiningPage extends Reusablemethods {
	WebDriver d;
	
	public ProductListiningPage(WebDriver d) {
		// TODO Auto-generated constructor stub
		super(d);
		this.d=d;
		PageFactory.initElements(d,this);
		
	}
	
	//List<WebElement> element = d.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> element;
	
	By products=By.cssSelector(".mb-3");
	By productToAdd=By.cssSelector(".card-body button:last-of-type");
	@FindBy(id="toast-container")
	WebElement toasterMessge;
	
//	List<WebElement> element = d.findElements(By.cssSelector(".mb-3"));
//
//	WebElement eleText = element.stream()
//			.filter(elemen -> elemen.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst()
//			.orElse(null);
//	eleText.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
	public List<WebElement> getproductList() {
		waittillVisibility(products);
		
		return element;
		
	}
	public WebElement getProductByName(String productName) {
		
		  WebElement eleText = getproductList().stream() .filter(elemen ->
		  elemen.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(
		  productName)).findFirst() .orElse(null);
		  return eleText;
		 	}
	
	//eleText.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
	public void addtheproductTocart(String productName) {
		WebElement pro=getProductByName(productName);
		pro.findElement(productToAdd).click();
		waitTillInvisibility(toasterMessge);
	}
	
}
