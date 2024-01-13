package testNgParameterizationInXML;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {
	@Parameters({"Url"})   // parameter which is providd in xml  only can run through .xml it cannot be executed in class level
	@Test()
	
	public void loan(String url) {
		System.out.println("This is the loan section");
		System.out.println(url);
	}

	
	@Test
	
	public void goldLoan() {
		System.out.println("this is gold load");
	}
	
	
}
