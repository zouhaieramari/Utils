package fr.demos.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.inject.Inject;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.dao.ClientDao;
import fr.demos.dao.ClientDaoJdbcMySQL;
import fr.demos.dao.ClientDaoJpaMysql;
import fr.demos.model.Client;
import fr.demos.model.Compteur;

/**
 * Servlet implementation class ClientController
 */
@WebServlet("/ClientController")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// todo instancier dao

	///////////// ...................................... version hubernate
	// private ClientDao dao;
	// ///////////////...................................vesrion sans hibernate
	@Inject
	@dao
	private ClientDao dao;

	/**
	 * @throws NamingException
	 * @throws ServletException
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientController() throws NamingException, ServletException {
		super();
		// version hibernat on doit metre ClientDaoJpaMysql
		// dao = new ClientDaoJpaMysql();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("/formclient.jsp");
		rd.forward(request, response);

		// session
		HttpSession session = request.getSession();
		Compteur compteur = (Compteur) session.getAttribute("compteur");
		if (compteur == null) {
			compteur = new Compteur();
			session.setAttribute("compteur", compteur);

		}
		compteur.incremente();

		////

		// HttpSession session = request.getSession();
		// Integer compteur = (Integer)session.getAttribute("compteur");
		// if (compteur == null)
		// {
		// // l autoboxing
		// compteur=1;
		// session.setAttribute("compteur", compteur);
		// }
		// else
		// {
		// // l autoboxing
		//
		// compteur++;
		// // attention l int est oncrementer mais pas le compteur dans la
		// session
		//
		// session.setAttribute("compteur", compteur);
		// }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Compteur compteur = (Compteur) session.getAttribute("compteur");
		if (compteur == null) {
			compteur = new Compteur();
			session.setAttribute("compteur", compteur);

		}
		compteur.incremente();

		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String headerName = headers.nextElement();
			System.out.println(headerName + ":" + request.getHeader(headerName));

		}

		String action = request.getParameter("boutonaction");
	
		if (action != null && action.equals("Ajouter")) {
			boolean saisieOK = true;
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String dateNaissance = request.getParameter("dateNaissance");
			String email = request.getParameter("email");

			System.out.println(nom + " " + prenom + " " + dateNaissance + " " + email);
			// conversion
			// try {
			// int age = Integer.parseInt(age);
			// } catch (NumberFormatException e) {

			// saisieOK = false;
			// }
			// metier

			// validation
			if (nom == null || nom.equals("")) {
				saisieOK = false;
				request.setAttribute("erreurNOM", "le nom est obligatoire");
			}
			if (prenom == null || prenom.equals("")) {
				saisieOK = false;
				request.setAttribute("erreurPRENOM", "le prenom est obligatoire");
			}
			if (dateNaissance == null || dateNaissance.equals("")) {
				saisieOK = false;
				request.setAttribute("erreurAGE", "l age  est obligatoire");
			}
			if (email == null || email.equals("")) {
				saisieOK = false;
				request.setAttribute("erreurEMAIL", "l email  est obligatoire");
			}
			if (saisieOK) {
				Client c = new Client(nom, prenom, email, dateNaissance);
				// on attendant la sauvgarde ds la base, stockage ds une liste
				// en memoire
				//////////// ...............................
				// ArrayList<Client> listeClients =
				// (ArrayList<Client>)session.getAttribute("listeClients");

				// listeClients.add(c);
				////////////////////// ....................
				// ..................................................................................................
				System.out.println(" message test ......................");
				try {
					dao.insert(c);
				} catch (Exception e) {
					// utile pour debugger et c est touta retire en fonction
					e.printStackTrace();
					System.out.println(e.getMessage());
					request.setAttribute("erreurDao", "erreur impossible de cree user " + e.getMessage());
				}
				// ....................................

				List<Client> listeClients = null;
				try {
					listeClients = dao.select(null);
					session.setAttribute("listeClients", listeClients);
				} catch (Exception e) {
					// utile pour debugger et c est touta retire en fonction
					e.printStackTrace();
					System.out.println(e.getMessage());
					request.setAttribute("erreurRecheche", e.getMessage());
				}

				// ......................................
				// allimentation de la liste clients depuis la base
				//
				// transfer d info entre controller et vue au moyen de la
				// requete
				// ..........................................................................................
				request.setAttribute("clientAttr", c);
				RequestDispatcher rd = request.getRequestDispatcher("/afficheliste.jsp");
				rd.forward(request, response);

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/formclient.jsp");
				rd.forward(request, response);
			}

		}

	}

}
