package com.smithsiciliano.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.smithsiciliano.models.Food;
import com.smithsiciliano.models.InStock;
import com.smithsiciliano.models.Stores;
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
	
	public List<InStock> selectByFoodName(Food food) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Query query = session.createQuery("from InStock stock "
				+ "where stock.foodName=:stock_FOODNAME");
		query.setParameter("stock_FOODNAME", food);
		List<InStock> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public List<InStock> selectByFoodNameAndStoreLocation(Food foodName, Stores storeLoc) {
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

	public boolean insert(InStock[] stocks) {
		boolean retVal = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			for(InStock stock : stocks) {
				session.save(stock);
			}

			session.getTransaction().commit();
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean update(InStock[] stocks) {
		boolean retVal = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("from InStock stock "
					+ "where stock.storeLoc=:stock_STORELOC");
			query.setParameter("stock_STORELOC", stocks[0].getStoreLoc());
			List<InStock> list = query.list();

			for(InStock oldStock : list) {
				for(int i = 0; i < stocks.length; i++) {
					if(oldStock.getFoodName().equals(stocks[i].getFoodName())) {
						oldStock.setFoodName(stocks[i].getFoodName());
						oldStock.setQuantity(oldStock.getQuantity()+stocks[i].getQuantity());
						oldStock.setStoreLoc(stocks[i].getStoreLoc());
					}
				}
			}

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
			query.setParameter("stock_STORELOC", oldStock.getStoreLoc());
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