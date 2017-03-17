package tab;

import common.AbstractTestCase;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
/**
 * Class represent AbstractTestCase Tab for Excel file.
 * @see AbstractTestCase
 * */

public class AbstractTestCaseRowTab extends RowTab<AbstractTestCase> {
	
	
	/**
	 * Write each object of AbstractTestCase class on each rows in file
	 * */
	@Override
	public Boolean write() {
		throw new NotImplementedException();
	}

	/**
	 *Read from Decision Table Tab and prepare AbstractTestCase object */
	@Override
	public Boolean read() {
		throw new NotImplementedException();
	}
}
