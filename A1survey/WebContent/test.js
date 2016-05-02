/*
 * Nikita Gulabani, G00912741 Java script to validate the user input
 */ 

function sclicked()
{
	
	error = "";	
	var name = document.getElementById("name").value;
	var streetadd = document.getElementById("streetaddress").value;
	var city = document.getElementById("city").value;
	var state = document.getElementById("state").value;
	var zip = document.getElementById("zip").value;
	var email = document.getElementById("email").value;
	
	isname(name);
	iscity(city);
	isstate(state);
	isalphanum(streetadd);
	
	isnumeric(zip);
	
	emailvalid(email);
	
	checkscript();
	
	if(error != ""){
		document.getElementById("errormsg").innerHTML = error;
		$("#errormsg").dialog("open");
	
	}
		
	
}

	function isname(astring)
	{
		
		var alphaExp = /^[a-zA-Z]+$/;
		if(!(astring.match(alphaExp)))
		{
			error += "Please enter only alphabets for your name\n";
			document.getElementById("name").value="";
		}
			
	}
	function iscity(astring)
	{
		var alphaExp = /^[a-zA-Z]+$/;
		if(!(astring.match(alphaExp)))
		{
			error += "Please enter only alphabets for your city\n";
			document.getElementById("city").value="";
		}
			
	}
	function isstate(astring)
	{
		var alphaExp = /^[a-zA-Z]+$/;
		if(!(astring.match(alphaExp)))
		{
			error += "Please enter only alphabets for your state\n";
			document.getElementById("state").value="";
		}
			
	}
	function isalphanum(anstring)
	{
		var alphanumExp = /^[a-zA-Z0-9 ]+$/;
		if(!(anstring.match(alphanumExp)))
		{
			error += "Please enter only alphanumeric for street address \n";
			document.getElementById("streetaddress").value="";
		}
				
	}
	function isnumeric(nstring)
	{
		
		var numericExp = /^[0-9]{5}?$/;
		if(!(nstring.match(numericExp)))
		{
			
			error += "Please enter only numeric for zip-code \n";
			document.getElementById("zip").value="";
		}
				
	}
	function emailvalid(estring)
	{
		var emailExp = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
		if(!(estring.match(emailExp)))
		{
			error += "Please enter valid email \n";
			document.getElementById("email").value="";
		}
				
	}

	function checkscript() 
	{ 
		var boxesTicked = 0 ;
			for (i = document.getElementsByName('cinput').length - 1; i >= 0; i--) { 
				if (document.getElementsByName('cinput')[i].checked) { 
					boxesTicked = boxesTicked + 1;
				} 
				
			} 
		if (boxesTicked < 2 ) { 
			error += "Please check two things for checkbox.\n";
	
		} 
		
	} 
	
	
$(function(){
		
		$("#errormsg").dialog({
			modal: true,
			buttons:{
				Ok: function(){
					$(this).dialog("close");
				}
			}
		});
		
	});
	
