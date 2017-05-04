package com.smithsiciliano.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.smithsiciliano.models.InStock;
import com.smithsiciliano.util.HibernateUtil;

public class InStockDAO {
	
	public List<InStock> select() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	    
		Query query = session.createQuery("from InStock");
		List<InStock> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public List<InStock> selectByFoodNameAndStoreLocation(String foodName, String storeLoc) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from InStock stock "
				+ "where stock.foodName=:stock_FOODNAME "
				+ "AND stock.storeLoc=:stock_STORELOC");
		query.setParameter("stock_FOODNAME", foodName);
		query.setParameter("stock_STORELOC", storeLoc);
		List<InStock> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public boolean insert(InStock stock) {
		boolean retVal = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.save(stock);

			session.getTransaction().commit();
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean update(InStock oldStock, InStock newStock) {
		boolean retVal = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("from InStock stock "
					+ "where stock.foodName=:stock_FOODNAME "
					+ "AND stock.storeLoc=:stock_STORELOC");
			query.setParameter("stock_FOODNAME", oldStock.getFoodName());
			query.setParameter("stack_STORELOC", oldStock.getStoreLoc());
			List<InStock> list = query.list();
			
			InStock stock = list.get(0);

			stock.setFoodName(newStock.getFoodName());
			stock.setQuantity(newStock.getQuantity());
			stock.setStoreLoc(newStock.getStoreLoc());
		
			session.getTransaction().commit();
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}
	
	public void delete(InStock stock) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.delete(stock);
		
		session.getTransaction().commit();
		session.close();
	}
}