package tab;

public abstract class Tab<T> {
	private String path;
	private String name;

	public Tab() {

	}

	public Tab(String path, String name) {
		this.path = path;
		this.name = name;
	}

	public abstract Boolean write();

	public abstract Boolean read();

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
