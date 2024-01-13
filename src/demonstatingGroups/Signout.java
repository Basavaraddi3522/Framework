package demonstatingGroups;

import org.testng.annotations.Test;

public class Signout {
	
	@Test(groups = {"smoke"})
	public void STC01() {
		System.out.println("This is STC01");
	}

}
