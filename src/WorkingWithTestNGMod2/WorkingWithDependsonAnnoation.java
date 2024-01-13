package WorkingWithTestNGMod2;

import org.testng.annotations.Test;

public class WorkingWithDependsonAnnoation {
	
	@Test
	
	public void zserName() {
		System.out.println("this is a username filed ");
	}
	@Test
	public void password() {
		System.out.println("the password is entered ");
	}
	
	@Test(dependsOnMethods = {"zserName","password"})
	
	public void login() {
		System.out.println("Username and Password requires a username for th login ");
	}

}
