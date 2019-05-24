package project2;

import java.util.Scanner;

public class ProjectRun {
	public static void Run() {
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter your choice: ");
			System.out.println("1- Australia Map Problem");
			System.out.println("2- Job Scheduling Problem");
			System.out.println("3- n-Queens Problem");
			System.out.println("Enter 0 to quit");
			System.out.print("Your choice [1,2,3, or 0 to quit]:");
			int x = scan.nextInt();
			if(x == 1) {
				AustraliaMap.australiaMapTester();
			}
			else if(x == 2) {
				JobSchedule.jobTester();
			}
			else if(x == 3) {
				nQueens.nQueensTester();
			}
			else {
				System.out.println("GOOD BYE!");
				System.exit(0);
			}
		}
	}
	public static void main(String[] args) {
		Run();
	}
}

