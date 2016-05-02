/*Java script to validate the form fields*/ 
function sclicked()
{
	
	error = "";	
	var name = document.getElementById("name").value;
	var streetadd = document.getElementById("streetaddress").value;
	var zip = document.getElementById("zip").value;
	var email = document.getElementById("email").value;
        var inputdata = document.getElementById("data").value;
	
	isname(name);
	
	isalphanum(streetadd);
	
	isnumeric(zip);
	
	emailvalid(email);
        
 
	
	checkscript();
        radioscript();
        checkdata(inputdata);
	
	 
            
            
  	 if(error != ""){
           	$("#errormsg")
                        .html(error)
                        .dialog({
                    
                    modal: true,
			buttons:{
				Ok: function(){
					$(this).dialog("close");
				}
			}
		});
                
                }
	
		
	
    
}

function checkdata(dstring)
{
	
	
	var dataExp = /^([0-9])+$/;
	var tokens = dstring.split(",");

	if(tokens.length<10)
		{
		error+="Please enter atleast 10 characters in the Data Field\n";
		
		return;
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
			for (i = document.getElementsByName("cinput").length - 1; i >= 0; i--) { 
				if (document.getElementsByName("cinput")[i].checked) { 
					boxesTicked = boxesTicked + 1;
				} 
				
			} 
		if (boxesTicked < 2 ) { 
			error += "Please check two things for checkbox.\n";
	
		} 
		
	} 
        
     function radioscript()
	{
            var r = 0;
        var grouper = document.getElementsByName('rinput');
        for (i=0; i<grouper.length; i++) {
		if (grouper[i].checked === true)
			r++;
	}
	if (r !== 1)
	 error += "No radio button is checked.\n";

      } 
	
	

	
        