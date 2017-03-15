package tab;

import java.util.List;

public abstract class ColumnTab<T> extends Tab<T> {
	private List<T> columns;

	public ColumnTab() {
	}

	public ColumnTab(List<T> columns) {
		this.columns = columns;
	}

	@Override
	public Boolean write() {
		return null;
	}

	@Override
	public Boolean read() {
		return null;
	}

	public List<T> getColumns() {
		return columns;
	}

	public void setColumns(List<T> columns) {
		this.columns = columns;
	}
}
