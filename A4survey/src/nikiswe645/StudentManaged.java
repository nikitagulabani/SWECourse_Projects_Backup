package nikiswe645;
//This java class is the Managed Bean

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ManagedBean

public class StudentManaged {
	
	
	public StudentManaged(){
		
	}
	private Student student = new Student();
	private WinningResult winningresult = new WinningResult();
	
	
	public Student getStudent() {
		return student;
	}

	private List<Student> searchres;
	
	
	public List<Student> getSearchres() {
		return this.searchres;
	}


	public void setSearchres(List<Student> searchres) {
		this.searchres = searchres;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public WinningResult getWinningresult() {
		return winningresult;
	}


	public void setWinningresult(WinningResult winningresult) {
		this.winningresult = winningresult;
	}

	
	StudentService ss = new StudentService();
	public String showresult() throws IOException
	{
	Surveydb sdb = new Surveydb();
	//System.out.println("------------------123-"+student.getChecks());
	
	sdb.createStudent(student);
	
    
	Double mean= ss.calculate_mean(student.getRaffle());
	Double standarddev= ss.calculate_standarddev(student.getRaffle(),mean);
	

	winningresult.setMean(mean);
	winningresult.setStandarddev(standarddev);
            
            if(mean>=90)
            {
                 return "Winner";
            }
            else if(mean<90)
            {
                return "Simple";
               
            }
			return null;
	}

	public List<Student> getresult() throws FileNotFoundException, IOException
	{
		//List <Student> st = new ArrayList<Student>();
		//StudentService ss1 = new StudentService();
		
		Surveydb sdb1 = new Surveydb();
		
		List<Student> st = sdb1.RetrieveStudent();
		return st;
	}
	
	public String getSearchResult() throws FileNotFoundException, IOException
	{
		
		//Student s = new Student();
		String sfirst=student.getSfirst();
		String slast=student.getSlast();
		String city=student.getCity();
		String state=student.getState();
		Surveydb sdb2 = new Surveydb();
		System.out.println("In managed bean search");
		System.out.println(sfirst);
		System.out.println(slast);
		System.out.println(city);
		System.out.println(state);
		
	
		searchres = sdb2.SearchStudent(sfirst,slast,city,state);
		System.out.println("-----"+searchres);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("result", searchres);
		
		return null;
		
	}
	public String deleterec(Student std)
	{
		System.out.println("In managed bean delete");
		Surveydb sdb3 = new Surveydb();
		sdb3.DeleteStudent(std);
		return "listsurvey";
		
	}
	
	public List<String> completechance(String chance)
	{
		List <String> chances = new ArrayList<String>();
		chances.add("Very Likely");
		chances.add("Likely");
		chances.add("Unlikely");
		return chances;
	}
	
	public String dateselect(AjaxBehaviorEvent event){
		//Student s = new Student();
		Date surveydate= student.getSdate();
		Date startdate = student.getStart();
		
		FacesContext context = FacesContext.getCurrentInstance();
		System.out.println(startdate.before(surveydate));
		if(startdate.before(surveydate))
		{
			//System.out.println("here");
		
			context.addMessage(null,new FacesMessage("Start Date of the semester cannot be before Survey Date"));
			
		}
		
		
		if(context.getMessageList().size() > 0){
			
			return(null);
		}
		return "Done";
		
	}
	public void calczipcode(AjaxBehaviorEvent Event)
	{
		FacesContext fc = FacesContext.getCurrentInstance();
		String tempZip=null;
		
		try{
			tempZip = student.getZipcode();
		}
		catch(Exception e){
			fc.addMessage(null, new FacesMessage("Zipcode not digits!"));
		}
		//System.out.println(tempZip);
		Client client = Client.create();
		WebResource wrs = client.resource("http://ec2-52-87-218-28.compute-1.amazonaws.com/A3survey/resources/zipcode/"+tempZip);
		ClientResponse resp = (ClientResponse) wrs.accept("application/json").get(ClientResponse.class);
		String tempZipjson = resp.getEntity(String.class);
		/*
		String tempAddress = aws.getStateInfo(tempZip);
		*/
		if(tempZipjson.equals("") || tempZipjson == null){
			fc.addMessage(null, new FacesMessage("Zipcode not found!"));
		}
		else{
		
			 String[] tempVal =  tempZipjson.split(":", 2);
		     student.setCity(tempVal[0]);
		     student.setState(tempVal[1]);
	   }
		
	}

	

	}

