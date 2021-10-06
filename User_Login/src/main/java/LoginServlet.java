
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBUtils.DBConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String sql = "SELECT * FROM user";

		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = DBConnection.connect();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {

				String name = rs.getString(2);
				String uname = rs.getString(3);
				String pass = rs.getString(4);
				String role = rs.getString(5);

				if (uname.equals(username) && pass.equals(password)) {

					if (role.equals("owner")) {
						response.sendRedirect("owner.jsp");
						HttpSession session = request.getSession();

						session.setAttribute("name", name);
					} else if (role.equals("admin")) {
						response.sendRedirect("admin.jsp");
						HttpSession session = request.getSession();

						session.setAttribute("name", name);
					} else if (role.equals("assistant")) {
						response.sendRedirect("assistant.jsp");
						HttpSession session = request.getSession();

						session.setAttribute("name", name);
					} else {
						System.out.println("Username and password is invalided");
					}
				}
				else {
					
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
