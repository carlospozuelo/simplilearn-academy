<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<!-- Link to Bootstrap CSS file -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<!-- Link to Font Awesome CSS file -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" />
	
<script>
	function handleSubjectClick(subjectId) {
		let url = "SessionsServlet";
		if (subjectId !== "") {
			url += "?subjectId=" + subjectId;
		}
		window.location.href = url;
	}

	function handleStudentClick(studentId) {
		let url = "StudentServlet";
		if (studentId !== "") {
			url += "?studentId=" + studentId;
		}
		window.location.href = url;
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
<thead class="thead-light text-center">
		<tr>
			<th colspan="4">
				<h2 class="d-inline mb-0"><a href="#" onclick="handleSubjectClick('')">All subjects</a></h2>
			</th>
		</tr>
		<tr>
			<th>Subject id</th>
			<th>Subject name</th>
			<th>Subject credits</th>
			<th>Classes</th>
		</tr>
	</thead>
		<tbody>
			<c:forEach var="subject" items="${SUBJECT_LIST}">
			<tr>
				<td>${subject.subjectId}</td>
				<td>${subject.subjectName}</td>
				<td>${subject.credits}</td>
				<td>
					<button type="button" class="btn btn-link" onclick="handleSubjectClick(${subject.subjectId})">
						<i class="fa fa-eye"></i>
					</button>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

	<table class="table table-bordered table-hover">
	<thead class="thead-light text-center">
		<tr>
			<th colspan="4">
				<h2 class="d-inline mb-0"><a href="#" onclick="handleStudentClick('')">All students</a></h2>
			</th>
		</tr>
		<tr>
			<th>Student id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Attendance</th>
		</tr>
	</thead>
		<tbody>
			<c:forEach var="student" items="${STUDENT_LIST}">
			<tr>
				<td>${student.studentId}</td>
				<td>${student.studentName}</td>
				<td>${student.studentEmail}</td>
				<td>
					<button type="button" class="btn btn-link" onclick="handleStudentClick(${student.studentId})">
						<i class="fa fa-eye"></i>
					</button>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table class="table table-bordered table-hover">
	<thead class="thead-light text-center">
		<tr>
			<th colspan="4">
				<h2 class="d-inline mb-0"><a href="#" onclick="handleStudentClick('')">All teachers</a></h2>
			</th>
		</tr>
		<tr>
			<th>Student id</th>
			<th>Name</th>
			<th>Email</th>
		</tr>
	</thead>
		<tbody>
			<c:forEach var="teacher" items="${TEACHER_LIST}">
			<tr>
				<td>${teacher.teacherId}</td>
				<td>${teacher.teacherName}</td>
				<td>${teacher.teacherEmail}</td>
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
