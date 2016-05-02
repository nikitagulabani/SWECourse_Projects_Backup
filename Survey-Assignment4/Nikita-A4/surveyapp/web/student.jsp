<%-- 
    Document   : student
    Created on : Apr 14, 2015, 4:51:42 PM
    Author     : Nikita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <header>
<img alt="cs department logo" src="top.png" width="100%"/>

</header>
        <h1>Hello ${sb1.studentid}</h1>
        <h2>Student Information</h2>
        
        <div class="multicol">
       
         
<label>Student Id:</label>${sb1.studentid}
<br>
<br>
<label>Name:</label>${sb1.username}<br>
<br>
<label>Street Address:</label>${sb1.streetaddress}<br>
<br>

<label>Zipcode:</label>${sb1.zip}<br>
<br>

<label>City:</label>${sb1.city}<br>
<br>

<label>State:</label>${sb1.state}<br>
<br>

<label>Telephone number:</label>${sb1.tel}<br>
<br>




<label>Email:</label>${sb1.tel}<br>
<br>

<label>URL:</label>${sb1.url}<br>

<br>
<label>Date:</label>${sb1.sdate}<br>

<br>



<label>What did you like the most on campus:</label>${sb1.cinput}<br>
<br>


<label>From where did you hear about this university:</label>${sb1.rinput}<br>
<br>

<label>Comments:</label>${sb1.comments}<br>






<br>
<label> Graduation Date:</label>${sb1.gdate}<br>
<br>



<label> Graduation Year:</label>${sb1.gyear}<br>


<br>
<label>Chances of you recommending this school:</label>${sb1.chance}<br>

        </div>
<footer>

<hr />
<p align="center">All information on this site is &copy;
Nikita Sanjay Gulabani &amp; Associates, Inc. 2015.</p> 
</footer>
           
    </body>
</html>
