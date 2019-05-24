package project2;

public class Variable {

	public String var;
	public Domain correspondingDomain;

	@Override
	public String toString() {
		return "Variable :" + var +System.lineSeparator();
	}


	public Variable(String var, Domain correspondingDomain) {
		this.var = var;
		this.correspondingDomain = correspondingDomain;
	}

	public Domain getCorrespondingDomain() {
		return correspondingDomain;
	}

	public void setCorrespondingDomain(Domain correspondingDomain) {
		this.correspondingDomain = correspondingDomain;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Variable other = (Variable) obj;
		if (var == null) {
			if (other.var != null)
				return false;
		} else if (!var.equals(other.var))
			return false;
		return true;
	}




	
	
}
