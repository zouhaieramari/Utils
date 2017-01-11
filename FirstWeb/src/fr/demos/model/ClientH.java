

package fr.demos.model;

public class ClientH {
	
	
	private String nom;
	private String prenom;
	private String email;
	private String dateNaissance;
	//........... version sans hubernate.............................
	
	public ClientH(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public ClientH(String nom, String prenom, String email, String dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email= email;
		this.dateNaissance= dateNaissance;
	}
	
	
	public ClientH() {
		super();
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	

}
