package coreJavaBrushup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertingArrayToList {
	
	public static void main(String[] args) {
		// converting string of array to list
		String [] array= {"1","2","3","4"};
		List<String> newar=Arrays.asList(array);
		for(int i=0;i<newar.size();i++) {
			System.out.println(newar.get(i));
		}
		
		//Converting the integer array to list
		
		
		int[] values= {1,2,3,7};
		List<Integer> newint=Arrays.stream(values)        // IntStream
                .boxed()          // Stream<Integer>
                .collect(Collectors.toList());
		System.out.println(newint);
		
		
		// one more way to add integer array to list
		
		int[] u= {1,5,7};
		
		List<Integer> b=new ArrayList<Integer>();
		
		for(int y:u) {
			b.add(y);
		}
		System.out.println(u);
		
		
	}

}
