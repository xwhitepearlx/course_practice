package aPackage;

import java.util.Scanner;

class HoursException extends Exception {
	public HoursException(String message) {
		super(message);
	}
}

public class Question2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] employeeID = { 525, 434, 132, 234, 977 };
		int[] hoursWorked = new int[employeeID.length];

		for (int i = 0; i < employeeID.length; i++) {
			while (true) {
				System.out.print("Enter work hours for Employee ID" + employeeID[i] + ": ");
				try {
					int hours = scanner.nextInt();
					if (hours < 0 || hours > 60) {
						throw new HoursException("Work hours must be between 0 and 60!");
					}
					hoursWorked[i] = hours;
					break;
				} catch (HoursException e) {
					System.out.println("Error: " + e.getMessage());
					scanner.nextLine();
				} catch (Exception e) {
					System.out.println("Error: Invalid input!");
					scanner.nextLine();
				}
			}
		}

		System.out.println("\nEmployee Hours Summary: ");
		for (int i = 0; i < employeeID.length; i++) {
			System.out.printf("Employee ID: %d%n", employeeID[i]);
			System.out.printf("Employee Hours: %d%n%n", hoursWorked[i]);
		}
		scanner.close();
	}
}
