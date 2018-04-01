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
	<table class="table text-center">
	  <thead>
	    <tr>
	      <th scope="col" >#</th>
	      <th scope="col" class="text-center">Theatre</th>
	      <th scope="col" class="text-center">Room</th>
	      <th scope="col" class="text-center">Title</th>
	      <th scope="col" class="text-center">Date & Time</th>
	      <th scope="col" class="text-center">Seats Remaining</th>
	      <th scope="col" class="text-center">Price</th>
	      <th scope="col" class="text-center">Poster</th>
	      <th scope="col"></th>	      	      
	      	      	      
	    </tr>
	  </thead>
	  <tbody>
	  <c:set var="count" value="1" scope="page" />
	    <c:forEach var="showing" items="${showings}">
	    <tr>
	      <th scope="row">${count}</th>
	      <c:set var="count" value="${count + 1}" scope="page"/>
	      <td class="text-center"><c:out value="${showing.showroom.theatre.name}"/></td>
	      <td class="text-center"><c:out value="${showing.showroom.number}"/></td>
	      <td class="text-center"><c:out value = "${showing.movie.name}"/></td>
	      <td class="text-center"><c:out value = "${showing.startTime}"/></td>
  			<c:choose> 
  				<c:when test= "${ showing.seatsRemaining == 0}">
  					<td class="text-center">Sold Out</td>
  				</c:when>
  				<c:when test= "${ showing.seatsRemaining != 0}">
  					<td class="text-center"><c:out value="${showing.seatsRemaining}"/></td>
  				</c:when>
  			</c:choose>
	      <td class="text-center"><c:out value="${showing.price}"/></td>
	      <td><img src="${showing.movie.thumbnail}" alt="Movie 1" class="poster"></td>
	      <td>
	      	<form name="selectionForm" method="post" action="MovieDetails">
				<input type="hidden" name="selection" value = "${showing.id}"  />
				<button type="submit" class="btn btn-primary">Details</button>
			</form></td> 	      
	    </tr>
	    </c:forEach>


	  </tbody>
	</table>


</body>

</html>