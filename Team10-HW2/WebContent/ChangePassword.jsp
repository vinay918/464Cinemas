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
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
		<title>CSCE 464 Cinemas</title>
		<script type="text/javascript" src="functions.js"></script>
</head>
	
<body>
		<c:if test="${active != 1 }">
		<c:redirect url = "Login.jsp"/>
		</c:if>
		<!-- STEP TWO COPY AND PASTE THIS WHOLE NAV CLASS AT THE TOP OF YOUR BODY TAG. IT CREATES A STANDARD LAYOUT -->
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
		<div class="col-sm-10 offset-sm-1 text-center">
		<form name="changePass" action	= ChangePassword 
		      onsubmit="return validateForm4()" method="post">
		      <p><c:out value="${passError}"/></p>		      

			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="exampleInputPassword1">Current Password</label>
			    <input type="password" <c:out value="${loginPass}"/> name="prevpassword" class="form-control" id="prevpassword" placeholder="Enter Current Password">
			  </div>
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="exampleInputPassword1">New Password</label>
			    <input type="password"  name="newpassword1" class="form-control" id="newpassword1" placeholder="Enter New Password">
			  </div>
			  <div class="form-group col-sm-6 offset-sm-3 text-center">
			    <label for="exampleInputPassword1">New Password</label>
			    <input type="password"  name="newpassword2" class="form-control" id="newpassword2" placeholder="Re-Enter New Password">
			  </div>			  			  

			  <button type="submit" class="btn btn-primary">Confirm</button>	

		</form>
		</div>

	
	</body>
	
	
</html>