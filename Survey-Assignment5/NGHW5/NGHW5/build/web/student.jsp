<%-- 
    Document   : student
    Created on : Apr 14, 2015, 4:51:42 PM
    Author     : Nikita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Page</title>
        <style type="text/css">
.multicol
{
-webkit-column-count: 3; /* Chrome, Safari, Opera */
-moz-column-count: 3; /* Firefox */
column-count:3;

-webkit-column-gap: 30px; /* Chrome, Safari, Opera */
-moz-column-gap: 30px; /* Firefox */
column-gap:30px;

-webkit-column-rule: 2px; /* Chrome, Safari, Opera */
-moz-column-rule: 2px; /* Firefox */
column-rule:2px;
}
</style>
    </head>
    <body>
       
        <h1>Hello <s:property value="studbean.studentid"/></h1>
        <h2>Student Information</h2>
        
        <div class="multicol">
       
         
<label>Student Id:</label> <s:property value="studbean1.studentid"/>
<br>
<br>
<label>Name:</label> <s:property value="studbean1.username"/><br>
<br>
<label>Street Address:</label> <s:property value="studbean1.streetaddress"/><br>
<br>

<label>Zipcode:</label> <s:property value="studbean1.zip"/><br>
<br>

<label>City:</label> <s:property value="studbean1.city"/><br>
<br>

<label>State:</label> <s:property value="studbean1.state"/><br>
<br>

<label>Telephone number:</label> <s:property value="studbean1.tel"/><br>
<br>




<label>Email:</label> <s:property value="studbean1.email"/><br>
<br>

<label>URL:</label> <s:property value="studbean1.url"/><br>

<br>
<label>Date:</label> <s:property value="studbean1.sdate"/><br>

<br>



<label>What did you like the most on campus:</label> <s:property value="studbean1.cinput"/><br>
<br>


<label>From where did you hear about this university:</label> <s:property value="studbean1.rinput"/><br>
<br>

<label>Comments:</label> <s:property value="studbean1.comments"/><br>






<br>
<label> Graduation Date:</label> <s:property value="studbean1.gdate"/><br>
<br>



<label> Graduation Year:</label> <s:property value="studbean1.gyear"/><br>


<br>
<label>Chances of you recommending this school:</label> <s:property value="studbean1.chance"/>
            

        </div>
  
    </body>
</html>
