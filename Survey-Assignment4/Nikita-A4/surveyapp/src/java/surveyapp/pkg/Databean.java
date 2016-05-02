// The DataBean has two attributes to hold the mean and standard deviation. 
package surveyapp.pkg;

public class Databean {
	private double mean = 0.0;
 	 private double standarddev = 0.0;
	public double getMean() {
		return mean;
	}
	public void setMean(double mean) {
		this.mean = mean;
	}
	public double getStandarddev() {
		return standarddev;
	}
	public void setStandarddev(double standarddev) {
		this.standarddev = standarddev;
	}

}
