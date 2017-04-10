package md.interportal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by CW
 */
@WebServlet(urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * Get and store request parameters
		 */
		String user = req.getParameter("username");
		String pwd = req.getParameter("password");

		/**
		 * Get context parameters
		 */
		String userParam = getServletContext().getInitParameter("username");
		String passwordParam = getServletContext().getInitParameter("password");

		if (userParam.equals(user) && passwordParam.equals(pwd)) {
			
			//Get session from HttpServletRequest
			HttpSession session = req.getSession();
			//Set a session attribute with name "user" and value user
			session.setAttribute("user", user);
			//Set maximum inactive interval for session in seconds
			session.setMaxInactiveInterval(30 * 60);
			//Create a new cookie with name "user" and value user
			Cookie userCookie = new Cookie("user", user);
			//Set how long cookie will be stored in seconds
			userCookie.setMaxAge(30 * 60);
			//Add cookie to response
			resp.addCookie(userCookie);
			//Redirect to success page
			resp.sendRedirect("success.jsp");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.include(req, resp);
			PrintWriter out = resp.getWriter();
			out.println("<div style=\"color: red; text-align: center; \"> Either user name or password is wrong.</div>");
		}
	}

}
