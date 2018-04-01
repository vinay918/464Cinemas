/**
 * 
 */
			function validateForm() {
			    var x = document.forms["userForm"]["userName"].value;
			    var y = document.forms["userForm"]["password"].value;
			    if (x == "") {
			        alert("Username must be filled out");
			        return false;
		   		}else if(x.length < 6){
		    		alert("Username must be at least 6 characters long");
		    		return false;
		  		}			    
			    if (y == "") {
			        alert("Password must be filled out");
			        return false;
			    }else if(y.length < 6){
			    	alert("Password must be at least 6 characters long");
			    	return false;
			    }
			}
			
			function validateForm2() {
			    var textBox = document.getElementById("reviewTextBox");
				var textLength = textBox.value.length;
			    if (x > 255 || textBox.value == "Enter your review...") {
			        alert("The review exceeded the maximum length. Sorry.");
			        return false;
		   		}
			
			}
			
			function validateForm3() {
			    var x = document.forms["quantityForm"]["ticketQuantity"].value;
				console.log(x);
			    if (isNaN(x)) {
			    		alert("Ticket Quantity is not a number!");
			        return false;
		   		}else if(x<=0){
		   			alert("Ticket Quantity is must be greater than zero!");
			        return false;
		   		}else{
			    		return true;
			    }
			
			}		
			
			function validateForm4() {
			    var x = document.forms["changePass"]["newpassword2"].value;
			    var y = document.forms["changePass"]["newpassword1"].value;
			    var z = document.forms["changePass"]["prevpassword"].value;
			    if (x == "" || y=="" || z == "") {
			        alert("Passwords must be filled out");
			        return false;
		   		}
			    if(x.length < 6 || y.length < 6 || z.length < 6){
		    		alert("Passwords must be at least 6 characters long");
		    		return false;
		  		}
			    if(x != y){
		    		alert("New passwords must match");
		    		return false;		  			
		  		}			    
			}			
			
			
			function placeOrder() {
				var d = document.forms["userPayment"]["userCardNum"].value;
				var f = document.forms["userPayment"]["userBillingAddress"].value;
				$.ajax({
					 type: "POST",
			         url: "PlaceOrder",
			         data: { 
			        	 	"userCardNum" : d,
			        	 	"userBillingAddress" : f
			         },
					 
					 success: function(responseText) {
			             var obj = JSON.parse(responseText);
			             if(!obj.success){
			                 alert(obj.message);
			             }else{
			            	 	alert(obj.message);
			            		$(".orderid").html("<h2 style=\"padding-left:10px\">Score! Your order #"+ obj.orderId +" has been placed. Detail(s):</h2>");
			            		$(".orderinfo").html("<h3 style=\"padding-left:10px\">Order #"+ obj.orderId+" information </h3>");
			            		$(".orderdate").text(obj.orderDate);
			            		$(".reviewandcheckout").hide();
			            		$(".orderconfirmed").show();
			             }

			         }
				 });  
			}
			
			function confirm() {
			var a = document.forms["userPayment"]["userFirstName"].value;
			var b = document.forms["userPayment"]["userLastName"].value;
			var c = document.forms["userPayment"]["cardName"].value;
			var d = document.forms["userPayment"]["userCardNum"].value;
			var e = document.forms["userPayment"]["userSecurityCode"].value;
			var f = document.forms["userPayment"]["userBillingAddress"].value;
			var g = document.forms["userPayment"]["userShippingAddress"].value;
			var h = document.forms["userPayment"]["userBillingZip"].value;
			var i = document.forms["userPayment"]["userShipZip"].value;
			var j = document.forms["userPayment"]["userBillState"].value;
			var k = document.forms["userPayment"]["userShipState"].value;
			var expirationDate = document.forms["userPayment"]["cardMonth"].value + "/" +document.forms["userPayment"]["cardYear"].value;
			var cardType = document.forms["userPayment"]["cardType"].value
			var total = $("#total").val();
			var userId = $("#userid").val();
			
		 	if (a == "") {
				alert("Please fill in first name.");
				return false;
			}		    
			if (b == "") {
				alert("Please fill in last name.");
				return false;
			}
			if (c == "") {
				alert("Please fill in card holder name.");
				return false;
			}
			if (d == "") {
				alert("Please fill in card number.");
				return false;
			}
			if (e == "") {
				alert("Please fill in security code.");
				return false;
			}else if(e.length>3){
				alert("Security code should be 3 digits");
			}
			if (f == "") {
				alert("Please fill in billing address.");
				return false;
			}
			if (g == "") {
				alert("Please fill in shipping address.");
				return false;
			} 

			
		 	 $.ajax({
				 type: "POST",
		         url: "../Team10-HW3-Bank/Bank",
		         data: { 
		        	 	"cardName" : c,
		        	 	"userCardNum" : d,
		        	 	"userSecurityCode" : e,
		        	 	"userBillingAddress" : f,
		        	 	"expirationDate" : expirationDate,
		        	 	"cardType" : cardType,
		        	 	"total" : total,
		        	 	"userId" : userId
		         },
				 
				 success: function(responseText) {
		             var obj = JSON.parse(responseText);
		             if(!obj.success){
		                 alert(obj.message);
		             }else{
		            	 	alert(obj.message);
		            	 	placeOrder();
		             }

		         }
			 }); 
			 return false;
			}	
			
			function sendData() {
				
				var quant = $("#sel1").val();
			    $.post("AddShoppingCart", {ticketQuantity:quant}, function(data,status) {
			    		if(data == 1){
		    				$("#banner").css("visibility", "visible");
			    			
			    			$("#banner").html("Item Successfully Added to Cart");
			    			setTimeout(function() { 
			    				$("#banner").html(""); 
			    				$("#banner").css("visibility", "hidden");
			    			}, 3000);
			    			
			    		}
					});
			   
			  }
			
			
			//$("#userForm input[type='radio']:checked").val();
			function addReviewData() {
				console.log("works");
				var review = $("#review").val();
				var rating = $("#userForm input[type='radio']:checked").val();
				console.log(review);
				console.log(rating);
			    $.post("CustomerReview", {review:review,rating:rating}, function(data) {
			    		if(data == 1){
			    			location.reload();
			    		}else{
			    			console.log(data);
			    		}
					});
			}		
			
			function getdata() {
				var userName = $("#userName").val();
				var password  = $("#password").val();
				var auth  = $("#auth").val();
				console.log('yes');
			    // Sending request to another app named "FormjQueryResponse"
			    // Before sending request, run the app "FormjQueryResponse" on server first
			    $.post("Login", {userName:userName, password:password,auth:auth}, function(data,status) {
			    

			    		if(data == 1 && auth == 1){
			    			window.location.replace("CustomerTransaction.jsp");
			    		}else if(data == 1 && auth == 2){
			    			window.location.replace("ChangePassword.jsp");	
			    		}
			    		else{
			    			$("#results").html("Invalid Credentials");
			    		return;
			    		}
					});
			   
			  }			