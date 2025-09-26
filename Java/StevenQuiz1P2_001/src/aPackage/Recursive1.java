package aPackage;

public class Recursive1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {31,12,98,0,42,-69};
		System.out.println(findingMin(arr,arr.length-1));
	}

	private static int findingMin(int[] arr, int i) {
		// TODO Auto-generated method stub
		if (i == 0) {
			return arr[i];
		}
		int currMin = findingMin(arr, i-1);
		return (arr[i]>currMin ? currMin : arr[i]);
	}

}
