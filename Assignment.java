package project2;

import java.util.ArrayList;
import java.util.HashMap;

public class Assignment {
	HashMap<Variable, Object> assignment;
	
	public Assignment(HashMap<Variable, Object> assignment) {
		this.assignment = assignment;
	}

	public Assignment() {
		assignment = new HashMap<Variable, Object>();
	}

	public Object getAssignment(Variable x) {
		return assignment.get(x);
	}
	

	public void putAssignment(Variable x, Object o) {
		//assure that the map has no duplicates
		assignment.put(x, o);
	}
	public void removeAssignment(Variable x, Object o) {
		//assure that the map has no duplicates

		assignment.remove(x);
	}
	public boolean inConsistent(ArrayList<Constraint> c) {
		//loops through the constraint array and checks if the 
		//assignment has any inconsistency, returns true if the assignment is inconsistent, false otherwise.
		for(Constraint x : c) {
			if(!(x.satisfiedBy(this))) {
				return true;
			}
		}
		return false;
	}
	public boolean complete(ArrayList<Variable> v) {
		//we loop through the list of variables, seeing if the map has an assignment for each
		//if it doesn't at any point, we return false, otherwise true.

		if (v == null) {
			return false;
		}
		for(Variable x : v) {
			if(!assignment.containsKey(x)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		String construction = "";
		for(Variable v : this.assignment.keySet()) {
			String varName = v.getVar();
			String value = assignment.get(v).toString();
			construction += varName + "        " + value + System.lineSeparator();
			
		}
		return construction;
	}

	public boolean correctSolution(ArrayList<Variable> v, ArrayList<Constraint> c) {
		//a correct solution is a complete consistent assignment 
		return ((complete(v))&&(!inConsistent(c)));
	}
	public boolean hasElement(Variable key) {
		return assignment.containsKey(key);
	}
} 
