package nikiswe645;
//This java class is used to calculate mean and standard deviation



public class StudentService {
	

		

	
	public double calculate_mean(String data)
	{
		String[] data1 = data.split(",");
		int i;
		double sum=0.0;
		double mean=0.0;
		double n=data1.length;
		for(i=0; i<n; i++)
		{
			int val = Integer.parseInt(data1[i]);
			sum += val;
		}
		mean=sum/n;
		System.out.print(mean);
		//System.out.print("niki");
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
			int val = Integer.parseInt(data2[i]);
			temp+=(mean1-val)*(mean1-val);
			
			
		}
		variance=temp/n;
		standarddev= Math.sqrt(variance);
		return standarddev;
		
		
	}
}
