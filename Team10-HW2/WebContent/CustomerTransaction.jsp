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
</script>
</head>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
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
<div class="container" >
<h1>Review and Checkout</h1>
	<table class="table table-striped">
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
	  <c:set var="count" value="1" scope="page" />
	    <c:forEach var="item" items="${shoppingCart}">
	    <tr>
	      <th scope="row" name="index">${count}</th>
	      <c:set var="count" value="${count + 1}" scope="page"/>
	      <td class="text-center">${item.movie.movie.name}</td>
	      <td class="text-center">${item.movie.showroom.theatre.name}</td>
	      <td class="text-center">${item.ticketQuantity}</td>
	      <td class="text-center">$ ${item.price}</td>   
	    </tr>
	    	    </c:forEach>
	  </tbody>
	  </table>
	<br>
		<h3 class="text-center">Your total price is $${total}</h3>
</div>
		<br>
		<br>
		<h4 class="text-center">${balanceAndDetails}</h4>
		<div class = "container">
		<form name="userPayment" action="CustomerTransactionConfirmation" method="post">
			<div class="row">
			  <div class="col-6 col-md-6">
			  	<div class="row text-center">
			    		<label for="userFirstName">First Name</label>
			    		<input type="text" class="form-control col-sm-6 offset-sm-3"  name="userFirstName" id="userFirstName" placeholder="First Name">
			  	</div>
			  	<br>
			  	<div class="row text-center">
			    		<label for="userLastName">Last Name</label>
			    		<input type="text" class="form-control col-sm-6 offset-sm-3" name="userLastName" id="userLastName" placeholder="Last Name">
			  	</div>
			  	<br>
			  	<div class="row text-left">
			    		<label for="cardName">Card holder Name</label>
			    		<div class="col-md-6">
			    		<input type="text" class="form-control" style="margin-left:71px" name="cardName" id="cardNameId" placeholder="Card holder Name">
			  		</div>
			  	</div>
			    </div>
			  <div class="col-6 col-md-6">
			  <div class="row text-center">
			  	<div class="col-6 col-md-6">
			    <label for="userCardNum">Card number</label>
			   	</div>
			    <input type="text" class="form-control col-sm-6" name="userCardNum" id="userCardNum" placeholder="Card number">
			  </div>
			  <br>
			  <div class="row text-center">
			  	<div class="col-6 col-md-6">	
			    <label for="userSecurityCode">Security code</label>
			    </div>
			    <input type="text" class="form-control col-sm-4" name="userSecurityCode" id="userSecurityCode" placeholder="3-digit security code">
			  </div>
			  <br>
			  <div class="row text-center">
			  	<div class="col-md-6">	
			    		<label for="userExpirationDate">Expiration Date</label>
			    </div>
			    <div class="col-md-3">
			    <select class="form-control" name="cardMonth">
  						<option value="1" >1</option>
  						<option value="2" >2</option>
  						<option value="3" >3</option>
  						<option value="4" >4</option>
  						<option value="5" >5</option>
  						<option value="6" >6</option>
  						<option value="7" >7</option>
  						<option value="8" >8</option>
  						<option value="9" >9</option>
  						<option value="10" >10</option>
  						<option value="11" >11</option>
  						<option value="12" >12</option>
  					</select>
  				</div>
  				<div class="col-md-3">
			    <select class="form-control" name="cardYear">
  						<option value="18" >18</option>
  						<option value="19" >19</option>
  						<option value="20" >20</option>
  					</select>
  				<div>
  				</div>
				</div>
				</div>
				<br>
				<div class="row text-center">
				<div class="col-6 col-md-6">	
			   		<label for="userCardType">Card Type</label>
			   	</div>
			  	<div class="col-md-3">
			    <select class="form-control" name="cardType">
  						<option value="Visa" >Visa</option>
  						<option value="Master" >Master</option>
  						<option value="Discover">Discover</option>
  				</select>
  				<div>
				</div>
				</div>
				</div>
				</div>
				</div>
			<br>
			<br>
			<br>
			<div class = "row">
				<div class="col-md-5 text-center">
					<div class="row">
						<label for="userBillingAddress">Blling Address</label>
					</div>
					<div class="row">
						<input type="text" class="form-control"  name="userBillingAddress" id="userBillingAddress" placeholder="Address Line 1">
					</div>
					<br>
					<div class="row">
						<div class="col-md-6 text-center">
						<input type="text" class="form-control" name="userBillingAddress" id="userBillingZip" placeholder="Zip Code">
			   		 	</div>
			   		 	<div class="col-md-6 text-center">
			   		 	<input type="text" class="form-control" name="userBillingAddress" id="userState" placeholder="State">
						</div>
					</div>
				</div>
				<div class="col-md-2 text-center">
				</div>
				<div class="col-md-5 text-center">
					<div class="row">
						<label for="userShippingAddress">Shipping Address</label>
					</div>
					<div class="row">
						<input type="text" class="form-control"  name="userShippingAddress" id="userShippingAddress" placeholder="Address Line 1">
					</div>
					<br>
					<div class="row">
						<div class="col-md-6 text-center">
						<input type="text" class="form-control" name="userShippingAddress" id="userShipZip" placeholder="Zip Code">

			   		 	</div>
			   		 	<div class="col-md-6 text-center">
			   		 	<input type="text" class="form-control" name="userAddress" id="userState" placeholder="State">
						</div>
					</div>
				</div>
			</div>
			  </div>
			  </div>
			  </div>

				<div class="col-sm-6 "></div>
				</div>
				</div>
			</div>
<br>
<br>
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
		</div>
		
</body>
</html>