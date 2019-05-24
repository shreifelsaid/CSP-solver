package project2;

public interface Constraint {

	//types of constraints: not equals, unrary
	//needs one method to check if the constraint is satisfied, any more detail is outlined in the specific constraint class
	public boolean satisfiedBy(Assignment a);
}
