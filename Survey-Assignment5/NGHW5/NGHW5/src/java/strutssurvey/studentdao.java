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
//StudentDAO class that encapsulates code to store and retrieve the Survey data into/from a database. It provides two methods: one to save the Student Survey Form data to a database table and another to retrieve the survey information from the the database

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.lang.ClassNotFoundException;
import java.sql.Array;
import java.util.ArrayList;


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
		
		public Studentbean retrive(String id)throws SQLException, ClassNotFoundException
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
                          Studentbean sb1 = new Studentbean();
                        
	while(res.next())
                {
                    
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
                 return sb1;       
		}
		
                public ArrayList<String> getStudent() throws SQLException, ClassNotFoundException{ 
                    Connection con = null;
			ResultSet res = null;
			Statement stmt=null;
				System.out.println("Connecting to db..");
				Class.forName ("oracle.jdbc.driver.OracleDriver"); 
				con = DriverManager.getConnection ("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g","ngulaban", "Pushpablack92");
				System.out.println("Connection establised");
	
				stmt=con.createStatement();
			res=stmt.executeQuery("SELECT trim(studentid) as studentid FROM survey");
                          ArrayList<String> st = new ArrayList<String>(); 
                        
	while(res.next()){
            
            st.add(res.getString("studentid"));
        
        }
                    return st;
                    
                    
                }

}


