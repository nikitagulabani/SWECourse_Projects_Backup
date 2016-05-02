<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Winner Page</title>
</head>
<body>
   
<h1>You are the WINNER of 2 movie Tickets</h1>
  
<h3>Your information is saved successfully in the Database</h3>

   
     Mean: <s:property value="dbean.mean"/>
     Standard deviation : <s:property value="dbean.standarddev"/>
     
        
     <label>Student ID</label>
                
           
             <ul>
        <s:iterator value="st1" var="studentid">
                <li>
                    <s:a action="stud"><s:param name="studentid" value="%{#studentid}"/><s:property></s:property></s:a>
                </li>
        </s:iterator> 
        </ul>
            
   


</body>
</html>