package tesNg_DataProviderConcept;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HowtoParameterizeUsingDataproviderAnnoation {

	//4. call in the @Test annotation using the method declared in @Dataprovider 
	@Test(dataProvider = "getTheData")
	//5. Catch the number of the data comming in @Test methods

	public void implementingMethod(String name,String password) {
		System.out.println(name);
		System.out.println(password);

	}

	// using dataprovide annoation
	@DataProvider
	public Object[][] getTheData() {
		
		// 1. declaring the multidimensional Object array
		
		Object[][] object=new Object[2][2]; // 2 rows 2 coloum
		//2. Initilizaion
		//1st set of data
				object[0][0]="first user";
		object[0][1]="firstPassword";
		// 2nd set of data
				object[1][0]="SecondUser";
						object[1][1]="secondPassword";
						
		//3. Return the data
						return object;
								
		        
	}

}
