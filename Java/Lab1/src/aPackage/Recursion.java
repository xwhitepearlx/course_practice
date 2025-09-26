package aPackage;

public class Recursion {

	public static void main(String[] args) {
		countDown(10);
	}
	public static void countDown (int n) {
		if (n==1) {
			System.out.println(n);
		}
		if (n>1) {
			countDown(n-1);
			System.out.println(n);		
			
		}
	}

}
