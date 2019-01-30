<html>
<head></head>

<body>
	<h1>REGISTER</h1>

	<form name='loginForm' action="register" method='POST' modelAttribute='account'>

		<table>
			<tr>
				<td>User:</td>
				<td><input type='username' name='username'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>

	</form>

</body>
</html>