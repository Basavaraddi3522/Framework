package miscellaneousTopicFromCourse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConcatingUsingStream {
	@Test
	public void concat() {
		
//		Stream<String >name=Stream.of("Sachin","Ram");
//		
//		Stream<String>name2=Stream.of("abc");
//		
//		Stream<String>newName=Stream.concat( name.stream(), name2.stream());
		List<String>n=new ArrayList<String>();
		n.add("asas");
		List<String>n1=new ArrayList<String>();
		n1.add("abcd");
		
		Stream<String>newname=Stream.concat(n.stream(), n1.stream());
		// commenting the below code to check the match
		//newname.forEach(s->System.out.println(s));

// to find  anymatch in the both list 
		boolean falg=newname.anyMatch(s->s.equalsIgnoreCase("abcd"));
		Assert.assertTrue(falg);
		
		
		
		
		
	}
	

}
