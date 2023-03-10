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

import DTO.AttendanceDTO;
import DTO.ClassDTO;
import DTO.EnrollmentDTO;
import DTO.ExamDTO;
import DTO.StudentDTO;
import DTO.SubjectDTO;
import DTO.TeacherDTO;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/AcademyServlet")
public class AcademyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/pozuelo_academy")
	private DataSource datasource;
	
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SubjectDTO> subjectList;
		try {
			subjectList = getSubjects("");
			System.out.println("LIST " + subjectList);
	        request.setAttribute("SUBJECT_LIST", subjectList);
	        request.getRequestDispatcher("/schedule.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
       

    }
	

	
	public List<StudentDTO> getStudents(String where) throws SQLException {
		List<StudentDTO> list = new ArrayList<>();
		ResultSet result = executeQuery(formQuery("SELECT student_id, student_name, student_email FROM  students", where));
		
		if (result == null) {
			// Exception handling will be a part of future versions
			return null;
		}
		
		while (result.next()) {
			int id = result.getInt(0);
			String name = result.getString(1);
			String email = result.getString(2);
			
			list.add(new StudentDTO(id, name, email));
		}
		
		return list;
	}
	
	public List<SubjectDTO> getSubjects(String where) throws SQLException {
		List<SubjectDTO> list = new ArrayList<>();
		ResultSet result = executeQuery(formQuery("SELECT subject_id, subject_name, credits FROM  subjects", where));
		
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
		
		return list;
	}
	
	public List<TeacherDTO> getTeachers(String where) throws SQLException {
		List<TeacherDTO> list = new ArrayList<>();
		ResultSet result = executeQuery(formQuery("SELECT teacher_id, teacher_name, teacher_email FROM  teachers", where));
		
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
		
		return list;
	}
	
	public List<ClassDTO> getClasses(String where) throws SQLException {
		List<ClassDTO> list = new ArrayList<>();
		ResultSet result = executeQuery(formQuery("SELECT class_id, subject_id, class_name, class_start_date, class_end_date  FROM  teachers", where));
		
		if (result == null) {
			// Exception handling will be a part of future versions
			return null;
		}
		
		while (result.next()) {
			int id = result.getInt(1);
			int subject_id = result.getInt(2);
			
			SubjectDTO subjectDTO = getSubjects("subject_id="+subject_id).get(0);
			
			String name = result.getString(3);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
			LocalDateTime start = LocalDateTime.parse(result.getString(subject_id), formatter);
			LocalDateTime end = LocalDateTime.parse(result.getString(subject_id), formatter);
			
			list.add(new ClassDTO(id, subjectDTO, name, start, end));
		}
		
		return list;
	}
	
	public List<AttendanceDTO> getAttendance(String where) throws SQLException {
		List<AttendanceDTO> list = new ArrayList<>();
		ResultSet result = executeQuery(formQuery("SELECT student_id, class_id FROM  attendance", where));
		
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
		
		return list;
	}
	
	public List<EnrollmentDTO> getEnrollment(String where) throws SQLException {
		List<EnrollmentDTO> list = new ArrayList<>();
		ResultSet result = executeQuery(formQuery("SELECT enrollment_id, student_id, subject_id FROM  enrollment", where));
		
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
		
		return list;
	}
	
	public List<ExamDTO> getExams(String where) throws SQLException {
		List<ExamDTO> list = new ArrayList<>();
		ResultSet result = executeQuery(formQuery("SELECT exam_id, exam_grade, exam_date, enrollment_id FROM  enrollment", where));
		
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
		
		return list;
	}
	
	
	
	private String formQuery(String query, String where) {
		if (where.isBlank()) {
			return query;
		}
		return query + "WHERE " + where;
	}
	
	private ResultSet executeQuery(String query) {
		try {
			Connection connection = datasource.getConnection();
			Statement statement = connection.createStatement();
			
			return statement.executeQuery(query);
		} catch (Exception e) {
			// Exception handling will be a part of future versions
			e.printStackTrace();
		}
		
		return null;
	}
}
