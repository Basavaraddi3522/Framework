
package miscellaneousTopicFromCourse;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StoringthereturnedvalueInlistBycreatingIt {
	
	@Test
	
	public void usingCollector() {
		
		List<String> collectedNewData=Stream.of("sachin","raju","ravi").filter(s->s.length()>4).collect(Collectors.toList());
		collectedNewData.forEach(d->System.out.println(d));
	}

}
