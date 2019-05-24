package project2;

public class NotEqualConstraint implements Constraint {

	@Override
	public String toString() {
		return "[" + a.var + " != " + b.var + "]" + System.lineSeparator();
	}

	Variable a;
	Variable b;
	
	public NotEqualConstraint(Variable a, Variable b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	//returns true when they are not equals
	public boolean satisfiedBy(Assignment Assign) {
		//we look through the assignment, seeing if variable a's value is equal to variable b's value, if it is so, we return true, otherwise false;
		Object aa = Assign.getAssignment(a);
		Object bb = Assign.getAssignment(b);
		boolean nullA = (aa == null);
		boolean nullB = (bb == null);
		if(nullA || nullB) {
			return true;
		}
		
		String a1 = aa.toString();
		String b1 = bb.toString();
	//	System.out.println(a.toString()+ " "+a1 + "!=" + b.toString() + " "+ b1);
		return (!(a1.equals(b1)));
	}
	//credit goes for professor Ferguson for supplying sample code that helped with the layout and construction of classes.
	

}
