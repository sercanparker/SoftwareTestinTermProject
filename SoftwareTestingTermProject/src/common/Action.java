package common;

public class Action<T> {
	/**
	 * Type of action PRINT,OPEN etc.*/
	private EActionType encryptionType;
	
	
	
	/**
	 *Answer of while action is active mode, which parameter are on fire ? */
	private T parameter;


	public Action(EActionType encryptionType, T parameter) {
		this.encryptionType = encryptionType;
		this.parameter = parameter;
	}

	public EActionType getEncryptionType() {
		return encryptionType;
	}

	public void setEncryptionType(EActionType encryptionType) {
		this.encryptionType = encryptionType;
	}

	public T getParameter() {
		return parameter;
	}

	public void setParameter(T parameter) {
		this.parameter = parameter;
	}

}
