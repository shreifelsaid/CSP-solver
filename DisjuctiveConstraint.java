package project2;

public class DisjuctiveConstraint implements Constraint {

	@Override
	public String toString() {
		return "[" + a.var  + " + "+ time + " <= " + b.var + "]" + " or "+"[" + b.var  + " + "+ time + " <= " + a.var + "]" + System.lineSeparator();
		}
	Variable a;
	Variable b;
	int time;
	public DisjuctiveConstraint(int time ,Variable a, Variable b) {
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
		boolean result1 = (secondTime + time) <= (firstTime);
		return result || result1;
		
	}
	

}
