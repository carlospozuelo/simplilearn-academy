<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<!-- Link to Bootstrap CSS file -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
			<a class="navbar-brand mx-auto" href="#">Admin Login</a>
		</div>
	</nav>
	<div class="container mt-5">
		<form action="LoginServlet" method="POST">
			<div class="form-group">
				<label>Username:</label>
				<input type="text" class="form-control" placeholder="Enter Username" name="username" required>
			</div>
			<div class="form-group">
				<label>Password:</label>
				<input type="password" class="form-control" placeholder="Enter Password" name="password" required>
			</div>
			<div class="form-group form-check">
				<input type="checkbox" class="form-check-input" checked="checked">
				<label class="form-check-label">Remember me</label>
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
	<!-- Link to Bootstrap JS file -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>