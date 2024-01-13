package frameWorksPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.Reusablemethods;

public class MyOrdersPage extends Reusablemethods {
	WebDriver d;

	public MyOrdersPage(WebDriver d) {
		super(d);
		this.d=d;
		// TODO Auto-generated constructor stub
		PageFactory.initElements( d,this);
	}
	@FindBy(xpath = "//tr/td[2]")
	List<WebElement> productsName;
	
	public boolean verifyproductName(String productOrdered) {
		boolean match=productsName.stream().anyMatch(list->list.getText().equalsIgnoreCase(productOrdered));
		return match;
		
	}

}
