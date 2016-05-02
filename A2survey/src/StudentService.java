
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;


public class StudentService {
	
	public void save(Student stud) throws IOException
			{
				Writer writer = new FileWriter("/opt/bitnami/apache-tomcat/webapps/survey.txt",true);



				try
				{
writer.write(stud.getSfirst()+"|"+stud.getSlast()+"|"+stud.getSaddress()+"|"+stud.getZipcode()+"|"+stud.getCity()+"|"+stud.getState()+"|"+stud.getTelephone()+"|"+stud.getEmail()+"|"+stud.getUrl()+"|"+stud.getSdate()+"|"+stud.getRadios()+"|"+list2String(stud.getChecks())+"|"+stud.getChance()+"|"+stud.getComments()+"|"+stud.getRaffle()+"|"+System.getProperty("line.separator"));
				}
				finally
				{
					writer.close();
				}
			}

		public void retrive(List<Student> students) throws FileNotFoundException,IOException
		{

			//String finallist;
			try(BufferedReader br = new BufferedReader(new FileReader("/opt/bitnami/apache-tomcat/webapps/survey.txt")))
			{
				StringBuilder strbuld = new StringBuilder();
				String current=br.readLine();
	
				while(current!=null)
				{
					Student stud1 = new Student();
					String line[] = current.split("\\|");
					stud1.setSfirst(line[0]);
					stud1.setSlast(line[1]);
					stud1.setSaddress(line[2]);
					stud1.setZipcode(line[3]);
					stud1.setCity(line[4]);
					stud1.setState(line[5]);
					stud1.setTelephone(line[6]);
					stud1.setEmail(line[7]);
					stud1.setUrl(line[8]);
					stud1.setSdate(line[9]);
					stud1.setRadios(line[10]);
					//stud1.setChecks(line[11]);
					stud1.setChance(line[12]);
					stud1.setComments(line[13]);
					students.add(stud1);
					current=br.readLine();
				}
				//finallist= strbuld.toString();
			}
			//return finallist;
		}
	
		public static String list2String(String[] list) {
	        StringBuffer ret = new StringBuffer("");
	        for (int i = 0; list != null && i < list.length; i++) {
	            ret.append(list[i]);
	            if (i < list.length - 1) {
	                ret.append(',');
	            }
	        }
	        return ret.toString();
	    }

	
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
		System.out.print("niki");
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
