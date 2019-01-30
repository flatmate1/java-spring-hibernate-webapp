<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>
<%@ include file="navbar.jsp"%> 
<html>
<head>
<title>Login Page</title>
<link rel="stylesheet"
	href="<c:url value="/resource/css/login.css"/>">


<link href="<c:url value="/resource/css/login.css" />" rel="stylesheet">

</head>
<body>

	<h1 class=>Spring Security Login Form (Database Authentication)</h1>


	<div class="ex1">

		<h2>Login with Username and Password</h2>

		  <form name='loginForm'
		  		action="<c:url value='' />" method='POST'>
		  <div class="imgcontainer">
		  
		    <img src="<c:url value="/resource/image/img_avatar2.png"/>" >
		  </div>
		
		  <div class="container">
		    <label for="username"><b>username</b></label>
		    <input type="text" placeholder="Enter Username" name="username" required>
		
		    <label for="password"><b>password</b></label>
		    <input type="password" placeholder="Enter Password" name="password" required>
		
		    <button type="submit">Login</button>
		    <label>
		      <input type="checkbox" checked="checked" name="remember"> Remember me
		    </label>
		   
		    
		  </div>
		</form>
		<div class="container_register">
		<form name='loginForm'
		  		action="<c:url value='register' />" method='GET'>
		  		<button class="register-button" type="submit">Register</button>
		  		</form>
		</div>
		
		<!-- TODO
		-Forgot passowrd
		 -->
			<div class="container" style="background-color:#f1f1f1">
		    
		    <span class="psw">Forgot <a href="#">password?</a></span>
		  </div>
	</div>
	
	
<%@ include file="footer.jsp"%> 

</body>
</html>