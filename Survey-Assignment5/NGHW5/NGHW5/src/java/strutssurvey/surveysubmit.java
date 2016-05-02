/*Action class is a POJO with execute() method, but can have
any valid java method with return type String*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strutssurvey;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.Array;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikita
 */
public class surveysubmit extends ActionSupport implements ModelDriven<Studentbean> {

    private Studentbean studbean = new Studentbean();
    private Studentbean studbean1 = new Studentbean();
    //private Studentbean studbean2 = new Studentbean();
    private Databean dbean = new Databean();
    private ArrayList<String> st1 = new ArrayList<String>();
    private String data;
    private String[] idlist;
    private String Studentid;
    private String Studentid2;

    public String getStudentid2() {
        return Studentid2;
    }

    public void setStudentid2(String Studentid2) {
        this.Studentid2 = Studentid2;
    }
    
    

    public Studentbean getStudbean() {
        return studbean;
    }

    public Studentbean getStudbean1() {
        return studbean1;
    }

    
    public Databean getDbean() {
        return dbean;
    }

    public ArrayList<String> getSt1() {
        return st1;
    }

    public String getData() {
        return data;
    }

    public String[] getIdlist() {
        return idlist;
    }

    public String getStudentid() {
        return Studentid;
    }

    public void setStudbean(Studentbean studbean) {
        this.studbean = studbean;
    }

    public void setStudbean1(Studentbean studbean1) {
        this.studbean1 = studbean1;
    }

    public void setDbean(Databean dbean) {
        this.dbean = dbean;
    }

    public void setSt1(ArrayList<String> st1) {
        this.st1 = st1;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setIdlist(String[] idlist) {
        this.idlist = idlist;
    }

    public void setStudentid(String Studentid) {
        this.Studentid = Studentid;
    }

 

    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public String execute() throws SQLException, ClassNotFoundException {

        studentdao studdao = new studentdao();
		studdao.save(studbean);

        
        st1 = studdao.getStudent();

        dataprocessor dataproc = new dataprocessor();

        double mean;
        mean = dataproc.calculate_mean(data);

        double sd;
        sd = dataproc.calculate_standarddev(data, mean);

        dbean.setMean(mean);
        dbean.setStandarddev(sd);

        System.out.println("Mean is" + mean);
        System.out.println("Standard Deviation is" + sd);

        String id_string = "";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g", "ngulaban", "Pushpablack92");
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery("Select studentid from survey");
            while (result.next()) {
                id_string = id_string + result.getString(1) + ",";
            }

            con.close();

        } catch (Exception e) {
        }

        idlist = id_string.split(",");

        if (mean > 90) {

            return "winner";
        } else {

            return "simple";
        }

    }

    /**
     *
     * @return
     */
    @Override
    public Studentbean getModel() {
        // TODO Auto-generated method stub
        return studbean;
    }

    public String studclicked() {

        studentdao sdao1 = new studentdao();
        
        
        try {
            studbean1 = sdao1.retrive(Studentid2);
        } catch (SQLException ex) {
            Logger.getLogger(surveysubmit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(surveysubmit.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        if (studbean1 == null) {
            return "failure";
        } else {

            return "student";
        }
    }

    
}
