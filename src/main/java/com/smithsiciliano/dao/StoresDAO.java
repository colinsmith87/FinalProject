package com.smithsiciliano.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.smithsiciliano.models.Stores;
import com.smithsiciliano.util.HibernateUtil;

public class StoresDAO {
	
	public List<Stores> select() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	    
		Query query = session.createQuery("from Stores");
		List<Stores> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public List<Stores> selectByLocation(String sLocation) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Stores store where store.sLocation=:store_SLOCATION");
		query.setParameter("store_SLOCATION", sLocation);
		List<Stores> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public boolean insert(Stores store) {
		boolean retVal = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.save(store);

			session.getTransaction().commit();
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean update(Stores oldStore, Stores newStore) {
		boolean retVal = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("from Stores store where store.sLocation=:store_SLOCATION");
			query.setParameter("store_SLOCATION", oldStore.getsLocation());
			List<Stores> list = query.list();
			
			Stores store = list.get(0);

			store.setsLocation(newStore.getsLocation());
	
			session.getTransaction().commit();
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}
	
	public void delete(Stores store) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.delete(store);
		
		session.getTransaction().commit();
		session.close();
	}
}