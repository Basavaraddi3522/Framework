package cucmberStrDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.frameworkDesign.SeleniumFrameWorkDesign.Testcomponents.BaseTest;

import frameWorksPages.CartPage;
import frameWorksPages.CheckOutPage;
import frameWorksPages.ConfirmationPage;
import frameWorksPages.LandingPage;
import frameWorksPages.ProductListiningPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ImplementationOfStepDefination extends BaseTest{
	public LandingPage l;
	public ProductListiningPage p;
	public CartPage c;
	public ConfirmationPage confirmation;
	
	@Given("I landed on Eommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException {
		l=launchApplicationFromBase();
		
	}
	
	
	@Given("^Login with userName(.+) and Password(.+)$")
	public void login_with_userName_and_Password(String userName,String Password) {
		 p = l.loginActions(userName, Password);
	}
	
	@When("^I add product(.+) and submit order$")
	public void i_add_product_and_submit_orders(String product) {

		List<WebElement> allproducs = p.getproductList();
		p.getProductByName(product);
		p.addtheproductTocart(product);
	}
	
	// And CheckOut<product> submit the order 
	@When("^CheckOut(.+product) submit the order $")
	public void checkout_product_submit_the_oder(String product) throws InterruptedException {
		 c = p.gotoCart();
		boolean matchIs = c.verifyIfproductisPresen(product);
		Assert.assertTrue(matchIs);
		CheckOutPage co = c.goToCheckOut();
		co.selectTheCounty("india");

		 confirmation = co.clickOnProceed(4);
	}
	
	// Then  "THANKYOU FOR THE ORDER." message is displayed on confirmtion page
	
	@Then(" {message} message is displayed on confirmtion page")
	public void message_verification_on_COnfirmationPage(String message) {

		String sucessMessge = confirmation.verifySucessMessage();

		Assert.assertTrue(sucessMessge.equalsIgnoreCase(message));
	}

}
