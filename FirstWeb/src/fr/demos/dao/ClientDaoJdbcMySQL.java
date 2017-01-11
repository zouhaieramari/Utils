package fr.demos.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.demos.model.Client;

public class ClientDaoJdbcMySQL implements ClientDao {
	private DataSource ds;

	public ClientDaoJdbcMySQL() {
		try {
			Context ic = new InitialContext();
			// je vais chercher le pool
			ds = (DataSource) ic.lookup("jdbc/Cinema");

		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insert(Client c) throws Exception {
		// TODO Auto-generated method stub
		Connection cx = null;
		try {

			// je pioche une connection dans le pool
			cx = ds.getConnection();
			String sql = "INSERT INTO Client VALUES(?,?,?,?)";
			PreparedStatement psmt = cx.prepareStatement(sql);
			psmt.setString(1, c.getNom());
			psmt.setString(2, c.getPrenom());
			psmt.setString(3, c.getEmail());
			psmt.setString(4, c.getDateNaissance());
			psmt.executeUpdate();

		} finally {
			if (cx != null)
				cx.close();
		}

	}

	public List<Client> select(String critere) throws Exception {

		 ArrayList<Client> liste=null;
	//	ArrayList<Client> liste = new ArrayList<Client>();
		Connection cx = null;
		try {

			// je pioche une connection ds le pool
			cx = ds.getConnection();
			String sql = "SELECT * FROM Client";
			PreparedStatement psmt = cx.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();

			 liste = new ArrayList<>();

			// je boucle sur tout les enrigistrement tropuver
			while (rs.next()) {
				// on recupere colone par colone et on fait la conversation en
				// type java
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String dateNaissance = rs.getString("dateNaissance");
				// je cre� un client
				Client c = new Client(nom, prenom, email, dateNaissance);
				liste.add(c);

			}

		} finally {
			if (cx != null)
				cx.close();

		}

		return liste;
	}

	@Override
	public void update(Client c) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String email) throws Exception {
		// TODO Auto-generated method stub

	}

	// ......................................................................

	// @Override
	// public List<Client> select(String critere) throws Exception {
	// List<Client> clients= new ArrayList<Client>();
	//
	// Connection cx=null;
	// try {
	//
	// // je pioche une connection ds le pool
	// cx= ds.getConnection();
	// String sql = "SELECT * FROM Client WHERE nom like ?";
	// PreparedStatement psmt = cx.prepareStatement(sql);
	// psmt.setString(1, "%"+critere+"%");
	// ResultSet rs = psmt.executeQuery();
	// while (rs.next())
	// {
	// Client c = new Client();
	//
	// psmt.setString(1, c.getNom());
	// psmt.setString(2, c.getPrenom());
	// psmt.setString(3, c.getEmail());
	// psmt.setString(4, c.getDateNaissance());
	// clients.add(c);
	// }
	//
	// } catch (Exception e)
	// {
	// e.printStackTrace();
	// }
	//
	// return clients;
	// }
	//

	// ...................................................................

	// public void selection() throws SQLException
	// {
	// Connection cx=null;
	// try {
	//
	// // je pioche une connection ds le pool
	// cx= ds.getConnection();
	// String sql = "SELECT * FROM Client";
	// PreparedStatement psmt = cx.prepareStatement(sql);
	// ResultSet rs=psmt.executeQuery();
	// while (rs.next())
	// {
	// rs.getString("nom");
	// rs.getString("prenom");
	// rs.getString("email");
	// rs.getString("dateNaissance");
	//
	// System.out.println(rs.getString("nom")+"\t"+rs.getString("prenom")+"\t"+rs.getString("email")+"\t"+rs.getString("dateNaissance")+"\t");
	// }
	// }
	// finally {
	// if(cx!=null)
	// cx.close();
	// }
	//
	// }

}
