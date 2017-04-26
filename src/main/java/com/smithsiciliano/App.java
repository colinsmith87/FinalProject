package com.smithsiciliano;

import java.util.Date;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.smithsiciliano.models.*;
import com.smithsiciliano.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stores s = new Stores("Ipswich");
		Employee em = new Employee(0000,"Colin","Smith",65000,9785005381L,"61 High Street","Ipswich",
				"MA",1938,new Date(),"Ipswich");
		Dependent d = new Dependent("Devin","Smith","Sister",5555555555L,0000);
		Food f = new Food("Banana",05.50,new Date());
		InStock i = new InStock(0,"Ipswich","Banana");
		Members m = new Members("Patricia","Smith",new Date(),4444444444L,0,"Ipswich");
		Transactions t = new Transactions(05.50,"Banana","Ipswich");
		try {
			session.save(s);
			session.save(em);
			session.save(d);
			session.save(f);
			session.save(i);
			session.save(m);
			session.save(t);

			session.getTransaction().commit();
		} catch (org.hibernate.exception.ConstraintViolationException e) {

		} finally {
			session.close();
		}
    }
}
