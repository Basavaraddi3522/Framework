package coreJavaBrushup;

public class STring {
	public static void main(String[] args) {
		
		String s="sachin bijawad hjia";
		// splitting 
//		String [] a=s.split(" ");
//		for(int i=0;i<a.length;i++) {
//			System.out.println(a[i]);
//		}
		
		//spplitting and trimming the white space
		
//		String[] arr=s.split("bijawad");
//		
//		for(int i=0;i<arr.length;i++) {
//			System.out.println(arr[i].trim());
//		}
		
		//fecthing the character by character
		
//		for(int i=0;i<s.length();i++) {
//			  System.out.println(s.charAt(i));
//		}
		
		//fect character by character in reverse
		for(int i=s.length()-1;i>=0;i--) {
			System.out.println(s.charAt(i));
			
		}
	}

}
