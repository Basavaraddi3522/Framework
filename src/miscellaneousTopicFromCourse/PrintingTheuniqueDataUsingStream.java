package miscellaneousTopicFromCourse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class PrintingTheuniqueDataUsingStream {
	@Test
	
	public void usingDistinct() {
		// questio
		// print the unique data from array in sorted
		
		int[] a= {1,2,5,1,67,2,9};
		
		List<In> convetedone=Arrays.asList(a).stream().sorted().distinct().collect(Collectors.toList());
		convetedone.forEach(s->System.out.println(s));
		
		// this is printing the address need to check 
		
	}

}
