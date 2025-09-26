package aPackage;

public class Recursive {

	public static void main(String[] args) {
		int arr[] = { 44, 23, 52, 11, 21 };
		System.out.println(simpleRecursion(arr, arr.length-1));
	}

	private static int simpleRecursion(int[] arr, int i) {
		if (i==0) {
			return arr[i];
		}
		int smallestSoFar = simpleRecursion(arr, i-1);
		return (arr[i] > smallestSoFar ? smallestSoFar : arr[i]);
		
	}
}
