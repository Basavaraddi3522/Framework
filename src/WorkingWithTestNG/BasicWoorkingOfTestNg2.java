package WorkingWithTestNG;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BasicWoorkingOfTestNg2 {
	@Test
	public void Tc003() {
		System.out.println("Test case three");
	}
	@BeforeSuite   
	// this is for suite level in xml irrespective of class it is there It will execute firs
	public void beforeSuite() {
		System.out.println("this should execute before the execution of any method  ");
	}

}
