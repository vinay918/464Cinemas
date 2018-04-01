<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CSCE 464 Cinemas</title>
		<script>
		function validateForm() {
		    var x = document.forms["userForm"]["userName"].value;
		    var y = document.forms["userForm"]["password"].value;
		    var z = document.forms["userForm"]["password2"].value;
		    var strength = document.getElementById('strength').innerHTML;
		    
		    if (x == "") {
		        alert("Username must be filled out");
		        return false;
	   		}else if(x.length < 6){
	    		alert("Username must be at least 6 characters long");
	    		return false;
	  		}	
		    if(strength.indexOf('Weak') >= 0){
		    	alert("Please improve your password strength (using special characters and numbers might help)");
		    	return false;
		    }
	   		else if (y == "") {
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
		
		//credit:https://martech.zone/javascript-password-strength/
		function passwordChanged() {
			var strength = document.getElementById('strength');
			var strongRegex = new RegExp("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
			var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");
			var enoughRegex = new RegExp("(?=.{6,}).*", "g");
			var pwd = document.getElementById("password");
			if (pwd.value.length==0) {
			strength.innerHTML = 'Type Password';
			} else if (false == enoughRegex.test(pwd.value)) {
			strength.innerHTML = 'More Characters';
			} else if (strongRegex.test(pwd.value)) {
			strength.innerHTML = '<span style="color:green">Strong!</span>';
			} else if (mediumRegex.test(pwd.value)) {
			strength.innerHTML = '<span style="color:orange">Medium!</span>';
			} else {
			strength.innerHTML = '<span style="color:red">Weak!</span>';
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
		      <p>${Error}</p>
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="exampleInputEmail1">First Name</label>
			    <input type="text" class="form-control" name="fName"  aria-describedby="emailHelp" value="${aUser.firstName}" placeholder="Enter First Name" >
			  </div>	
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="exampleInputEmail1">Last Name</label>
			    <input type="text" class="form-control" name="lName"  aria-describedby="emailHelp" value="${aUser.lastName}" placeholder="Enter Last Name">
			  </div>				  		      	
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="exampleInputEmail1">Email Address</label>
			    <input type="text" class="form-control" name="email"  aria-describedby="emailHelp" value="${aUser.email}" placeholder="Enter Email Address">
			  </div>	
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="exampleInputEmail1">Phone Number</label>
			    <input type="text" class="form-control" name="phone"  aria-describedby="emailHelp" value="${aUser.phone}" placeholder="Enter Phone Number">
			  </div>				  			  			  			  			  			  			  		      
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="exampleInputEmail1">User Name</label>
			    <input type="text" class="form-control" name="userName"  aria-describedby="emailHelp" value="${aUser.userName}" placeholder="Enter Username">
			  </div>
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="exampleInputPassword1">Password</label>
			    <input type="password" name="password" id="password" class="form-control" placeholder="Enter Password" onkeyup="return passwordChanged();">
			    <span id="strength">Type Password</span>

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