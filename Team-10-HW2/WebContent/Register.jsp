<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MVC Web Application</title>
		<script>
		function validateForm() {
		    var x = document.forms["userForm"]["userName"].value;
		    var y = document.forms["userForm"]["password"].value;
		    var z = document.forms["userForm"]["password2"].value;

		    if (x == "") {
		        alert("Username must be filled out");
		        return false;
	   		}else if(x.length < 6){
	    		alert("Username must be at least 6 characters long");
	    		return false;
	  		}			    
		    if (y == "") {
		        alert("Password must be filled out");
		        return false;
		    }else if(y.length < 6){
		    	alert("Password must be at least 6 characters long");
		    	return false;
		    }else if(z.localeCompare(y)!=0){
		    	alert("Passwords must match");
		    	return false;
		    }
		
		}
	   </script>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<link rel = "stylesheet" type = "text/css" href = "customStyles/customStyle.css" />	

	</head>
	
	<body>
	
		<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
		  <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <a class="navbar-brand" href="Login.jsp">CSCE 464 Cinemas</a>
		
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		        <a class="nav-link" href="Login.jsp">Home <span class="sr-only">(current)</span></a>
		      </li>
		    </ul>
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		        <a class="nav-link" href="About">About <span class="sr-only">(current)</span></a>
		      </li>
		    </ul>		    

		  </div>
		</nav>
		
		
		<br>
		<div class="col-sm-10 offset-sm-1 text-center">
		<h3> Register here</h3>
		<form name="userForm" action	= Register 
		      onsubmit="return validateForm()" method="post">
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="exampleInputEmail1">User Name</label>
			    <input type="text" class="form-control" name="userName"  aria-describedby="emailHelp" placeholder="Enter Username">
			  </div>
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="exampleInputPassword1">Password</label>
			    <input type="password" name="password" class="form-control" placeholder="Enter Password">
			  </div>
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="exampleInputPassword1">Confirm Password</label>
			    <input type="password" name="password2" class="form-control" placeholder="Enter Password">
			  </div>

			  <button type="submit" class="btn btn-primary">Submit</button>	
		<a href="Login.jsp"> Login </a> <br>
		</form>
		</div>		
		<br>
		<br>
		

		
	
	</body>
</html>