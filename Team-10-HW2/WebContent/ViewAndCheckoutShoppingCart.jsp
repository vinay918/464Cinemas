<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel = "stylesheet" type = "text/css" href = "customStyles/customStyle.css" />
<script>

		function click(){
			alert('pressed!');
		}
</script>

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
<h1>Shopping cart</h1>
	<table class="table text-center">
	  <thead>
	    <tr>
	      <th scope="col" >#</th>
	      <th scope="col" class="text-center">Name</th>
	      <th scope="col" class="text-center">Poster</th>
	      <th scope="col" class="text-center">Theatre</th>
	      <th scope="col" class="text-center">Time</th>
	      <th scope="col" class="text-center">Date</th>
	      <th scope="col" class="text-center">No. of Tickets</th>
	      <th scope="col" class="text-center">Total Price</th>
	      <th scope="col"></th>	      	      
	      	      	      
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <th scope="row">1</th>
	      <td class="text-center">Star Wars: Episode IV</td>
	      <td ><img src="./Images/img2.jpg" alt="Movie 1" class="poster"></td>
	      <td class="text-center">Avery 12</td>
	      <td class="text-center">8:30 pm</td>
	      <td class="text-center">2/10/18</td>
	      <td class="text-center"><input type="text" class="numTicket" placeholder="1" value ="1"></input></td>
	      <td class="text-center">$10</td>
	      <td><button type="button" class="btn btn-primary" onclick="click()">Remove</button></td> 	      
	    </tr>
	    <tr>
	      <th scope="row">2</th>
	      <td class="text-center">Star Wars: Episode IV</td>
	      <td ><img src="./Images/img2.jpg" alt="Movie 1" class="poster"></td>
	      <td class="text-center">Avery 12</td>
	      <td class="text-center">10:00 am</td>
	      <td class="text-center">2/10/18</td>
	      <td class="text-center"><input type="text" class="numTicket" placeholder="1" value ="2"></input></td>
	      <td class="text-center">$20</td>
	      <td><button type="button" class="btn btn-primary" onclick="click()">Remove</button></td> 	 	      
	    </tr>
	  </tbody>
	</table>
	<br>
	<div class="row">
		<div class="col-md-3"></div>
		<h3 class="text-center">Your total price is $30</h3> 	
		<div class="col-md-1"></div>
		<a href="CustomerTransaction.jsp" class="btn btn-info" role="button">Proceed to Check out</a>
	</div>
</body>
</html>