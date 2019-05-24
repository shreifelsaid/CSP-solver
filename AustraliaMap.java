package project2;

import java.util.ArrayList;
import java.util.Date;

public class AustraliaMap extends CSP {

	public AustraliaMap() {
		this.variables = new ArrayList<Variable>();
		String r = "Red";
		String g = "Green";
		String b = "Blue";
		ArrayList<Object> rgb = new ArrayList<Object>();
		rgb.add(r);
		rgb.add(g);
		rgb.add(b);
		
		Domain rgbDomain = new Domain(rgb);
		ArrayList<Domain> domains = new ArrayList<Domain>();
		domains.add(rgbDomain);
		this.domains = domains;
		//code credit goes to Prof. Ferguson
		Variable WA = new Variable("WA", domains.get(0));
		this.variables.add(WA);
		Variable NT = new Variable("NT", domains.get(0));
		this.variables.add(NT);
		Variable Q = new Variable("Q", domains.get(0));
		this.variables.add(Q);
		Variable NSW = new Variable("NSW", domains.get(0));
		this.variables.add(NSW);
		Variable V = new Variable("V", domains.get(0));
		this.variables.add(V);
		Variable SA = new Variable("SA", domains.get(0));
		this.variables.add(SA);
		Variable T = new Variable("T", domains.get(0));
		this.variables.add(T);
		this.constraints = new ArrayList<Constraint>();
		this.constraints.add(new NotEqualConstraint(SA, WA));
		this.constraints.add(new NotEqualConstraint(SA, NT));
		this.constraints.add(new NotEqualConstraint(SA, Q));
		this.constraints.add(new NotEqualConstraint(SA, NSW));
		this.constraints.add(new NotEqualConstraint(SA, V));
		this.constraints.add(new NotEqualConstraint(WA, NT));
		this.constraints.add(new NotEqualConstraint(NT, Q));
		this.constraints.add(new NotEqualConstraint(Q, NSW));
		this.constraints.add(new NotEqualConstraint(NSW, V));

		
	}
	public static void australiaMapTester() {
		System.out.println("Australia Map Coloring Problem (AIMA 6.1.1)");
		CSP csp = new AustraliaMap();
		System.out.println(csp);
		System.out.println("Backtracking search solver");
		Solver solver = new Solver();
		long start = new Date().getTime();
		Assignment result = solver.solve(csp);
		long end = new Date().getTime();
		System.out.format("time: %.3f secs\n", (end-start)/1000.0);
		System.out.println("Assignment of Colors to Regions:" +System.lineSeparator() + result);
	}
}


