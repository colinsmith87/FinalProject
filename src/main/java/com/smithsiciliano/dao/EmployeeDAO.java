package com.smithsiciliano.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.smithsiciliano.models.Employee;
import com.smithsiciliano.util.HibernateUtil;

public class EmployeeDAO {
	
	public List<Employee> select() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	    
		Query query = session.createQuery("from EMPLOYEE");
		List<Employee> list = query.list();
		session.close();
		return list;
	}
	
	public List<Employee> selectByEmployeeId(int employeeId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from EMPLOYEE employee where employee.EMPLOYEEID=:employee_EMPLOYEEID");
		query.setParameter("employee_EMPLOYEEID", employeeId);
		List<Employee> list = query.list();
		session.close();
		return list;
	}
	
	public boolean insert(Employee employee) {
		boolean retVal = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.save(employee);

			session.getTransaction().commit();
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean update(Employee oldEmployee, Employee newEmployee) {
		boolean retVal = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("from EMPLOYEE employee where employee.EMPLOYEEID=:employee_EMPLOYEEID");
			query.setParameter("employee_EMPLOYEEID", oldEmployee.getEmployeeId());
			List<Employee> list = query.list();
			
			Employee employee = list.get(0);

			employee.setAddState(newEmployee.getAddState());
			employee.setCity(newEmployee.getCity());
			employee.setDateOfBirth(newEmployee.getDateOfBirth());
			employee.setSalary(newEmployee.getSalary());
			employee.setStoreLoc(newEmployee.getStoreLoc());
			employee.setStreet(newEmployee.getStreet());
			employee.setZip(newEmployee.getZip());
			employee.setfName(newEmployee.getfName());
			employee.setlName(newEmployee.getlName());
			employee.setPhone(newEmployee.getPhone());
			employee.setEmployeeId(newEmployee.getEmployeeId());

			session.getTransaction().commit();
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}
	
	public void delete(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.delete(employee);
		
		session.getTransaction().commit();
		session.close();
	}
}