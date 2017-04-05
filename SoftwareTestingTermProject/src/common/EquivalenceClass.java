package common;

/**
 * This class created to show eq classes for inputs
 * to use Triangle and NextDate problems
 * */
public class EquivalenceClass {
	
	private int _minValue;
	private int _maxValue;
	
	public EquivalenceClass(int minValue, int maxValue){
		this._minValue = minValue;
		this._maxValue = maxValue;
	}
	
	public int get_maxValue() {
		return _maxValue;
	}
	
	public int get_minValue() {
		return _minValue;
	}

}
