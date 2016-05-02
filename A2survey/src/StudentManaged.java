

import javax.faces.bean.ManagedBean;
import javax.faces.view.facelets.Facelet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@ManagedBean
public class StudentManaged {
	
	
	public StudentManaged(){
		
	}
	private Student student = new Student();
	private WinningResult winningresult = new WinningResult();
	
	
	public Student getStudent() {
		return student;
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
	
	
	ss.save(student);
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
		List <Student> st = new ArrayList<Student>();
		StudentService ss1 = new StudentService();
		
		ss1.retrive(st);
		return st;
	}
	
	
	

	}

