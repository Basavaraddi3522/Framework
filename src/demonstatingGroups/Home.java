package demonstatingGroups;

import org.testng.annotations.Test;

public class Home {

	@Test(groups = {"smoke"})
	
	public void TC100() {
		System.out.println("thi si TC1");
	}
	
	@Test
	public void TC2() {
		System.out.println("this is TC2");
	}
}
