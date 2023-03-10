package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		/* To be updated future versions */
		if (username != null && password != null && username.equals("admin") && password.equals(username)) {
			Cookie cookie = new Cookie(username, password);
			
			cookie.setMaxAge(86400);
			resp.addCookie(cookie);
			
			resp.sendRedirect("AcademyServlet");
		}
		else resp.sendRedirect("login.jsp");
	}

}