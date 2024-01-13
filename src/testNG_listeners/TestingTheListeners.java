package testNG_listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestingTheListeners {
	
	@Test
	
	public void login() {
		System.out.println("Login test");
	}

	@Test
	public void home() {
		
		// intentionally failing 
		System.out.println("Home page");
		Assert.assertTrue(false);
	}
}
