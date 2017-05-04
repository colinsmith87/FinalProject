package com.smithsiciliano.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.smithsiciliano.models.Dependent;
import com.smithsiciliano.util.HibernateUtil;

public class DependentDAO {
	
	public List<Dependent> select() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	    
		Query query = session.createQuery("from Dependent");
		List<Dependent> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public List<Dependent> selectByEmployeeId(int empId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Dependent dependent where dependent.empId=:dependent_EMPID");
		query.setParameter("dependent_EMPID", empId);
		List<Dependent> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public boolean insert(Dependent[] dependents) {
		boolean retVal = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			for(Dependent dependent : dependents) {
				session.save(dependent);
			}

			session.getTransaction().commit();
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean update(Dependent oldDependent, Dependent newDependent) {
		boolean retVal = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("from Dependent dependent "
					+ "where dependent.empId=:dependent_EMPID "
					+ "AND dependent.fName=:dependent_FNAME "
					+ "AND dependent.lName=:denendent_LNAME");
			query.setParameter("dependent_EMPID", oldDependent.getEmpId());
			query.setParameter("dependent_FNAME", oldDependent.getfName());
			query.setParameter("dependent_LNAME", oldDependent.getlName());
			List<Dependent> list = query.list();
			
			Dependent dependent = list.get(0);

			dependent.setfName(newDependent.getfName());
			dependent.setlName(newDependent.getlName());
			dependent.setPhone(newDependent.getPhone());
			dependent.setRelation(newDependent.getRelation());
			dependent.setEmpId(newDependent.getEmpId());

			session.getTransaction().commit();
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}
	
	public void updateAllByEmployeeId(Dependent[] dependents, int empId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Dependent dependent where dependent.empId=:dependent_EMPID");
		query.setParameter("dependent_EMPID", empId);
		List<Dependent> list = query.list();
		
		for(Dependent dependent : list) {
			session.delete(dependent);
		}
		
		for(Dependent dependent : dependents) {
			session.save(dependent);
		}
		
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(Dependent dependent) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.delete(dependent);
		
		session.getTransaction().commit();
		session.close();
	}
}