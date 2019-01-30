<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%> 
<html>
<head>
<title>Login Page</title>
<link rel="stylesheet"
	href="<c:url value="/resource/css/register.css"/>">


<link href="<c:url value="/resource/css/register.css" />" rel="stylesheet">

</head>
<body>

	<h1 class="register-text">Spring Security register Form *TODO*(Database Authentication)</h1>


	<div class="register-window">
			<form name='forgotPasswordForm' action="forgot-passwordProcess" method='POST' modelAttribute='forgotPassword'>
			  <div class="container">
			    <h1>Sign Up</h1>
			    <p>Please fill in this form to create an account.</p>
			    <hr>
			
			    <label for="email"><b>email</b></label>
			    <input type="text" placeholder="Enter email" name="email" required>

				
				
				<!-- TODO!!!!
				
				
				- repeat password check
				
				

				 
			    <label for="psw-repeat"><b>Repeat Password</b></label>
			    <input type="password" placeholder="Repeat Password" name="password-repeat" required>
			
			    <label>
			      <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
			    </label>
			    
				 -->		
				 
			    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>
			
			    <div class="clearfix">
			      <button type="button" class="cancelbtn">Cancel</button>
			      <button type="submit" class="signupbtn">Sign Up</button>
			    </div>
			  </div>
			</form>
			            <table align="center">

                <tr>

                    <td style="font-style: italic; color: red;">${message}</td>

                </tr>

            </table>
			</div>
	


</body>
</html>