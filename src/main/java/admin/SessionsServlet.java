package admin;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ClassDTO;

@WebServlet("/SessionsServlet")
public class SessionsServlet extends AbstractServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		List<ClassDTO> list;
		try {
			String subject_id = request.getParameter("subjectId");
			if (subject_id == null) {
				list = getClasses("");
			} else {

				list = getClasses("subject_id="+subject_id);
			}
			System.out.println("LIST " + list);
	        request.setAttribute("CLASSES_LIST", list);
	        request.setAttribute("title", subject_id == null? "All classes" : "Classes of: " + getSubjects("subject_id="+ subject_id).get(0).getSubjectName() );
	        request.getRequestDispatcher("/classes.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
       

    }
}
