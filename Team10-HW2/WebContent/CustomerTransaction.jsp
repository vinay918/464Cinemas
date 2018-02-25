<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CSCE 464 Cinemas</title>
<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel = "stylesheet" type = "text/css" href = "customStyles/customStyle.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Review and Payment</title>
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
<h1>Review and Checkout</h1>
	<table class="table text-center">
	  <thead>
	    <tr>
	      <th scope="col" >#</th>
	      <th scope="col" class="text-center">Name</th>
	      <th scope="col" class="text-center">Theatre</th>
	      <th scope="col" class="text-center">No. of Tickets</th>
	      <th scope="col" class="text-center">Total Price</th>    	      
	      	      	      
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <th scope="row">1</th>
	      <td class="text-center">Star Wars: Episode IV</td>
	      <td class="text-center">Avery 12 8.30pm</td>
	      <td class="text-center"><input type="text" class="numTicket" placeholder="1" value ="1"></input></td>
	      <td class="text-center">$10</td>      
	    </tr>
	    <tr>
	      <th scope="row">2</th>
	      <td class="text-center">Star Wars: Episode IV</td>
	      <td class="text-center">Avery 12 10am</td>
	      <td class="text-center"><input type="text" class="numTicket" placeholder="1" value ="2"></input></td>
	      <td class="text-center">$20</td>	 	      
	    </tr>
	  </tbody>
	</table>
	<br>
		<h3 class="text-center">Your total price is $30</h3>
		
		<br>
		<br>
		
		<form name="userPayment" action="CustomerTransactionConfirmation" onsubmit="return" method="post">
			<div class="row">
			  <div class="col-sm-6 text-center">
			    <label for="userFirstName">First Name</label>
			    <input type="text" class="form-control col-sm-6 offset-sm-3"  name="userFirstName" id="userFirstName" placeholder="First Name">
			  </div>
			  <div class=" col-sm-6 text-center">
			    <label for="userLastName">Last Name</label>
			    <input type="text" class="form-control col-sm-6 offset-sm-3" name="userLastName" id="userLastName" placeholder="Last Name">
			  </div>
			  </div>
			  <br>
<br>
			  <div class="row">
			  <div class="col-sm-6 text-center">
			    <label for="userCardNum">Card number</label>
			    <input type="text" class="form-control col-sm-6 offset-sm-3" name="userCardnum" id="userCardNum" placeholder="Card number">
			  </div>
			  <div class="col-sm-6 text-center">
			    <label for="userSecurityCode">Security code</label>
			    <input type="text" class="form-control col-sm-6 offset-sm-3" name="userSecurityCode" id="userSecurityCode" placeholder="3-digit security code">
			  </div>
			  </div>
			  <div class="row">
			  	<div class="form-group col-sm-6 text-center">
			  	 <label for="userExpirationDate">Expiration Date</label>
			  	 <div class="row">
			  	 <div class="col-sm-3 "></div>
			  	 <div class="col-sm-3">
			    <div class="dropdown">
  				<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Month<span class="caret"></span></button>
  					<ul class="dropdown-menu">
    					<li><a href="#">1</a></li>
    					<li><a href="#">2</a></li>
    					<li><a href="#">3</a></li>
    					<li><a href="#">4</a></li>
    					<li><a href="#">5</a></li>
    					<li><a href="#">6</a></li>
    					<li><a href="#">7</a></li>
    					<li><a href="#">8</a></li>
    					<li><a href="#">9</a></li>
    					<li><a href="#">10</a></li>
    					<li><a href="#">11</a></li>
    					<li><a href="#">12</a></li>
  					</ul>
			</div>
			</div>
			<div class="col-sm-3 ">
				<div class="dropdown">
  					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Year<span class="caret"></span></button>
  						<ul class="dropdown-menu">
    							<li><a href="#">18</a></li>
    							<li><a href="#">19</a></li>
    							<li><a href="#">20</a></li>
  					</ul>
				</div>
				</div>
				<div class="col-sm-6 "></div>
				</div>
				</div>
			   <div class="form-group col-sm-6 text-center">
			   <label for="userCardType">Card Type</label>
			  <div class="dropdown">
  				<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Card Type<span class="caret"></span></button>
  					<ul class="dropdown-menu">
    					<li><a href="#">Visa</a></li>
    					<li><a href="#">Master</a></li>
    					<li><a href="#">Discover</a></li>
  					</ul>
			</div>
			</div>
			</div>
<br>
<br>
		<div class="row">
			<div class="col-md-6 text-center">
			    <label for="userBillingAddress">Blling Address</label>
			    <input type="text" class="form-control col-sm-6 offset-sm-3"  name="userBillingAddress" id="userBillingAddress" placeholder="Address Line 1">
			    <br>
			    <div class="row">
			    <input type="text" class="form-control col-sm-2 offset-sm-3" name="userBillingAddress" id="userBillingZip" placeholder="Zip Code">
			    <input type="text" class="form-control col-sm-3" style="margin-left:10px" name="userBillingAddress" id="userState" placeholder="State">
			    </div>
			</div>
			<div class="col-md-6 text-center">
			    <label for="userShippingAddress">Shipping Address</label>
			    <input type="text" class="form-control col-sm-6 offset-sm-3"  name="userShippingAddress" id="userShippingAddress" placeholder="Address Line 1">
			    <br>
			    <div class="row">
			    <input type="text" class="form-control col-sm-2 offset-sm-3" name="userShippingAddress" id="userShipZip" placeholder="Zip Code">
			    <input type="text" class="form-control col-sm-3" style="margin-left:10px" name="userAddress" id="userState" placeholder="State">
			    </div>
			</div>
			</div>
		</div>
		<br>
		<br>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6 text-center">
			  	<button type="submit" class="btn btn-primary">Confirm Payment</button>	
				<a href="ViewAndCheckoutShoppingCart.jsp"> Cancel </a>
				</div>
			<div class="col-md-3"></div>
			</div>
		</form>
</body>
</html>