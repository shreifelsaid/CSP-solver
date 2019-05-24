package project2;

public class SmallerThanConstraint implements Constraint{

	@Override
	public String toString() {
		return "[" + a.var  + " + "+ time + " <= " + b.var + "]" + System.lineSeparator();
	}

	Variable a;
	Variable b;
	int time;
	public SmallerThanConstraint(int time ,Variable a, Variable b) {
		this.time = time;
		this.a = a;
		this.b = b;
	}

	@Override
	public boolean satisfiedBy(Assignment Assign) {
		Object aa = Assign.getAssignment(a);
		Object bb = Assign.getAssignment(b);
		boolean nullA = (aa == null);
		boolean nullB = (bb == null);
		if(nullA || nullB) {
			return true;
		}
		int firstTime = (int)aa;
		int secondTime =(int)bb;
		boolean result = (firstTime + time) <= (secondTime);
		return result;
		
	}

}
