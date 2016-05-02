<!-- Acknowledge page to simply thank the user for filling out the form (we call this SimpleAcknowledgement JSP) -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<sql:setDataSource
        driver="oracle.jdbc.driver.OracleDriver"
        url="jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g"
        user="ngulaban" password="Pushpablack92"/>
     <sql:query var="items" sql="SELECT * FROM survey"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Acknowledge</title>
</head>
<body>
    <header>
<img alt="cs department logo" src="top.png" width="100%"/>

</header>
<h1>Hi Thank You for filling the form</h1>
<h3>Your information is saved successfully in the Database</h3>

     Mean: ${db.mean}
     Standard deviation : ${db.standarddev}
     
     
        
    
   
     <table>
         
            <tr>
                <th>Student ID</th>
                
            </tr>
         <c:forEach var="row" items="${items.rows}">
             <tr>
             <ul>
                 <td><li><a href="Fservlet?studentid=${row.studentid}">${row.studentid}</a></li></td>
             </ul>
                </tr>
         </c:forEach>
           
     </table>
     
<footer>

<hr />
<p align="center">All information on this site is &copy;
Nikita Sanjay Gulabani &amp; Associates, Inc. 2015.</p> 
</footer>
     
    
</body>
</html>