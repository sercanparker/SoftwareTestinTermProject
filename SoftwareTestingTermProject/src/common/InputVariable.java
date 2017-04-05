package common;

import java.util.List;

public class InputVariable<T> extends Parameter<T>{

	
	private List<EquivalenceClass> equivalenceClasses;
	
	public InputVariable(String variable, T value) {
		super(variable, value);
	}
	
	public List<EquivalenceClass> getEquivalenceClasses() {
		return equivalenceClasses;
	}
	
	public void setEquivalenceClasses(List<EquivalenceClass> equivalenceClasses) {
		this.equivalenceClasses = equivalenceClasses;
	}

}
