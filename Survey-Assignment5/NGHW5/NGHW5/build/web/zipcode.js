
function validatezip()
{
	var zipFile= "zip.json";


	var request
	 try{
	     
         request = new XMLHttpRequest();
      }
   
	catch (e)
		 {
            
            alert("Request Failed!");
            return false;
         }
      
     request.onreadystatechange  = function(){ statechange(request);}
   request.open("GET",zipFile, true);
  
   request.send();
     
}

function statechange(request)
{
	
 if (request.readyState == 4 && request.status == 200 )
 {
	 
   var flag=0;
   var jsObj = eval("("+request.responseText+")");
  var zipc = document.getElementById("zip").value;
	
	for(var i=0;i<4;i++)
	{
	
	 if(zipc == jsObj.zipcodes[i].zip)
    {
		
     document.getElementById("city").value =jsObj.zipcodes[i].city;
	 document.getElementById("state").value =jsObj.zipcodes[i].state;
		//document.getElementById("zipspan").value ="";

	 flag = 1;
	 }
	}
	if(flag===0)
	{
		document.getElementById("zip").value ="Invalid zipcode";
		document.getElementById("city").value = "";
		 document.getElementById("state").value = "";
	}
 }

}
