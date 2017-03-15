package tab;

import java.util.List;

public abstract class RowTab<T> extends Tab<T> {

	private List<Tab<T>> rows;

	public RowTab() {

	}

	public RowTab(List<Tab<T>> rows) {
		this.rows = rows;
	}

	@Override
	public Boolean write() {
		return null;
	}

	@Override
	public Boolean read() {
		return null;
	}

	public List<Tab<T>> getRows() {
		return rows;
	}

	public void setRows(List<Tab<T>> rows) {
		this.rows = rows;
	}

}
