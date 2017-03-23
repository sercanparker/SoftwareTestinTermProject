package tab;

import java.util.List;

/**
 * This class was created to represent that each row on Tab is an object.
 *   
 */
public abstract class RowTab<T> extends Tab {

	protected  List<T> rows;


	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
