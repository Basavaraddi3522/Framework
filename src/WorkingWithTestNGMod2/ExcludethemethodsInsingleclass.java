package WorkingWithTestNGMod2;

import org.testng.annotations.Test;

public class ExcludethemethodsInsingleclass {
	@Test
	
	public void webLogin() {
		System.out.println("WebLogin ");
	}
	
	@Test
	public void MobileLogin() {
		System.out.println("Mobile login");
	}
	@Test
	public void ApiLogin() {
		System.out.println("API login");
	}

}
