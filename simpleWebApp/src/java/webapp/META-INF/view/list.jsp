html, body{
	margin-left:15px; margin-right:15px; 
	padding:0px; 
	font-family:Verdana, Arial, Helvetica, sans-serif;
}

table {   
	border-collapse:collapse;
	border-bottom:1px solid gray;
	font-family: Tahoma,Verdana,Segoe,sans-serif;
	width:72%;
}
 
th {
	border-bottom:1px solid gray;
	background:none repeat scroll 0 0 #09c332;
	padding:10px;
	color: #FFFFFF;
}

tr {
	border-top:1px solid gray;
	text-align:center;	
}
 
tr:nth-child(even) {background: #FFFFFF}
tr:nth-child(odd) {background: #BBBBBB}	
 
#wrapper {width: 100%; margin-top: 0px; }
#header {width: 70%; background: #09c332; margin-top: 0px; padding:15px 0px 15px 15px;}
#header h2 {width: 100%; margin:auto; color: #FFFFFF;}
#container {width: 100%; margin:auto}
#container h3 {color: #000;}
#container #content {margin-top: 20px;}

.add-button {
	border: 1px solid #666; 
	border-radius: 5px; 
	padding: 4px; 
	font-size: 12px;
	font-weight: bold;
	width: 120px; 
	padding: 5px 10px; 
	
	margin-bottom: 15px;
	background: #cccccc;
}

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>



<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->
	<head>
		<link type="text/css"
		  rel="stylesheet"
		  href="/resources/css/style.css" />

	
	<link href="${mainCss}" rel="stylesheet" />

</head>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Category</th>
					<th>Quantity</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempProduct" items="${product}">
				
					<tr>
						<td> ${tempProduct.name} </td>
						<td> ${tempProduct.price} </td>
						<td> ${tempProduct.category} </td>
						<td> ${tempProduct.quantity}
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>








