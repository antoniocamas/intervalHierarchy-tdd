package tdd.intervalHierarchy;

public class EndPoint {

	protected double value;
			
	boolean open = false; 

	public EndPoint(double value, boolean open) {
		this.value = value;
		this.open = open;
	}
	
	public boolean isSmaller(double value) {
		if (this.open) {
			return this.value < value;
		}
		return this.value <= value;
	}
	
	public boolean isBigger(double value) {
		if (this.open) {
			return this.value > value;
		}
		return this.value >= value;
	}
	
	public boolean isEqual(EndPoint other) {
		return this.value == other.value;
	}
	
}
