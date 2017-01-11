package fr.demos.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

import fr.demos.model.Client;
import fr.demos.web.dao;

@dao
public class ClientDaoJpaMysql  implements ClientDao{
// glassfish injecte la valeur de em lors de la creation de l instance ClientDaoJpaMysql ne peut fonctionner que si ClientDaoJpaMysql 
	//est cree pas glassfish ( c est glassfish qui fait le new)
	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	
	public ClientDaoJpaMysql()
	{
		
	}
	
	public void insert(Client c) throws Exception {
		System.out.println("message$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

		
		ut.begin();
		em.persist(c);
		ut.commit();
		
	}
	
	@Override
	public List<Client> select(String critere) throws Exception {
		String query = "select cli from Client cli";
		TypedQuery<Client> q = em.createQuery(query, Client.class);
		
		return q.getResultList();
	}
	
	@Override
	public void update(Client c) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String email) throws Exception {
		// TODO Auto-generated method stub
		
	}



}
