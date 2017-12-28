/**
 * 
 */
package com.lvhongbin.factory;

import java.beans.PropertyVetoException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author hblvs
 *
 */
public class ComboPooledDataSourceFactory {
	
	private static final ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
	private ComboPooledDataSourceFactory() {
		// TODO Auto-generated constructor stub
	}
	static {
		try {
			comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jsp_db?useSSL=true");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("12345687");
	};
	
	public static ComboPooledDataSource getInstance() {
		return comboPooledDataSource;
	}

}
