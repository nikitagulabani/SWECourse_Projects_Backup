// DataProcessor that provides a method to compute the Mean and Standard Deviation using the ten numbers entered in the Data field on the Student Survey Form
package surveyapp.pkg;

import static java.lang.Integer.parseInt;

public class Dataprocessor {

	public double calculate_mean(String data)
	{
		String[] data1 = data.split(",");
		int i;
		double sum=0.0;
		double mean=0.0;
		double n=data1.length;
		for(i=0; i<n; i++)
		{
			sum+=parseInt(data1[i]);
		}
		mean=sum/n;
		return mean;
	}
	
	public double calculate_standarddev(String data, double mean)
	{
		String[] data2 = data.split(",");
		int i;
		double temp=0.0;
		double mean1=mean;
		double variance=0.0;
		double standarddev=0.0;
		double n=data2.length;
		
		for(i=0; i<n; i++)
		{
			temp+=(mean1-parseInt(data2[i]))*(mean1-parseInt(data2[i]));
			
			
		}
		variance=temp/n;
		standarddev= Math.sqrt(variance);
		return standarddev;
		
		
	}
}
