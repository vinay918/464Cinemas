<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		<h2>Score! Your order #${orderId} has been placed. Detail(s):</h2>
		<h3 style="padding-left:10px">Order #${orderId} information </h3>
	<table class="table text-center">
	  <thead>
	    <tr>
	      <th scope="col" >#</th>
	      <th scope="col" class="text-center">Order Details</th>
	      <th scope="col" class="text-center">Ordered Total</th> 
	      <th scope="col" class="text-center">Ordered Date</th>   
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
	      		<c:set var="count" value="${count + 1}" scope="page"/>
	    			</tr>
	    	    		</c:forEach>
	  </tbody>
	</table>

</body>
</html>