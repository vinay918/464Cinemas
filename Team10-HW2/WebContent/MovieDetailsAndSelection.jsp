<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CSCE 464 Cinemas</title>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="functions.js"></script>



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
		        <a class="nav-link" href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart <span class="sr-only">(current)</span></a>
		      </li>
		    </ul>		    
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
				<form name="submitForm" method="POST" action="ViewOrders">
		        <a class="nav-link" href="javascript:document.submitForm.submit()">View Orders<span class="sr-only">(current)</span></a>
		      	</form>
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
<center>
	<div class="alert alert-success" style="visibility:hidden;" id="banner"></div>
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
	<div class="row text-center">
  		<div class="col-xs-1 offset-sm-5">
  		  <c:choose> 
  			<c:when test= "${ showing.seatsRemaining <= 0}">
  					<div class="form-group">
  					<br>
  					<h4>Sold Out</h4>
  					</div>
  			</c:when> 
  			<c:when test= "${ showing.seatsRemaining > 0}">
  			<div name = "quantityForm">
  				<div class="form-group">
  				Tickets:
  					<select class="form-control" id="sel1" name="ticketQuantity">
  						<c:set var="count" value="1" scope="page" />
  						<c:forEach var = "i" begin = "1" end = "${showing.seatsRemaining}">
  							<option value="${i}"><c:out value="${i}"/></option>
  						</c:forEach>
  					</select>
  				</div>
  				<div class="form-group">
  					<button class="btn btn-primary mb-2" onClick="sendData()">Add to Cart</button>
  				</div>
			</div>
			</c:when>
		</c:choose>
		</div>		
	</div>
	
</center>
	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Movie Title:</div>
  		<div class="col-xs-5 col-md-5 text-center"><c:out value = "${showing.movie.name}"/> </div>
	</div>
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Description:</div>
  		<div class="col-xs-5 col-md-5 text-center"><c:out value="${showing.movie.description}"/></div>
	</div>	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Rating:</div>
  		<div class="col-xs-5 col-md-5 text-center"><c:out value="${showing.movie.rating }"/></div>
	</div>	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Theatre Selection:</div>
  		<div class="col-xs-5 col-md-5 text-center"><c:out value="${showing.showroom.theatre.name}"/></div>
	</div>
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Showtime</div>
  		<div class="col-xs-5 col-md-5 text-center"><c:out value ="${showing.startTime}"/></div>
	</div>	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Price per seat:</div>
  		<div class="col-xs-5 col-md-5 text-center"><c:out value = "${showing.price}"/></div>
	</div>	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Available Seats:</div>
  		<div class="col-xs-5 col-md-5 text-center"><c:out value = "${showing.seatsRemaining}"/></div>
	</div>	
	
<br>
<br>


	<div class="row">
  		<div class="col-md-5 offset-md-3 text-center"><h3>Customer Reviews</h3></div>
	</div>	
	<div class="row">
  		<div class="col-md-5 offset-md-3 text-center">Average Score: <c:out value="${avg}"/> / 5</div>
	</div>	
	
<br>
<br>

<c:forEach var="review" items="${reviews}">
	<div class="row">
  		<div class="col-md-3 offset-md-1 text-center vcenter"><c:out value="${review.reviewer.firstName} ${review.reviewer.lastName} (${review.date})"/></div>
  		<div class="col-md-3 text-center"><c:out value="${review.rating}"/></div>
  		<div class="col-md-3 text-center"><c:out value="${review.comment}"/></div>
	</div>
</c:forEach>
<br>
		<div class="col-md-9 offset-md-1 text-center" id = "reviewform">
		<h5>Add Review</h5>
		<form name="userForm"  method="post" id="userForm">
		      <p>${Error}</p>
		      <div class="container">
		      <p><c:out value="${showing.movie.name}"/></p>
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="userName">User Name: </label>
			    <input type="text" class="form-control" name="fName"  aria-describedby="emailHelp" value="${user.firstName} ${user.lastName}" disabled>
			  </div>	
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="review" >Rating (1-5):</label>
			    <div class="radio" id="rating">
  					<label><input type="radio" name="rating" value="1">1  </label>
 			 		<label><input type="radio" name="rating" value="2">2  </label>
 			 		<label><input type="radio" name="rating" value="3">3  </label>
 			 		<label><input type="radio" name="rating" value="4">4  </label>
 			 		<label><input type="radio" name="rating" value="5" checked>5</label>
				</div>				
			  </div>				  		      	
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="review">Review/Comment:</label>
			    <textarea class="form-control" id="review" value="${selectedMovieShowing.review}" placeholder="Enter your review..." rows="5"></textarea>
			  </div>	
		      
		      </div>

			  <button class="btn btn-primary" onClick="addReviewData();return false;">Submit</button>	
			<a href="MovieDetailsAndSelection"> Cancel </a> <br>
		</form>
		</div>	


</body>
</html>