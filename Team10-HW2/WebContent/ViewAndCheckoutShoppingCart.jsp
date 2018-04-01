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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<script type="text/javascript" src="functions.js"></script>

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
	      <td class="text-center"><c:out value="${item.movie.movie.name}"/></td>
	      <td ><img src="${item.movie.movie.thumbnail }" alt="Movie 1" class="poster"></td>
	      <td class="text-center"><c:out value="${item.movie.showroom.theatre.name}"/></td>
	      <td class="text-center"><c:out value="${item.movie.startTime }"/></td>
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
		<h3 class="col-md-4 text-center">Your total price is $ <c:out value="${total}"/></h3>
		<div class="col-md-1"></div>
		<div class="col-md-2">
		<a href="CustomerHomePage.jsp" class="btn btn-info" role="button">Continue Shopping</a>
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-2">
		<a href="CustomerTransaction.jsp" class="btn btn-info" data-toggle="modal" data-target="#exampleModal">Proceed to Check out</a>
		</div>
	</div>
	</div>

	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Please Enter Login Credentials</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        	<form name="userForm">
		      <p id="results"></p>		      
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="exampleInputEmail1">User Name</label>
			    <input type="text" <c:out value="${loginUName}"/> class="form-control" name="userName" id="userName" aria-describedby="emailHelp" placeholder="Enter Username">
			  </div>
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="exampleInputPassword1">Password</label>
			    <input type="password" <c:out value="${loginPass}"/> name="password" class="form-control" id="password" placeholder="Enter Password">
			  </div>
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <input type="hidden" name="auth" value="1" class="form-control" id="auth">
			  </div>			  
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
				<input type="button" value="Submit" onClick="getdata()">			  
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>