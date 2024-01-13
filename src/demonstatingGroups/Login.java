package demonstatingGroups;

import org.testng.annotations.Test;

public class Login {
	@Test(groups = {"smoke"})
	public void LTC01() {
		System.out.println(" this is LTC01");
	}
	
	@Test(groups = {"smoke"})
	public void ATC02() {
		System.out.println("this is LTC02");
	}

}
