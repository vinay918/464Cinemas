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
		        <a class="nav-link" href="ViewOrders.jsp">View Orders<span class="sr-only">(current)</span></a>
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
  			<form action="ViewAndCheckoutShoppingCart.jsp">
  				<div class="form-group">
  					<button type="submit" class="btn btn-primary mb-2">Add to Cart</button>
  				</div>
			</form>
		</div>		
	</div>
</center>
	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Movie Title:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.movie.name}</div>
	</div>
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Description:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.movie.description}</div>
	</div>	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Rating:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.movie.rating }</div>
	</div>	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Theatre Selection:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.showroom.theatre.name}</div>
	</div>
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Showtime</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.startTime}</div>
	</div>	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Price per seat:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.price}</div>
	</div>	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Available Seats:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.seatsRemaining}</div>
	</div>	
	
<br>
<br>

	<div class="row">
  		<div class="col-md-5 offset-md-3 text-center"><h3>Customer Reviews</h3></div>
	</div>	
	<div class="row">
  		<div class="col-md-5 offset-md-3 text-center">(4.7/5)</div>
	</div>	
	
<br>
	<div class="row">
  		<div class="col-md-3 offset-md-1 text-center"><strong>Customer</strong></div>
  		<div class="col-md-3 text-center"><strong>Score</strong></div>
  		<div class="col-md-3 text-center"><strong>Description</strong></div>
	</div>	
	
<br>
	<div class="row">
  		<div class="col-md-3 offset-md-1 text-center vcenter">Julia Roberts (11/10/17)</div>
  		<div class="col-md-3 text-center">5.0</div>
  		<div class="col-md-3 text-center">The best movie of all time!</div>
	</div>
	<div class="row">
  		<div class="col-md-3 offset-md-1 text-center vcenter">Beh Jia Yeh (09/19/17)</div>
  		<div class="col-md-3 text-center">4.0</div>
  		<div class="col-md-3 text-center">It was decent. Could have been better.</div>
	</div>	
	<div class="row">
  		<div class="col-md-3 offset-md-1 text-center vcenter">James Alexander (09/01/16)</div>
  		<div class="col-md-3 text-center">4.8</div>
  		<div class="col-md-3 text-center">Great experience. My life has been changed!</div>
	</div>
</body>
=======
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
<center>
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
 		<% 
  		response.setContentType("text/html");
  		String image = "";
  		if(request.getHeader("accept").contains("webp")){
  			image = "./Images/img2.png";		
  		}else{
  			image = "./Images/img2.jpg";
  		}
  		%>
  		<img src=
  		<%=image %>
  		<img src="${showing.movie.thumbnail}"
  		
  		alt="Movie 2">
  		</div>
	</div>	
	
	<div class="row text-center">
  		<div class="col-xs-1 offset-sm-5">
  			<form action="ViewAndCheckoutShoppingCart.jsp">
  				<div class="form-group">
  					<button type="submit" class="btn btn-primary mb-2">Add to Cart</button>
  				</div>
			</form>
		</div>		
	</div>
</center>
	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Movie Title:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.movie.name}</div>
	</div>
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Description:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.movie.description}</div>
	</div>	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Rating:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.movie.rating }</div>
	</div>	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Theatre Selection:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.showroom.theatre.name}</div>
	</div>
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Showtime</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.startTime}</div>
	</div>	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Price per seat:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.price}</div>
	</div>	
	<div class="row">
  		<div class="col-xs-6 col-md-4 offset-md-2">Available Seats:</div>
  		<div class="col-xs-5 col-md-5 text-center">${showing.seatsRemaining}</div>
	</div>	
	
<br>
<br>

	<div class="row">
  		<div class="col-md-5 offset-md-3 text-center"><h3>Customer Reviews</h3></div>
	</div>	
	<div class="row">
  		<div class="col-md-5 offset-md-3 text-center">(4.7/5)</div>
	</div>	
	
<br>
	<div class="row">
  		<div class="col-md-3 offset-md-1 text-center"><strong>Customer</strong></div>
  		<div class="col-md-3 text-center"><strong>Score</strong></div>
  		<div class="col-md-3 text-center"><strong>Description</strong></div>
	</div>	
	
<br>
	<div class="row">
  		<div class="col-md-3 offset-md-1 text-center vcenter">Julia Roberts (11/10/17)</div>
  		<div class="col-md-3 text-center">5.0</div>
  		<div class="col-md-3 text-center">The best movie of all time!</div>
	</div>
	<div class="row">
  		<div class="col-md-3 offset-md-1 text-center vcenter">Beh Jia Yeh (09/19/17)</div>
  		<div class="col-md-3 text-center">4.0</div>
  		<div class="col-md-3 text-center">It was decent. Could have been better.</div>
	</div>	
	<div class="row">
  		<div class="col-md-3 offset-md-1 text-center vcenter">James Alexander (09/01/16)</div>
  		<div class="col-md-3 text-center">4.8</div>
  		<div class="col-md-3 text-center">Great experience. My life has been changed!</div>
	</div>
</body>
>>>>>>> refs/remotes/origin/master
</html>