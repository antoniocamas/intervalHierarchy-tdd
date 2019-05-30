package tdd.intervalHierarchy;

public class OpenIntervalBuilder {

	private double min;
	
	private double max;
	
	OpenIntervalBuilder(){
		this.min = 0;
		this.max = 1;
	}
	
	OpenIntervalBuilder min(double min) {
		this.min = min;
		return this;
	}

	OpenIntervalBuilder max(double max) {
		this.max = max;
		return this;
	}
	
	OpenInterval build() {
		assert min <= max;
		return new OpenInterval(min, max);
	}

	
}
