package fr.demos.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.model.Client;

/**
 * Servlet implementation class ListeClientControleur
 */
@WebServlet("/ListeClientControleur")
public class ListeClientControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeClientControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Client c1 = new Client("toto", "pierre");
c1.setEmail("toto@gmail.com");
Client c2 = new Client("titi", "jacques");
c2.setDateNaissance("27/12/1999");
Client c3 = new Client("tata", "marc");
ArrayList<Client> liste = new ArrayList<>();
liste.add(c1);
liste.add(c2);
liste.add(c3);
request.setAttribute("clients", liste);
RequestDispatcher  rd = request.getRequestDispatcher("/afficheliste.jsp");
		rd.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
