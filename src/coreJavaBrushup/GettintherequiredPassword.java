package coreJavaBrushup;

public class GettintherequiredPassword {
	public static void main(String[] args) {
		String pass="Please use temporary password 'rahulshettyacademy' to Login.";
		
		String [] sp=pass.split("'");
		String []sp2=sp[1].split("'");
		for(int i=0;i<sp2.length;i++) {
			System.out.println(sp2[i]);
		}
	}

}
