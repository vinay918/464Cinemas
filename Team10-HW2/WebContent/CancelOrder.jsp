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
<title>Cancel Order</title>
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
<h3 style="padding-left:10px">Order cancellation information </h3>
	<table class="table text-center">
	  <thead>
	    <tr>
	      <th scope="col" class="text-center">Order Number</th>
	      <th scope="col" class="text-center">Order Details</th>
	      <th scope="col" class="text-center">Ordered Total</th> 
	      <th scope="col" class="text-center">Ordered Date</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <td class="text-center">1801291001</td>
	      <td class="text-left"><ul>
  				<li>Movie Name: Star Wars: Episode IV - A New Hope</li>
  				<li>Ticket quantity: 3 </li>
  				<li>Total Price: $30</li>
  				<li>Location: Avery 12</li>
  				<li>Date/ Time: 2-1-2018 10.00am</li>
				</ul>
			</td>
	      <td class="text-center">$30</td>
	      <td class="text-center">01-29-2018</td>
	    </tr>
	  </tbody>
	</table>
	<br>
	<div class="col-sm-10 offset-sm-1 text-center">
	<a href="CancellationConfirmation.jsp" class="btn btn-info" role="button">Confirm Cancellation</a>
		<a href=CustomerHomePage.jsp> Discard Cancellation </a> <br>
	</div>
</body>
</html>