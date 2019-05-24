package project2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class nQueens extends CSP {
	//needs to take input from user 

	public nQueens(int nQueens) {
		this.variables = new ArrayList<Variable>();
		ArrayList<Object> positions = new ArrayList<Object>();
		for(int i = 1; i < nQueens+1; i++) {
			positions.add(i);
		}

		Domain positionsDomain = new Domain(positions);
		ArrayList<Domain> domains = new ArrayList<Domain>();
		domains.add(positionsDomain);
		this.domains = domains;
		for(int i = 1; i < nQueens+1; i++) {
			String name = Integer.toString(i);
			Variable row = new Variable(name, domains.get(0));
			this.variables.add(row);
		}
		this.constraints = new ArrayList<Constraint>();

		//adding constraints
		//no queens on the same column
		for(int i = 0; i < this.variables.size(); i++) {
			Variable var1 = this.variables.get(i);

			for(int j = 0 ; j < this.variables.size(); j++) {
				if(i != j) {
					Variable var2 = this.variables.get(j);
					this.constraints.add(new NotAttacking(var1,var2));

				}

			}
		}
	}

	public static void nQueensTester() {
		System.out.println("nQueens Problem");
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the number of Queens:");
		int nQ = scan.nextInt();
		CSP csp = new nQueens(nQ);
		System.out.println("The variables here are row [numbers] representing rows with queens");
		System.out.println("The domain is the set of possible column numbers where a queen would be on a row ");

		System.out.println(csp);
		System.out.println("Backtracking search solver");
		Solver solver = new Solver();
		long start = new Date().getTime();
		Assignment result = solver.solve(csp);
		long end = new Date().getTime();
		System.out.format("time: %.3f secs\n", (end-start)/1000.0);
		System.out.println("result=" + System.lineSeparator() + result);
		printChessBoard(nQ,result);
		
	}

	public static void printChessBoard(int n, Assignment a) {
		char [][] board = new char[n][n];
		if(n < 4) {
			System.out.println("This problem has no solution ");
			return;
		}
		System.out.println("Here is it printed in a human friendly manner");

		for(int i = 0; i< n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j]= '-';
			}
		}
		for(Variable v : a.assignment.keySet()) {
			String varName = v.getVar();
			int x = Integer.parseInt(varName);
			int y = (int)a.assignment.get(v);
			board[x-1][y-1]= 'Q';

		}
		
		for(int i = 0; i< n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(" "+ board[i][j] + " ");
				
			}
			System.out.println();
		}
	}
	
	

}
