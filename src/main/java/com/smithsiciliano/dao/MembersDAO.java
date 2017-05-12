package com.smithsiciliano.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.smithsiciliano.models.Members;
import com.smithsiciliano.util.HibernateUtil;

public class MembersDAO {
	
	public List<Members> select() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	    
		Query query = session.createQuery("from Members");
		List<Members> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public List<Members> selectByMemberId(int memberId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Members member where member.memberId = :member_MEMBERID");
		query.setParameter("member_MEMBERID", memberId);
		List<Members> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public boolean insert(Members member) {
		boolean retVal = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.save(member);

			session.getTransaction().commit();
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean update(Members oldMember, Members newMember) {
		boolean retVal = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("from Members member where member.memberId=:member_MEMBERID");
			query.setParameter("member_MEMBERID", oldMember.getMemberId());
			List<Members> list = query.list();
			
			Members member = list.get(0);

			member.setDateOfBirth(newMember.getDateOfBirth());
			member.setfName(newMember.getfName());
			member.setlName(newMember.getlName());
			member.setMemberId(newMember.getMemberId());
			member.setPhone(newMember.getPhone());
			member.setPoints(newMember.getPoints());
			member.setStoreLoc(newMember.getStoreLoc());
		
			session.getTransaction().commit();
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}
	
	public void delete(Members member) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.delete(member);
		
		session.getTransaction().commit();
		session.close();
	}
}