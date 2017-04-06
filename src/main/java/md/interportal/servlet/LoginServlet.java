package md.interportal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		 * Get parameters
		 */
		String userParam = getServletContext().getInitParameter("username");
		String passwordParam = getServletContext().getInitParameter("password");

		if (userParam.equals(user) && passwordParam.equals(pwd)) {
			resp.sendRedirect("success.jsp");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			PrintWriter out = resp.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(req, resp);
		}
	}

}
