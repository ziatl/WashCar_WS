package fr.wash.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.wash.database.PersistenceManager;
import fr.wash.entities.User;
import fr.wash.interfaces.IWash;

public class WashDaoImpl implements IWash {

	EntityManager em;
	
	public WashDaoImpl() {
		// TODO Auto-generated constructor stub
		em = PersistenceManager.getEntityManager();
	}
	@Override
	public Object addObject(Object object) {
		// TODO Auto-generated method stub
		em = PersistenceManager.getEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(object);
			et.commit();
			em.close();
			return object;
		} catch (Exception e) {
			
			return null;
		}
		
	}
	
	@Override
	public void removeObject(Object object) {
		// TODO Auto-generated method stub
		em = PersistenceManager.getEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(em.contains(object) ? object : em.merge(object));
			et.commit();
			em.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} 
	}
	
	@Override
	public Object findById(Object object, int id) {
		// TODO Auto-generated method stub
		em = PersistenceManager.getEntityManager();
		try {
			return em.find(object.getClass(), id);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	@Override
	public Object updateObject(Object object) {
		// TODO Auto-generated method stub
		em = PersistenceManager.getEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.merge(object);
			et.commit();
			em.close();
			return object;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	@Override
	public List<Object> getAllObject(String object) {
		// TODO Auto-generated method stub
		em = PersistenceManager.getEntityManager();
		Query q = em.createQuery("select o from "+object+" o");
		return q.getResultList();
	}
	
	@Override
	public User login(User user) {
		em = PersistenceManager.getEntityManager();
		Query q = em.createQuery("select u from User u where u.email like :X and u.mdp like :Y");
		q.setParameter("X", user.getEmail());
		q.setParameter("Y", user.getMdp());
		try {
			return (User) q.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception		
			user = new User();
			user.setId(0);
			return user;
		}
		
	}

}
