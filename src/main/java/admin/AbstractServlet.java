package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DTO.AttendanceDTO;
import DTO.ClassDTO;
import DTO.EnrollmentDTO;
import DTO.ExamDTO;
import DTO.StudentDTO;
import DTO.SubjectDTO;
import DTO.TeacherDTO;

public abstract class AbstractServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/pozuelo_academy")
	protected DataSource datasource;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!getAuth(request)) {

			response.sendRedirect("login.jsp");
		}
	}
	
	private boolean getAuth(HttpServletRequest request) {

		Cookie[] cookies = request.getCookies();
		// Find the cookie of interest in arrays of cookies
		for (Cookie cookie : cookies) {
			 
			if (cookie.getName().equals("auth") && cookie.getValue().equals("true")) {
				return true;
			} 

		}
		
		
		return false;

	}
	
	
	public List<TeacherDTO> getTeachers(String where) throws SQLException {
		List<TeacherDTO> list = new ArrayList<>();
		Connection connection = datasource.getConnection();
		ResultSet result = executeQuery(connection, formQuery("SELECT teacher_id, teacher_name, teacher_email FROM  teachers", where));
		
		if (result == null) {
			// Exception handling will be a part of future versions
			return null;
		}
		
		while (result.next()) {
			int id = result.getInt(1);
			String name = result.getString(2);
			String email = result.getString(3);
			
			list.add(new TeacherDTO(id, name, email));
		}
		connection.close();
		return list;
	}
	
	
	public List<EnrollmentDTO> getEnrollment(String where) throws SQLException {
		List<EnrollmentDTO> list = new ArrayList<>();
		Connection connection = datasource.getConnection();
		ResultSet result = executeQuery(connection, formQuery("SELECT enrollment_id, student_id, subject_id FROM  enrollment", where));
		
		if (result == null) {
			// Exception handling will be a part of future versions
			return null;
		}
		
		while (result.next()) {
			int id = result.getInt(1);
			int student_id = result.getInt(2);
			int subject_id = result.getInt(3);
			
			StudentDTO student = getStudents("student_id="+student_id).get(0);
			SubjectDTO subjectDTO = getSubjects("subject_id="+subject_id).get(0);
			
			list.add(new EnrollmentDTO(id, student, subjectDTO));
		}
		connection.close();
		return list;
	}
	
	public List<ExamDTO> getExams(String where) throws SQLException {
		List<ExamDTO> list = new ArrayList<>();
		Connection connection = datasource.getConnection();
		ResultSet result = executeQuery(connection, formQuery("SELECT exam_id, exam_grade, exam_date, enrollment_id FROM  enrollment", where));
		
		if (result == null) {
			// Exception handling will be a part of future versions
			return null;
		}
		
		while (result.next()) {
			int id = result.getInt(1);
			int grade = result.getInt(2);
			LocalDate exam_date = result.getDate(3).toLocalDate();
			int enrollment_id = result.getInt(4);
			
			EnrollmentDTO enrollmentDTO = getEnrollment("enrollment_id="+enrollment_id).get(0);
			
			list.add(new ExamDTO(id, grade, exam_date, enrollmentDTO));
		}
		connection.close();
		return list;
	}
	
	
	
	public static String formQuery(String query, String where) {
		if (where.isBlank()) {
			return query;
		}
		return query + " WHERE " + where;
	}
	
	private ResultSet executeQuery(Connection connection, String query) {
		try {
			
			Statement statement = connection.createStatement();
			
			return statement.executeQuery(query);
		} catch (Exception e) {
			// Exception handling will be a part of future versions
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<ClassDTO> getClasses(String where) throws SQLException {
		List<ClassDTO> list = new ArrayList<>();
		Connection connection = datasource.getConnection();
		ResultSet result = executeQuery(connection, formQuery("SELECT class_id, subject_id, class_name, class_start_date, class_end_date  FROM  classes", where));
		
		if (result == null) {
			// Exception handling will be a part of future versions
			return null;
		}
		
		while (result.next()) {
			int id = result.getInt(1);
			int subject_id = result.getInt(2);
			
			SubjectDTO subjectDTO = getSubjects("subject_id="+subject_id).get(0);
			
			String name = result.getString(3);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime start = LocalDateTime.parse(result.getString(4), formatter);
			LocalDateTime end = LocalDateTime.parse(result.getString(5), formatter);
			
			list.add(new ClassDTO(id, subjectDTO, name, start, end));
		}
		connection.close();
		return list;
	}
	
	public List<SubjectDTO> getSubjects(String where) throws SQLException {
		List<SubjectDTO> list = new ArrayList<>();
		Connection connection = datasource.getConnection();
		ResultSet result = executeQuery(connection, formQuery("SELECT subject_id, subject_name, credits FROM  subjects", where));
		
		if (result == null) {
			// Exception handling will be a part of future versions
			return null;
		}
		
		while (result.next()) {
			int id = result.getInt(1);
			String name = result.getString(2);
			Integer credits = result.getInt(3);
			
			list.add(new SubjectDTO(id, name, credits));
		}
		connection.close();
		return list;
	}
	
	public List<AttendanceDTO> getAttendance(String where) throws SQLException {
		List<AttendanceDTO> list = new ArrayList<>();
		Connection connection = datasource.getConnection();
		ResultSet result = executeQuery(connection, formQuery("SELECT student_id, class_id FROM  attendance", where));
		
		if (result == null) {
			// Exception handling will be a part of future versions
			return null;
		}
		
		while (result.next()) {
			int student_id = result.getInt(1);
			int class_id = result.getInt(2);
			
			StudentDTO student = getStudents("student_id="+student_id).get(0);
			ClassDTO classDTO = getClasses("class_id="+class_id).get(0);
			
			list.add(new AttendanceDTO(student, classDTO));
		}
		connection.close();
		return list;
	}
	
	public List<StudentDTO> getStudents(String where) throws SQLException {
		List<StudentDTO> list = new ArrayList<>();
		Connection connection = datasource.getConnection();
		ResultSet result = executeQuery(connection, formQuery("SELECT student_id, student_name, student_email FROM  students", where));
		
		if (result == null) {
			// Exception handling will be a part of future versions
			return null;
		}
		
		while (result.next()) {
			int id = result.getInt(1);
			String name = result.getString(2);
			String email = result.getString(3);
			
			list.add(new StudentDTO(id, name, email));
		}
		connection.close();
		return list;
	}
}
