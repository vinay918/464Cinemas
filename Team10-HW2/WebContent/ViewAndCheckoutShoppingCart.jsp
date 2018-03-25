<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CSCE 464 Cinemas</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel = "stylesheet" type = "text/css" href = "customStyles/customStyle.css" />
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<script>
</script>

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
				<form name="submitForm" method="GET" action="ViewOrders">
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
<div class="container">
	<p class="text-center">
		<h1>Shopping cart</h1>
	</p>
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col" >#</th>
	      <th scope="col" class="text-center">Name</th>
	      <th scope="col" class="text-center">Poster</th>
	      <th scope="col" class="text-center">Theatre</th>
	      <th scope="col" class="text-center">Date/Time</th>
	      <th scope="col" class="text-center">No. of Tickets</th>
	      <th scope="col" class="text-center">Total Price</th>
	      <th scope="col"></th>	      	      
	      	      	      
	    </tr>
	  </thead>
	  <tbody>
	  <c:set var="count" value="1" scope="page" />
	    <c:forEach var="item" items="${shoppingCart}">
	    <tr>
	      <th scope="row" name="index">${count}</th>
	      <td class="text-center">${item.movie.movie.name}</td>
	      <td ><img src="${item.movie.movie.thumbnail }" alt="Movie 1" class="poster"></td>
	      <td class="text-center">${item.movie.showroom.theatre.name}</td>
	      <td class="text-center">${item.movie.startTime }</td>
	      <td class="text-center">
			<form method="POST" action ="UpdateShoppingCart">
			<input type="hidden" name="index" value = "${count}"/>
	      		<select class="form-control" name="ticketQuantity" onchange="this.form.submit()">
  					<c:set var="count" value="1" scope="page" />
  					<c:forEach var = "i" begin = "1" end = "${showing.seatsRemaining}">
  						<c:choose> 
  						  	<c:when test= "${ i == item.ticketQuantity}">
  								<option value="${i}" selected="selected">${i}</option>
  							</c:when>
  							<c:when test= "${ i != item.ticketQuantity}">
  								<option value="${i}">${i}</option>
  							</c:when>
  						</c:choose>
  					</c:forEach>
  				</select>
  			</form>
  		  </td>
	      <%-- <td class="text-center"><input type="text" class="numTicket" placeholder="Quantity" value ="${item.ticketQuantity}"></input></td> --%>
	      <td class="text-center">$ ${item.price}</td>
	      <c:set var="count" value="${count + 1}" scope="page"/>
	      <td>
	      <form>
			<input type="hidden" name="selection" value = "${item.movie.id}"/>
	      	<button type="submit" formaction="RemoveItem" formmethod="POST" class="btn btn-primary">Remove</button>
	      </form>
		  </td> 	
	      
	    </tr>
	    	    </c:forEach>
	  </tbody>
	</table>
	<br>
	<div class="row">
		<h3 class="col-md-4 text-center">Your total price is $ ${total}</h3>
		<div class="col-md-1"></div>
		<div class="col-md-2">
		<a href="CustomerHomePage.jsp" class="btn btn-info" role="button">Continue Shopping</a>
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-2">
		<a href="CustomerTransaction.jsp" class="btn btn-info" role="button">Proceed to Check out</a>
		</div>
	</div>
	</div>

</body>
</html>