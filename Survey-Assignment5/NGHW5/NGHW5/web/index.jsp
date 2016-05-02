<%-- 
    Document   : index
    Created on : May 1, 2015, 1:47:08 PM
    Author     : Nikita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
<meta charset="ISO-8859-1">
<title>Survey Page</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="zipcode.js"> </script>
<script type="text/javascript" src="test.js"> </script>


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

<h1>Feel free to give us your feedback </h1>
<hr />

<form class="multicol" action="submitform"  method="POST" autocomplete="on">



<label>Student Id</label><br>
<input type="text" id="studentid" name="studentid" autofocus="autofocus" required/>
<br>
<label>Name:</label><br>
<input type="text" id="name" required="required" name="username"/><br>

<label>Street Address:</label><br>
<input type="text" id="streetaddress" name="streetaddress" required/><br>

<label>Zipcode:</label><br>
<input type="text" id="zip" name="zip" onblur="validatezip()"/><br>


<label>City:</label><br>
<input type="text" id="city" name="city"/><br>

<label>State:</label><br>
<input type="text" id="state" name="state"/><br>

<label>Telephone number:</label><br>
<input type="tel" name="tel" placeholder= "(###) ###-####" pattern= "\(\d{3}\) +\d{3}-\d{4}" required="required" />
<br>


<label>Email:</label><br>
<input type="email" id="email" placeholder="name@domain.com" name="email" required="required"/>
<br>
<label>URL:</label><br>
<input type="url" placeholder= "http://www.domainname.com" name="url"/>
<br>
<label>Date:</label><br>
<input type="date" name="sdate" placeholder= "yyyy-mm-dd"/>
<br>



<label>What did you like the most on campus:</label><br>


<input name="cinput" type="checkbox" value="students"/><label>Students</label><br>


<input name="cinput" type="checkbox" value="location"/><label>Location</label><br>



<input name="cinput" type="checkbox" value="campus"/><label>Campus</label><br>


<input name="cinput" type="checkbox" value="atmosphere"/><label>Atmosphere</label><br>


<input name="cinput" type="checkbox" value="dormrooms"/><label>Dorm rooms</label><br>


<input name="cinput" type="checkbox" value="sports"/><label>Sports</label><br>





<label>From where did you hear about this university:</label><br>



<input name="rinput" type="radio" value="friends" /><label>Friends</label><br>


<input name="rinput" type="radio" value="television"/><label>Television</label><br>



<input name="rinput" type="radio" value="internet"/><label>Internet</label><br>


<input name="rinput" type="radio" value="others"/><label>Others</label><br>





<label>Comments:</label><br>

<textarea name="comments" rows="5" cols="36" placeholder="Enter comments here..">  </textarea>




<br>
<label> Graduation Date:</label><br>

<input type="text" placeholder="month" list="months" name="gdate"/>
<datalist id="months">
<option value = "January">
<option value = "Febuary">
<option value = "March">
<option value = "April">
<option value = "May">
<option value = "June">
<option value = "July">
<option value = "August">
<option value = "September">
<option value = "October">
<option value = "November">
<option value = "December">
</datalist>

<input type="text" placeholder="yyyy" name="gyear">




<br>
<label>Chances of you recommending this school:</label><br>

<select name="chance">
<option>Very Likely</option>
<option>Likely</option>
<option>Unlikely</option>
</select>
<br>

<label>Data Field</label><br>
<input type="text" id="data" name="data" required/>
<br>




<br>
<input type="submit" value="Submit" onclick="sclicked()"/>

<input type="button" value="Reset" onclick="this.form.reset()"/>
<br>

<div id="errormsg" title="Error Dialog">
</div>

</form>


<footer>

<hr />
<p align="center">All information on this site is &copy;
Nikita Sanjay Gulabani &amp; Associates, Inc. 2015.</p> 
</footer>




</body>
</html>

