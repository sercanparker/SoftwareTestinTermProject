package common;

/**
 * Super class for Input and Output
 * */
public abstract class Parameter<T> {
	/**
	 * Name of parameter
	 * example: side_A*/
	protected String name;
	/**
	 * Value of parameter
	 * example: side_A = 5*/
	protected T value;

	public Parameter(String variable, T value) {
		this.name = variable;
		this.value = value;
	}

	public String getVariable() {
		return name;
	}

	public void setVariable(String variable) {
		this.name = variable;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
