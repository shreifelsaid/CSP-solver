package project2;

import java.util.ArrayList;

public class Domain {
	
	ArrayList<Object> domainValues;

	@Override
	public String toString() {
		return "Domain [domainValues=" + domainValues + "]";
	}

	public Domain(ArrayList<Object> domainValues) {
		this.domainValues = domainValues;
	}

	public ArrayList<Object> getDomainValues() {
		return domainValues;
	}
	public Object getIndex(int index) {
		return domainValues.get(index);
	}
	public void setDomainValues(ArrayList<Object> domainValues) {
		this.domainValues = domainValues;
	}
	public void length() {
		domainValues.size();
	}
	
	
}
