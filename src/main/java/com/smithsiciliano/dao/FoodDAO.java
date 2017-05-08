package com.smithsiciliano.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.smithsiciliano.models.Food;
import com.smithsiciliano.util.HibernateUtil;

public class FoodDAO {

	public List<Food> select() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Food");
		List<Food> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public List<Object> selectAllCategories() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Query query = session.createQuery("select distinct itemCategory from Food");
		List<Object> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public List<Food> selectFoodItemsWithoutTransactionByLocation(String location) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//TODO figure out sql query
		List<Food> list = null;
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public List<Food> selectByCategory(String category) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Food food where food.itemCategory=:food_ITEMCATEGORY");
		query.setParameter("food_ITEMCATEGORY", category);
		List<Food> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public List<Food> selectByItemName(String itemName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Food food where food.itemName=:food_ITEMNAME");
		query.setParameter("food_ITEMNAME", itemName);
		List<Food> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public boolean insert(Food[] foods) {
		boolean retVal = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			for(Food food : foods) {
				session.save(food);
			}

			session.getTransaction().commit();
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean update(Food[] foods) {
		boolean retVal = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("from Food");
			List<Food> list = query.list();

			for(Food food : list) {
				for(int i = 0; i < foods.length; i++) {
					if(food.getItemName().equals(foods[i].getItemName())) {
						food.setItemName(foods[i].getItemName());
						food.setPrice(foods[i].getPrice());
						food.setSellBy(foods[i].getSellBy());
						food.setItemCategory(foods[i].getItemCategory());
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

	public boolean update(Food oldFood, Food newFood) {
		boolean retVal = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("from Food food where food.itemName=:food_ITEMNAME");
			query.setParameter("food_ITEMNAME", oldFood.getItemName());
			List<Food> list = query.list();

			Food food = list.get(0);

			food.setItemName(newFood.getItemName());
			food.setPrice(newFood.getPrice());
			food.setSellBy(newFood.getSellBy());
			food.setItemCategory(newFood.getItemCategory());

			session.getTransaction().commit();
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public void delete(Food food) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.delete(food);

		session.getTransaction().commit();
		session.close();
	}
}