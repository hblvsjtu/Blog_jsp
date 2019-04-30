/**
 * 
 */
package com.lvhongbin.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lvhongbin.bean.User;
import com.lvhongbin.util.HibernateUtil;

/**
 * @author hblvs
 *
 */
public class TestHibernate {
	
	
	public void Test() {

		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		User user=new User();
		user.setName("lvhongbin");
		user.setPassword("12345687");
		user.setSex("male");
		session.save(user);
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	
	public static void name() {
		new TestHibernate();
	}
	


}
