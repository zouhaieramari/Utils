package fr.demos.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AfficheDate
 */
@WebServlet("/AfficheDate")
public class AfficheDate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AfficheDate() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		// r�cup�ration flot de sortie vers r�seau
		PrintWriter out = response.getWriter();
		Date d = new Date();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title> LaDate</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1> Nous sommes le : " + d + "</h1>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			// fin de l'envoi de la r�ponse
			out.close();
		}
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
