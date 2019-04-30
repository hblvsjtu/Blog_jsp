/**
 * 
 */
package com.lvhongbin.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author hblvs
 *
 */
public class HibernateUtil {
	
	private final static Configuration cfg;
	private final static SessionFactory sessionFactory;
	
	static {
		cfg = new Configuration();
		cfg.configure();
		sessionFactory=cfg.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
