package tab;

import java.util.List;

/**
 * This class was created to represent that each column on Tab is an object.
 *   
 */
public abstract class ColumnTab<T> extends Tab {
	private List<T> columns;

	public ColumnTab() {
	}

	public ColumnTab(List<T> columns,String path,String name) {
		super(path,name);
		this.columns = columns;
	}

	public List<T> getColumns() {
		return columns;
	}

	public void setColumns(List<T> columns) {
		this.columns = columns;
	}
}
