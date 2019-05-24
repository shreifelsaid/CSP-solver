package project2;

import java.util.ArrayList;
import java.util.Map;

public class Solver {
	public Assignment solve(CSP csp){
		Assignment newMap = new Assignment();
		return backtrack(newMap,csp);
	}
	
	//we use the backtracking method psudocode in AIMA and in Lecture
	
	
//	function BACKTRACKING-SEARCH(csp) returns a solution, or failure
//	return BACKTRACK({ }, csp)
//	function BACKTRACK(assignment, csp) returns a solution, or failure
//	if assignment is complete then return assignment
//	var ← SELECT-UNASSIGNED-VARIABLE(csp)
//	for each value in ORDER-DOMAIN-VALUES(var , assignment, csp) do-------------------------
//	if value is consistent with assignment then
//	add {var = value} to assignment
//	inferences ← INFERENCE(csp, var , value)
//	if inferences = failure then
//	add inferences to assignment
//	result ← BACKTRACK(assignment, csp)
//	if result = failure then
//	return result
//	remove {var = value} and inferences from assignment
//	return failure

	public Assignment backtrack(Assignment a, CSP csp) {

	Assignment result = null;
		csp.setAssignment(a);
		ArrayList<Variable> vList = csp.getVariables();
		if(a.complete(vList)) {
			result = a;
		}
		else {
			Variable unAssVar = selectUnAssignedVariable(csp);
			Domain domainOfUnAssVar = orderDomainValues(csp, unAssVar);
			for(Object o : domainOfUnAssVar.domainValues) {
				//we set the assignment, and then test it
				//if a is consistent, fine, do nothing, else
				ArrayList<Constraint> cList = csp.getConstraints();
				a.putAssignment(unAssVar, o);
				csp.setAssignment(a);
				if(!(a.inConsistent(cList))) {
					result = backtrack(a, csp);
					if(result != null) {
						return result;
					}
				}
				a.removeAssignment(unAssVar, o);
				csp.setAssignment(a);

					
				}
			}
		return result;

		}
	
	private Domain orderDomainValues(CSP csp, Variable unAssVar) {
		return unAssVar.getCorrespondingDomain();
	}

	private Variable selectUnAssignedVariable(CSP csp) {
		Assignment a = csp.getAssignment();
		//loops through the array, returns the first variable that is unassigned a value;
		for(Variable v : csp.getVariables()) {
			if(!(a.hasElement(v))) {
				return v;
			}
		}
		System.out.println("couldn't find an unassigned var, we returned null");

		return null;
	}
	
}
