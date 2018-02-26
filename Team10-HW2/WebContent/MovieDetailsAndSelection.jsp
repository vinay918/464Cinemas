<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CSCE 464 Cinemas</title>
	<script>
		function validateForm() {
		    var x = document.forms["quantityForm"]["ticketQuantity"].value;
			console.log(x);
		    if (isNaN(x)) {
		    		alert("Ticket Quantity is not a number!");
		        return false;
	   		}else if(x<=0){
	   			alert("Ticket Quantity is must be greater than zero!");
		        return false;
	   		}else{
		    		return true;
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
	<!-- STEP TWO COPY AND PASTE THIS WHOLE NAV CLASS AT THE TOP OF YOUR BODY TAG. IT CREATES A STANDARD LAYOUT -->
	<!-- YOU CAN EDIT ANYTHING YOU NEED TO -->
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
		        <a class="nav-link" href="Login.jsp">Logout <span class="sr-only">(current)</span></a>
		      </li>
		    </ul>

		  </div>
		</nav>

<br>
<center>
	<div class="row text-center">
  		<div class="col-xs-1 offset-sm-8">
  			<form action = "MovieSearchResults.jsp">
  				<div class="form-group">
  					<button type="submit" class="btn btn-primary mb-2">Back</button>
  				</div>
			</form>
		</div>	
	</div>

	<div class="row text-center">  		
  		<div class="col-md-7 offset-md-2">
  		<img src="${showing.movie.thumbnail}"
  		
  		alt="Movie 2">
  		</div>
	</div>	
	<form name="quantityForm" action="Login" onsubmit="return validateForm()">
	<div class=container>
	<div class="row" style="padding-top:5px; padding-bottom:10px">
  			<input type="text" class="form-control col-md-3 offset-md-4" name="ticketQuantity" placeholder="Number of ticket" value = "0" style="margin-right:5px"></input>
  			<button type="submit" class="btn btn-primary">Add to Cart</button>
	</div>
	</div>
	</form>
	
</center>
	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Movie Title:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.movie.name}</div>
	</div>
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Description:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.movie.description}</div>
	</div>	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Rating:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.movie.rating }</div>
	</div>	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Theatre Selection:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.showroom.theatre.name}</div>
	</div>
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Showtime</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.startTime}</div>
	</div>	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Price per seat:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.price}</div>
	</div>	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Available Seats:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.seatsRemaining}</div>
	</div>	
	
<br>
<br>
<div class="container">
	<div class="offset-md-5">
		<h4>Reviews/Comments</h4>
	</div>
</div>

<div class ="container">
<table class="table table table-striped" style="text-align: left">
	<tr>
		<th scope="col">Customer Name</th>
		<th scope="col">Date</th>
		<th scope="col">Rating</th>
		<th scope="col">Review</th>
	</tr>
	<c:set var="count" value="0" scope="page" />
	    <c:forEach var="review" items="${showingReviews}">
	    <tr>
<%-- 	      <th scope="row">${count}</th>
	      <c:set var="count" value="${count + 1}" scope="page"/> --%>
	      <td class="text-left">${review.customerName}</td>
	      <td class="text-left">${review.date}</td>
	      <td class="text-left">${review.rating}</td>
	      <td class="text-left">${review.review}</td>    
	    </tr>
	 </c:forEach>
</table>
</div>
<br>
<br>
</body>
</html>