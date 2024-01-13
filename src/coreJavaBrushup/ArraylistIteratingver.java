package coreJavaBrushup;

import java.util.ArrayList;
import java.util.ListIterator;

public class ArraylistIteratingver {
	public static void main(String[] args) {
		
		ArrayList a=new ArrayList();
		a.add("ass");
		a.add("ee");
		a.add("eeer");
		a.add("asse3");
		//using lambda Expression
		
//		a.forEach((e)->{
//			System.out.println(e);
//		});
		
		//Using Listiterator
//		
//	ListIterator i =a.listIterator();
//	while(i.hasNext()) {
//		System.out.println(i.next());
//	}
		
		//Using normal loop
		
//		for(int i=0;i<a.size();i++) {
//			System.out.println(a.get(i));
//		}
		
		
		//using Enhanced forLoop
		
		for(Object e:a) {
			System.out.println(e);
			
		}
	
	}

}
