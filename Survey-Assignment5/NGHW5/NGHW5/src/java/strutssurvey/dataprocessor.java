/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strutssurvey;

/**
 *
 * @author Nikita
 */
import static java.lang.Integer.parseInt;

public class dataprocessor {

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

