package admin;

import java.io.IOException;
import java.util.List;

import DTO.StudentDTO;
import DTO.SubjectDTO;
import DTO.TeacherDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AcademyServlet")
public class AcademyServlet extends AbstractServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
		List<SubjectDTO> subjectList;
		try {

			subjectList = getSubjects("");
	        request.setAttribute("SUBJECT_LIST", subjectList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<TeacherDTO> teachers;
		try {

			teachers = getTeachers("");
	        request.setAttribute("TEACHER_LIST", teachers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<StudentDTO> students;
		try {

			students = getStudents("");
	        request.setAttribute("STUDENT_LIST", students);

		} catch (Exception e) {
			e.printStackTrace();
		}
        request.getRequestDispatcher("/schedule.jsp").forward(request, response);

    }
	

	

	
	
}
