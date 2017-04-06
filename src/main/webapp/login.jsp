<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<link rel="stylesheet" type="text/css"
	href="./css/bootstrap.min.css" />
</head>
<body>

	<form class="form-horizontal" action="LoginServlet" method="POST">
		<fieldset>

			<!-- Form Name -->
			<legend>Login with Servlet</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="login"></label>
				<div class="col-md-4">
					<input id="username" name="username" type="text" placeholder="Username"
						class="form-control input-md" required="">
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="password"></label>
				<div class="col-md-4">
					<input id="password" name="password" type="password"
						placeholder="Password" class="form-control input-md" required="">

				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="submit"></label>
				<div class="col-md-4">
					<button id="submit" name="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>

		</fieldset>
	</form>

</body>
</html>