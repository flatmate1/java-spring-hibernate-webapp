<html>
<head></head>

<body>
	<h1>REGISTER</h1>

	<form name='loginForm' action="register" method='POST' modelAttribute='user'>

		<table>
			<tr>
				<td>User:</td>
				<td><input type='username' name='Username'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='Password' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>

	</form>

</body>
</html>