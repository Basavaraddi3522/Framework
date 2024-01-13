package WorkingWithTestNGMod2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondMduleTC01 {
	@AfterClass
	public void workingOnAfterClass() {
		System.out.println("this will execte After the all the methods in class but before the AfterSuit");
	}
	@Test
	public void m2Tco01() {
		System.out.println("SecondModule first script");
	}
	
	// working with before test: which will execute before a @Test
	
	@Test
	public void m2tco03() {
		System.out.println("M2tco03");
	}
	
	@AfterTest 
	public void workingAfterTest() {
		System.out.println("this should execute after the all the test but before AfterMethod only once");
	}
	@Test
	public void m2Tco02(){
		System.out.println("this is m2Tc002");
		
	}
	@BeforeTest
	public void workingOnBeforeTest() {
		System.out.println("Before test");
	}
	
	@AfterMethod
	
	public void afterMethod() {
		System.out.println("this should execute after the test but before the @AfterTest");
	}
	
	@AfterSuite
	public void workingAftersuite() {
		System.out.println("This is fter suite ");
	}
	@BeforeMethod
	public void workingBeforeMethod() {
		System.out.println("1st one to execute before the method or test in a class level");
	}

}
