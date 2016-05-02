//The servlet acts as a front controller in the MVC implementation and receives and handles all requests from the client, performs business logic via business delegate classes (which may return JavaBean objects), stores the beans into a session object, and then forwards the request to appropriate JSP to present the data to the user using a RequestDispatcher object
package surveyapp.pkg;

import java.io.IOException;

import javax.servlet.*; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Servlet implementation class Fservlet
 */
@WebServlet("/Fservlet")
public class Fservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Fservlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("studentid");
                studentdao sdao=new studentdao();
                ResultSet res = null;
            try {
                res =sdao.retrive(id);
            } catch (SQLException ex) {
                Logger.getLogger(Fservlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Fservlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            int i = 0;
            Studentbean sb1 = new Studentbean();
            try {
                while(res.next())
                {
                    i++;
                    String studentid = res.getString("studentid");
                    String username = res.getString("username");
                    String streetaddress = res.getString("streetaddress");
                    String zip = res.getString("zip");
                    String city = res.getString("city");
                    String state = res.getString("state");
                    String tel = res.getString("tel");
                    String email = res.getString("email");
                    String url = res.getString("url");
                    String sdate = res.getString("sdate");
                    String cinput = res.getString("cinput");
                    String rinput = res.getString("rinput");
                    String comments = res.getString("comments");
                    String gdate = res.getString("gdate");
                    String gyear = res.getString("gyear");
                    String chance = res.getString("chance");
                    
                    sb1.setStudentid(studentid);
		sb1.setUsername(username);
		sb1.setStreetaddress(streetaddress);
		sb1.setZip(zip);
		sb1.setCity(city);
		sb1.setState(state);
		sb1.setTel(tel);
		sb1.setEmail(email);
		sb1.setUrl(url);
		sb1.setSdate(sdate);
		sb1.setCinput(cinput);
		sb1.setRinput(rinput);
		sb1.setComments(comments);
		sb1.setGdate(gdate);
		sb1.setGyear(gyear);
		sb1.setChance(chance);
                }   
                   
		
                
                String address = null;
                if(i != 0)
                {
                     address="student.jsp";
                }
                else
                {
                    address="nostudent.jsp";
                   
                }
                
                request.setAttribute("sb1",sb1);
               
                
                RequestDispatcher dispatcher = request.getRequestDispatcher(address); 
                dispatcher.forward(request, response);
                
                    //System.out.printf("StudentID:%o \tUsername:%s\tStreet Address:%s\tZipcode:%s\tCity:%s\tState:%s\tTelephone:%s\tEmail:%s\tURL:%s\tSurveyDate:%s\tChecked:%s\tRadio:%s\tComments:%s\tGrad Month:%s\tGrad Year:%s\tChance of recommending:%s\n", studentid,username, streetaddress, zip, city, state, tel, email, url, sdate, cinput, rinput, comments, gdate, gyear, chance );
                
            } catch (SQLException ex) {
                Logger.getLogger(Fservlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                
                
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String studentid = request.getParameter ("studentid");
               
		
		String username = request.getParameter ("username");
                
		String streetaddress = request.getParameter ("streetaddress");
		String zip = request.getParameter ("zip");
		String city = request.getParameter ("city");
		String state = request.getParameter ("state");
		String tel = request.getParameter ("tel");
		String email = request.getParameter ("email");
		String url = request.getParameter ("url");
		String sdate = request.getParameter ("sdate");
		String[] cinput = request.getParameterValues ("cinput"); 
	
		String check="";
		for(int i=0; i < cinput.length; i++)
		{
			check += cinput[i]+",";
		}
		
		String rinput = request.getParameter ("rinput");
		
		String comments = request.getParameter ("comments");
		String gdate = request.getParameter ("gdate");
		String gyear = request.getParameter ("gyear");
		String chance = request.getParameter ("chance");
		String data = request.getParameter ("data");
		
		Studentbean sb = new Studentbean();
		sb.setStudentid(studentid);
		sb.setUsername(username);
		sb.setStreetaddress(streetaddress);
		sb.setZip(zip);
		sb.setCity(city);
		sb.setState(state);
		sb.setTel(tel);
		sb.setEmail(email);
		sb.setUrl(url);
		sb.setSdate(sdate);
		sb.setCinput(check);
		sb.setRinput(rinput);
		sb.setComments(comments);
		sb.setGdate(gdate);
		sb.setGyear(gyear);
		sb.setChance(chance);
		studentdao sdao=new studentdao();
		try {
                    try {
                        sdao.save(sb);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Fservlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
 
		
		
		Dataprocessor dp = new Dataprocessor();
		Double mean= dp.calculate_mean(data);
		Double standarddev= dp.calculate_standarddev(data,mean);
		
		Databean db = new Databean();
		db.setMean(mean);
		db.setStandarddev(standarddev);
                
                
                String address = null;
                if(mean>=90)
                {
                     address="winnerack.jsp";
                }
                else if(mean<90)
                {
                    address="simpleack.jsp";
                   
                }
                request.setAttribute("db",db);
               
                
                RequestDispatcher dispatcher = request.getRequestDispatcher(address); 
                dispatcher.forward(request, response);
		
		

	}

}
