/**
 * 
 */
package com.lvhongbin.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hblvs
 *
 */
public class ApplicationContextFactory {
	
	private static final ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private ApplicationContextFactory() {
	}

	public static ApplicationContext getInstance() {
		return applicationContext;
	}
}

