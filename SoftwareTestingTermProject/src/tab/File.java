package tab;

import java.util.List;

public class File<T> {

	private String path;
	private List<Tab<T>> tabs;

	public File() {

	}

	public File(String path, List<Tab<T>> tabs) {
		this.path = path;
		this.setTabs(tabs);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Tab<T>> getTabs() {
		return tabs;
	}

	public void setTabs(List<Tab<T>> tabs) {
		this.tabs = tabs;
	}

}
