package frameWorksPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.Reusablemethods;

public class LandingPage extends Reusablemethods   {
	WebDriver d;

	public LandingPage(WebDriver d) {
		super(d);

		this.d = d;
		PageFactory.initElements(d, this);
	}

	// WebElement userName = d.findElement(By.id("userEmail"));

	@FindBy(id = "userEmail")
	WebElement userName;
	@FindBy(id = "userPassword")
	WebElement password;
	@FindBy(id = "login")
	WebElement loginButon;
	@FindBy(xpath = "//div[contains(@class,'toast-message')]")
	WebElement errorMessage;
	

	public ProductListiningPage loginActions(String un, String pwd) {
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginButon.click();
		return new ProductListiningPage(d);
	}

	public void navigateToUrl() {
		d.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage() {
		waitTillVisibilityByElement(errorMessage);
		return errorMessage.getText();
	}

}
