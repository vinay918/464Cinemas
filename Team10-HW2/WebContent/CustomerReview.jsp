<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MVC Web Application</title>
		<script>
		function validateForm() {
		    var textBox = document.getElementById("reviewTextBox");
			var textLength = textBox.value.length;
		    if (x > 255 || textBox.value == "Enter your review...") {
		        alert("The review exceeded the maximum length. Sorry.");
		        return false;
	   		}
		
		}
	   </script>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<link rel = "stylesheet" type = "text/css" href = "customStyles/customStyle.css" />	
	<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>

	</head>
	
	<body>
	<c:if test="${active != 1 }">
		<c:redirect url = "Login.jsp"/>
	</c:if>
	<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
		  <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <a class="navbar-brand" href="CustomerHomePage.jsp">CSCE 464 Cinemas</a>
		
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		        <a class="nav-link" href="CustomerHomePage.jsp">Home <span class="sr-only">(current)</span></a>
		      </li>
		    </ul>
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		        <a class="nav-link" href="ViewOrders.jsp">View Orders<span class="sr-only">(current)</span></a>
		      </li>
		    </ul>	
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		        <a class="nav-link" href="Logout">Logout <span class="sr-only">(current)</span></a>
		      </li>
		    </ul>

		  </div>
		</nav>
		
		<br>
		<div class="col-sm-10 offset-sm-1 text-center">
		<h3>Customer Review</h3>
		<form name="userForm" action	="CustomerReview" onsubmit="return validateForm()" method="post">
		      <p>${Error}</p>
		      <div class="container">
		      <p>${showing.movie.name}</p>
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="exampleInputEmail1">User Name: </label>
			    <input type="text" class="form-control" name="fName"  aria-describedby="emailHelp" value="${user.firstName}" disabled>
			  </div>	
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="exampleInputEmail1">Rating (1-5):</label>
			    <div class="radio">
  					<label><input type="radio" name="rating" value="1">1  </label>
 			 		<label><input type="radio" name="rating" value="2">2  </label>
 			 		<label><input type="radio" name="rating" value="3">3  </label>
 			 		<label><input type="radio" name="rating" value="4">4  </label>
 			 		<label><input type="radio" name="rating" value="5" checked>5</label>
				</div>				
			  </div>				  		      	
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="exampleInputEmail1">Review/Comment:</label>
			    <textarea class="form-control" name="review" value="${selectedMovieShowing.review}" placeholder="Enter your review..." rows="5"></textarea>
			  </div>	
		      
		      </div>

			  <button type="submit" class="btn btn-primary">Submit</button>	
		<a href="MovieDetailsAndSelection"> Cancel </a> <br>
		</form>
		</div>		
		<br>
		<br>
		

		
	
	</body>
</html>