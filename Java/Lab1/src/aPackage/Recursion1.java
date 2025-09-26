package aPackage;

public class Recursion1 {
	public static void main(String[] args) {
		System.out.println(f(10));
	}

	public static int f(int n) {

		int result = 0;
		if (n < 4)
			result = 1;
		else
			result = f(n / 2) + f(n / 4);
		return result;

	}
}
