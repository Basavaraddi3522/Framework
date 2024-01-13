package testNG_listeners;

import org.testng.annotations.Test;

public class C extends P {
	
	public C(int a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	@Test
	
	public void g() {
		P p=new P(2);
		System.out.println(p.m());
	}

}
