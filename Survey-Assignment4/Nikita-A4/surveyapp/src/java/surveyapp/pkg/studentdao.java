//StudentDAO class that encapsulates code to store and retrieve the Survey data into/from a database. It provides two methods: one to save the Student Survey Form data to a database table and another to retrieve the survey information from the the database
package surveyapp.pkg;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.lang.ClassNotFoundException;


public class studentdao {
	
		
		public void save(Studentbean sb)throws SQLException, ClassNotFoundException  {
		
			Connection con = null;
			PreparedStatement prestmt = null;
			
					
				System.out.println("Connecting to db..");
				Class.forName ("oracle.jdbc.driver.OracleDriver"); 
				con = DriverManager.getConnection ("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g","ngulaban", "Pushpablack92");
				System.out.println("Connection establised");
	
			
			prestmt = con.prepareStatement("INSERT INTO survey(studentid, username, streetaddress, zip, city, state, tel, email, url, sdate, cinput, rinput, comments, gdate, gyear, chance)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			prestmt.setString(1,sb.getStudentid());
			prestmt.setString(2,sb.getUsername());
			prestmt.setString(3,sb.getStreetaddress());
			prestmt.setString(4,sb.getZip());
			prestmt.setString(5,sb.getCity());
			prestmt.setString(6,sb.getState());
			prestmt.setString(7,sb.getTel());
			prestmt.setString(8,sb.getEmail());
			prestmt.setString(9,sb.getUrl());
			prestmt.setString(10,sb.getSdate());
			prestmt.setString(11,sb.getCinput());
			prestmt.setString(12,sb.getRinput());
			prestmt.setString(13,sb.getComments());
			prestmt.setString(14,sb.getGdate());
			prestmt.setString(15,sb.getGyear());
			prestmt.setString(16,sb.getChance());
			prestmt.executeUpdate();
			System.out.println("Record inserted");
			
			
				if(con != null) try { con.close();} catch(SQLException ignore){}
				if(prestmt != null) try { prestmt.close();} catch(SQLException ignore){}
		}
		
		public ResultSet retrive(String id)throws SQLException, ClassNotFoundException
		{
			Connection con = null;
			ResultSet res = null;
			Statement stmt=null;
				System.out.println("Connecting to db..");
				Class.forName ("oracle.jdbc.driver.OracleDriver"); 
				con = DriverManager.getConnection ("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g","ngulaban", "Pushpablack92");
				System.out.println("Connection establised");
	
				
		
			
			
			
				
			
			stmt=con.createStatement();
			res=stmt.executeQuery("SELECT * FROM survey WHERE studentid='"+id+"'");
                        
			 return res;
                        
		}
		
	
	}

