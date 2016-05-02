<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple Acknowledge</title>
</head>

<body>  
<h1>Hi Thank You for filling the form</h1>
<h3>Your information is saved successfully in the Database</h3>


Mean: <s:property value="dbean.mean"/>
     Standard deviation : <s:property value="dbean.standarddev"/>
     
        
     <label>Student ID</label>
                
           
             <ul>
        <s:iterator value="st1" var="Studentid2">
                <li>
                    <s:a action="stud"><s:param name="Studentid2" value="%{#Studentid2}"/><s:property></s:property></s:a>
                </li>
        </s:iterator> 
        </ul>
            
     

     
</body>  

</html>