<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<!-- Link to Bootstrap CSS file -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	
	<script>
		function handleSubjectClick(subjectId) {
			window.location.href = "AcademyServlet?subjectId=" + subjectId;
		}
	</script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
			<a class="navbar-brand mx-auto" href="#">Pozuelo Academy</a>
		</div>
	</nav>
	
	<div class="container mt-5">
	<table class="table table-bordered table-hover">
		<thead class="thead-light">
			<tr>
				<th>Subject id</th>
				<th>Subject name</th>
				<th>Subject credits</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="subject" items="${SUBJECT_LIST}">
			<tr onclick="handleSubjectClick(${subject.subjectId})">
				<td>${subject.subjectId}</td>
				<td>${subject.subjectName}</td>
				<td>${subject.credits}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<!-- Link to Bootstrap JS file -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
