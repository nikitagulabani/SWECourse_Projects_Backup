package nikiswe645;
// All the database CRUD operation are defined in this class

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Surveydb {
	
	private static EntityManager entitymanager;
	public Surveydb(){
		 EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("A4survey");
	      
	     entitymanager = emfactory.createEntityManager();
	}
	public void createStudent(Student student) {
		 System.out.println(student+"========================");
	   
	      
	      entitymanager.getTransaction().begin();

	     
	      //Student student = new Student();
	      entitymanager.persist(student);
	      entitymanager.getTransaction().commit();

	      entitymanager.close( );
	     // emfactory.close( );
	   
	}
	
	public List<Student> SearchStudent(String sfirst, String slast, String city, String state) {
			
			  
			Query query = entitymanager.createQuery("SELECT s FROM Student s WHERE s.sfirst LIKE '"+sfirst+ "' OR s.slast LIKE '"+ slast+"' OR s.city LIKE '"+city+"' OR s.state LIKE '"+ state+"'");
		    System.out.println("------==="+query.getResultList()); 
			return query.getResultList();

		   }
	
	public void DeleteStudent(Student stud) {
		
		   
		      entitymanager.getTransaction().begin();
		      
		      Student stud1 = entitymanager.merge(stud);
		     // System.out.println("Print stud1");
		     // System.out.println(stud1);
		      entitymanager.remove(stud1);
		      entitymanager.getTransaction().commit();
		     // System.out.println(stud1);
		     
		     entitymanager.close();
		     

		}
	
	public List<Student> RetrieveStudent() {
		
		entitymanager.getTransaction().begin();

	    @SuppressWarnings("unchecked")
		List<Student> listsurvey = entitymanager.createQuery("SELECT s FROM Student s").getResultList();
	    entitymanager.getTransaction().commit();
	    entitymanager.close();
	    
	    
	    	return listsurvey;
	    
	    
	  }
	

}
