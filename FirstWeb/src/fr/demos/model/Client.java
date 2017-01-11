package fr.demos.model;
//.......................
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//................
@Entity
//......................
@Table(name="Client")
//................
public class Client  implements Serializable{
	//..................
	private static final long serialVersionUID = 1L;
	//.....................nullable= false... un champ obligatoire n est pas etre null
	@Column (name= "nom", nullable= false)
	private String nom;
	@Column (name= "prenom")
	private String prenom;
	//..................@Id... c d a l email est l ID le cle primaire
	@Id
	@Column (name= "email")
	private String email;
	@Column (name= "dateNaissance")
	private String dateNaissance;
	//...............
	protected Client() {
		
	}
	
	
	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public Client(String nom, String prenom, String email, String dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email= email;
		this.dateNaissance= dateNaissance;
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
