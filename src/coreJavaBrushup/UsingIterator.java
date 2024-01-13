package coreJavaBrushup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UsingIterator {
	public static void main(String[] args) {
		
		List l=new ArrayList();
		l.add(1);
		l.add(2);
		
		/*
		 * for(int i=0;i<l.size();i++) { System.out.println(l.get(i)); }
		 */
		
		Iterator i=l.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}

}
