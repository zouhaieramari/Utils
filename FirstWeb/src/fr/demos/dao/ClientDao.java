package fr.demos.dao;

import fr.demos.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
public interface ClientDao {
	
	// specification 
	void insert(Client c)  throws Exception;
	void update(Client c)  throws Exception;
	void delete(String email)  throws Exception;
	List<Client> select (String critere)  throws Exception;

}



