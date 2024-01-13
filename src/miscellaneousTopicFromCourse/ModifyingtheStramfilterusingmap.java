package miscellaneousTopicFromCourse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class ModifyingtheStramfilterusingmap {
	@Test
	
	public void UsingMap() {
		
		Stream.of("sachin","ravi","abc").filter(s->s.length()>5).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Note: the reference variable which is assigned to filter ,map can be different or same
		
		// same code but without the condition
		
		Stream.of("sachin","ravi","abc").map(e->e.toUpperCase()).forEach(y->System.out.println(y));
		
		
	}
	
	@Test
	
	public void convertingArrayAndPerformanig() {
		
		// 1st : if array is given
		String[]arr= {"Ram","Jai"};
		
		List<String>convertedToList=Arrays.asList(arr);
		Stream<Object> h=convertedToList.stream().filter(j->j.length()>2).map(j->j.toUpperCase());
		h.forEach(s->System.out.println(s));
		
		// or same code can be optimized to
		
		convertedToList.stream().filter(j->j.length()>2).map(j->j.toUpperCase()).forEach(s->System.out.println(s));
	}

}
