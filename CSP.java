package project2;

import java.util.ArrayList;
import java.util.Map;

public class CSP {
	
	//CSP implementation is a set of variables
	//set of constraints
	//set of domains
	//and some assignment of domains to variables.
	
	
	@Override
	public String toString() {
		return "CSP variables=" + System.lineSeparator()+ variables + System.lineSeparator() +" constraints=" + System.lineSeparator()+ constraints +System.lineSeparator()+ " domains=" +System.lineSeparator()+ domains ;
	}
	public ArrayList<Variable> variables;
	public ArrayList<Constraint> constraints;
	public ArrayList<Domain> domains;
	public Assignment assignment;
	//overloaded constructor 
	public CSP(ArrayList<Variable> variables, ArrayList<Constraint> constraints, ArrayList<Domain> domains,
			Assignment assignment) {
		super();
		this.variables = variables;
		this.constraints = constraints;
		this.domains = domains;
		this.assignment = assignment;
	}
	public CSP() {
		variables = new ArrayList<Variable>();
		constraints = new ArrayList<Constraint>();
		domains = new ArrayList<Domain>();
		assignment = new Assignment();

	}
	//getters and setters
	public ArrayList<Variable> getVariables() {
		return variables;
	}
	public void setVariables(ArrayList<Variable> variables) {
		this.variables = variables;
	}
	public ArrayList<Constraint> getConstraints() {
		return constraints;
	}
	public void setConstraints(ArrayList<Constraint> constraints) {
		this.constraints = constraints;
	}
	public ArrayList<Domain> getDomains() {
		return domains;
	}
	public void setDomains(ArrayList<Domain> domains) {
		this.domains = domains;
	}
	public Assignment getAssignment() {
		return assignment;
	}
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	
	

}
