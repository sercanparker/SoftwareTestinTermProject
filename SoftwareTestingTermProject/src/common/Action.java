package common;

public class Action<T> extends AbstractTestCase {
	private EncryptionType encryptionType;
	private T parameter;

	public Action() {

	}

	public Action(EncryptionType encryptionType, T parameter) {
		this.encryptionType = encryptionType;
		this.parameter = parameter;
	}

	public EncryptionType getEncryptionType() {
		return encryptionType;
	}

	public void setEncryptionType(EncryptionType encryptionType) {
		this.encryptionType = encryptionType;
	}

	public T getParameter() {
		return parameter;
	}

	public void setParameter(T parameter) {
		this.parameter = parameter;
	}

}
