package admin;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.AttendanceDTO;
import DTO.ClassDTO;

@WebServlet("/StudentServlet")
public class StudentServlet extends AbstractServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		List<AttendanceDTO> list;
		String studentId = request.getParameter("studentId");
		String classId = request.getParameter("classId");
		try {
			
			if (studentId != null) {
				list = getAttendance("student_id="+studentId);
				request.setAttribute("title", "Attendance of: " + getStudents("student_id="+ studentId).get(0).getStudentName() );
			} else if (classId != null) {
				list = getAttendance("class_id="+classId);
				request.setAttribute("title", "Attendance of the class: " + getClasses("class_id="+classId).get(0).getName() );
			} else {
				list = getAttendance("");
				request.setAttribute("title", "All attendance records" );

				
			}
			System.out.println("LIST " + list);
	        request.setAttribute("ATTENDANCE_LIST", list);
	       	        request.getRequestDispatcher("/attendance.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
       

    }
}