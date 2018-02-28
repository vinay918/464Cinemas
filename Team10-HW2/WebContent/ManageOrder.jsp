<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel = "stylesheet" type = "text/css" href = "customStyles/customStyle.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<title>Manage Order</title>
</head>
<body>
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

<h3 style="padding-left:10px">Order #${orderId} information </h3>
	<table class="table text-center">
	  <thead>
	    <tr>
	      <th scope="col" >#</th>
	      <th scope="col" class="text-center">Order Details</th>
	      <th scope="col" class="text-center">Ordered Total</th> 
	      <th scope="col" class="text-center">Ordered Date</th>
	      <th scope="col" class="text-center">Order Status</th>      
	  	  <th></th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	       <c:set var="count" value="1" scope="page" />
	    			<c:forEach var="item" items="${orderItems}">
	    			<tr>
	      		<td scope="row" name="index">${count}</td>
	      		<td class="text-center"><ul>
  					<li>Movie Name: ${item.movie.movie.name}</li>
  					<li>Ticket quantity: ${item.quantity} </li>
  					<li>Location: ${item.movie.showroom.theatre.name }</li>
  					<li>Date/ Time: ${item.movie.startTime }</li>
				</ul></td>
				<td class="text-center">$${item.orderPrice}</td>
				<td class="text-center">${orderDate}</td>
	      			<c:choose> 
  						  	<c:when test= "${  item.isCancel == 1}">
  								<td class="text-center">Cancelled</td>
  							</c:when>
  							<c:when test= "${ item.isCancel != 1}">
  								<td class="text-center">Confirmed</td>
  							</c:when>
  					</c:choose>
	      			<c:choose> 
  						  	<c:when test= "${  item.isCancel == 1}">
  							</c:when>
  							<c:when test= "${ item.isCancel != 1}">
  								<td class="text-center">
									<form>
									<input type="hidden" name="orderId" value = "${item.orderItemId}"/>
	      							<button type="submit" formaction="CancelOrderItem" class="btn btn-primary">Cancel Item</button>
	      							</form>
								</td>
  							</c:when>
  					</c:choose>
	      		<c:set var="count" value="${count + 1}" scope="page"/>
	    			</tr>
	    	    		</c:forEach>
	  </tbody>
	</table>
	<br>

</body>
</html>