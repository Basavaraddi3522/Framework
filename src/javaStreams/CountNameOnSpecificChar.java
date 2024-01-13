package javaStreams;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class CountNameOnSpecificChar {
	@Test
	
	public void mw() {
		ArrayList<String>names=new ArrayList<String>();
		names.add("asachi");
		names.add("bhi");
		names.add("anand");
		names.add("manj");
		
		//int count =0;
		//Normal code 
//		
//		for(int i=0;i<names.size();i++) {
//			String nameIS=names.get(i);
//			if(nameIS.startsWith("a")) {
//				count++;
//			}
//		}
//		System.out.println(count);
		
		//using strams
		long count=names.stream().filter(w->w.startsWith("a")).count();
		System.out.println(count);
		
		// craetion of lightweight 
		
		Stream.of("sachin","naveen","abc").filter(e->e.length()>5).forEach((s)->{
			System.out.println(s);
			
		});
		
		
		
		
	}

}
