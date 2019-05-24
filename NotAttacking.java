package project2;

public class NotAttacking implements Constraint{

	Variable a;
	Variable b;
	
	public NotAttacking(Variable a, Variable b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	//returns true when they are not equals
	public boolean satisfiedBy(Assignment Assign) {
		Object aa = Assign.getAssignment(a);
		Object bb = Assign.getAssignment(b);
		
		boolean nullA = (aa == null);
		boolean nullB = (bb == null);
		if(nullA || nullB) {
			return true;
		}
		//we look through the assignment, seeing if variable a's value is equal to variable b's value, if it is so, we return true, otherwise false;
		int firstCol = (int)Assign.getAssignment(a);
		int secondCol = (int)Assign.getAssignment(b);
		int firstRow = Integer.parseInt(a.getVar());
		int secondRow = Integer.parseInt(b.getVar());
		int Cols = Math.abs(firstCol-secondCol); //differnce of columns
		int Rows = Math.abs(firstRow-secondRow); //differnece of rows
		if(Cols == 0) {
			return false;
		}
		
		if(!(Cols==Rows)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	//credit goes for professor Ferguson for supplying sample code that helped with the layout and construction of classes.

	@Override
	public String toString() {
		int firstRow = Integer.parseInt(a.getVar());
		int secondRow = Integer.parseInt(b.getVar());
		return "The queen at row: "+firstRow+" is not attacking the queen at row: "+secondRow+System.lineSeparator();
	}
	


}
