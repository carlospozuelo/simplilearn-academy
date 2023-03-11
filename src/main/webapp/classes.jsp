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
	function handleClassClick(id) {
		let url = "StudentServlet";
		if (id !== "") {
			url += "?classId=" + id;
		}
		window.location.href = url;
	}
	</script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container">
    
    <div class="collapse navbar-collapse justify-content-start" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="#" onclick="history.go(-1); return false;">
            <i class="fas fa-arrow-left"></i> Go Back
          </a>
        </li>
      </ul>
    </div>
    <a class="navbar-brand mx-auto flex-grow-1" href="#">${title}</a>
  </div>
</nav>

	<div class="container mt-5">
	<table class="table table-bordered table-hover">
		<thead class="thead-light">

			<tr>
				<th>Class id</th>
				<th>Subject</th>
				<th>Class name</th>
				<th>Start date</th>
				<th>End date</th>
				<th>Attendance</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="classDTO" items="${CLASSES_LIST}">
			<tr>
				<td>${classDTO.id}</td>
				<td>${classDTO.subject.subjectName}</td>
				<td>${classDTO.name}</td>
				<td>${classDTO.startDate}</td>
				<td>${classDTO.endDate}</td>
				<td>
					<button type="button" class="btn btn-link" onclick="handleClassClick(${classDTO.id})">
						<i class="fa fa-eye"></i>
					</button>
				</td>
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
