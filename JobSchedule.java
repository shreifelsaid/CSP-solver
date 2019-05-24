package project2;

import java.util.ArrayList;
import java.util.Date;

public class JobSchedule extends CSP{
	
	public JobSchedule() {
		this.variables = new ArrayList<Variable>();
	
		ArrayList<Object> times = new ArrayList<Object>();
		for(int i = 1; i < 28; i++) {
			times.add(i);
		}
		
		Domain timesDomain = new Domain(times);
		ArrayList<Domain> domains = new ArrayList<Domain>();
		domains.add(timesDomain);
		this.domains = domains;
		//code credit goes to Prof. Ferguson
		Variable AxleF = new Variable("AxleF", domains.get(0));
		this.variables.add(AxleF);
		Variable AxleB = new Variable("AxleB", domains.get(0));
		this.variables.add(AxleB);
		Variable WheelRF = new Variable("WheelRF", domains.get(0));
		this.variables.add(WheelRF);
		Variable WheelLF = new Variable("WheelLF", domains.get(0));
		this.variables.add(WheelLF);
		Variable WheelRB = new Variable("WheelRB", domains.get(0));
		this.variables.add(WheelRB);
		Variable WheelLB = new Variable("WheelLB", domains.get(0));
		this.variables.add(WheelLB);
		Variable NutsRF = new Variable("NutsRF", domains.get(0));
		this.variables.add(NutsRF);
		Variable NutsLF = new Variable("NutsLF", domains.get(0));
		this.variables.add(NutsLF);
		Variable NutsRB = new Variable("NutsRB", domains.get(0));
		this.variables.add(NutsRB);
		Variable NutsLB = new Variable("NutsLB", domains.get(0));
		this.variables.add(NutsLB);
		Variable CapRF = new Variable("CapRF", domains.get(0));
		this.variables.add(CapRF);	
		Variable CapLF = new Variable("CapLF", domains.get(0));
		this.variables.add(CapLF);
		Variable CapRB = new Variable("CapRB", domains.get(0));
		this.variables.add(CapRB);
		Variable CapLB = new Variable("CapLB", domains.get(0));
		this.variables.add(CapLB);
		Variable Inspect = new Variable("Inspect", domains.get(0));
		this.variables.add(Inspect);
		this.constraints = new ArrayList<Constraint>();
		this.constraints.add(new SmallerThanConstraint(10,AxleF, WheelRF));
		this.constraints.add(new SmallerThanConstraint(10,AxleB,WheelRB));
		this.constraints.add(new SmallerThanConstraint(10,AxleF,WheelLF));
		this.constraints.add(new SmallerThanConstraint(10,AxleB,WheelLB));
		this.constraints.add(new SmallerThanConstraint(1,WheelRF, NutsRF));
		this.constraints.add(new SmallerThanConstraint(1,WheelLF, NutsLF));
		this.constraints.add(new SmallerThanConstraint(1,WheelRB, NutsRB));
		this.constraints.add(new SmallerThanConstraint(1,WheelLB, NutsLB));
		this.constraints.add(new SmallerThanConstraint(1,WheelRF, NutsRF));
		this.constraints.add(new SmallerThanConstraint(2,NutsRF, CapRF));
		this.constraints.add(new SmallerThanConstraint(2,NutsLF, CapLF));
		this.constraints.add(new SmallerThanConstraint(2,NutsRB, CapRB));
		this.constraints.add(new SmallerThanConstraint(2,NutsLB, CapLB));
		this.constraints.add(new DisjuctiveConstraint(10,AxleF, AxleB));
		this.constraints.add(new SmallerThanConstraint(3,AxleF, Inspect ));
		this.constraints.add(new SmallerThanConstraint(3,AxleB, Inspect ));
		this.constraints.add(new SmallerThanConstraint(3,WheelRF, Inspect ));
		this.constraints.add(new SmallerThanConstraint(3,WheelLF, Inspect ));
		this.constraints.add(new SmallerThanConstraint(3,WheelRB, Inspect ));
		this.constraints.add(new SmallerThanConstraint(3,WheelLB, Inspect ));
		this.constraints.add(new SmallerThanConstraint(3,NutsRF, Inspect ));
		this.constraints.add(new SmallerThanConstraint(3,NutsLF, Inspect ));
		this.constraints.add(new SmallerThanConstraint(3,NutsRB, Inspect ));
		this.constraints.add(new SmallerThanConstraint(3,NutsLB, Inspect ));
		this.constraints.add(new SmallerThanConstraint(3,CapRF, Inspect ));
		this.constraints.add(new SmallerThanConstraint(3,CapLF, Inspect ));
		this.constraints.add(new SmallerThanConstraint(3,CapRB, Inspect ));
		this.constraints.add(new SmallerThanConstraint(3,CapLB, Inspect ));

		
	}
	
	public static void jobTester() {
		System.out.println("Job Schedule Problem");
		CSP csp = new JobSchedule();
		System.out.println(csp);
		System.out.println("Backtracking search solver");
		Solver solver = new Solver();
		long start = new Date().getTime();
		Assignment result = solver.solve(csp);
		long end = new Date().getTime();
		System.out.format("time: %.3f secs\n", (end-start)/1000.0);
		System.out.println("result=" + System.lineSeparator() + result);
	}

}
