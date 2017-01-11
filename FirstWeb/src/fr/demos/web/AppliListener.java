package fr.demos.web;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import fr.demos.model.Client;
import fr.demos.model.Compteur;

/**
 * Application Lifecycle Listener implementation class AppliListener
 *
 */
@WebListener
public class AppliListener implements ServletContextListener, HttpSessionListener {
private Compteur compteur;
    /**
     * Default constructor. 
     */
    public AppliListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
        // code declenche la premier fois que l utilisateur va sur le site
    	// compteur ++
    	this.compteur.incremente();
    	// cree la liste ou on va stocker les cliens ajouter
    	ArrayList<Client> liste = new ArrayList<>();
    	HttpSession session = arg0.getSession();
    	session.setAttribute("listeClients", liste);
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
        // code declenche quand la session discparait (apres timeout)
    	// la session n est supprime qu apres l excution de cette methode
    	// compteur--
    	this.compteur.decremente();
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
      // creation et initialisation de compteur
    	// code lancer au demarage de l application (publish)
    	 this.compteur = new Compteur();
    	 ServletContext sc = arg0.getServletContext();
    	 // stocker le compteur dans le contxte
    	 sc.setAttribute("compteurutilisateur", compteur);
    	 
    }
	
}
