package com.smithsiciliano.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.smithsiciliano.models.Stores;
import com.smithsiciliano.models.Transactions;
import com.smithsiciliano.util.HibernateUtil;

public class TransactionsDAO {
	
	public List<Transactions> select() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	    
		Query query = session.createQuery("from Transactions");
		List<Transactions> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public List<Transactions> selectByLocation(Stores sLocation) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Transactions transaction where transaction.storeLoc=:transaction_STORELOC");
		query.setParameter("transaction_STORELOC", sLocation);
		List<Transactions> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public boolean insert(Transactions[] transactions) {
		boolean retVal = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			for(Transactions transaction : transactions) {
				session.save(transaction);
			}

			session.getTransaction().commit();
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean update(Transactions oldTransaction, Transactions newTransaction) {
		boolean retVal = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("from Transactions transaction "
					+ "where transaction.storeLoc=:transaction_STORELOC "
					+ "AND transaction.foodItem=:transaction_FOODITEM");
			query.setParameter("transaction_STORELOC", oldTransaction.getStoreLoc());
			query.setParameter("transaction_FOODITEM", oldTransaction.getFoodItem());
			List<Transactions> list = query.list();
			
			Transactions transaction = list.get(0);

			transaction.setFoodItem(newTransaction.getFoodItem());
			transaction.setPrice(newTransaction.getPrice());
			transaction.setStoreLoc(newTransaction.getStoreLoc());
	
			session.getTransaction().commit();
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}
	
	public void delete(Transactions transaction) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.delete(transaction);
		
		session.getTransaction().commit();
		session.close();
	}
}