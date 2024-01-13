package frameWorksPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.Reusablemethods;

public class ConfirmationPage extends Reusablemethods {
	WebDriver d;
	
	public ConfirmationPage(WebDriver d) {
		super(d);
		this.d=d;
		PageFactory.initElements( d,this);
		
	}
	
	@FindBy(xpath = "//h1[@class='hero-primary']")
	WebElement sucessmessage;
	
	
	public String verifySucessMessage() {
		 return sucessmessage.getText();
	}

}
