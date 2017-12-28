/**
 * 
 */
package com.lvhongbin.factory;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author hblvs
 *
 */
public class DriverManagerDataSourceFactory {
	private static final DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
	
	private DriverManagerDataSourceFactory() {
		// TODO Auto-generated constructor stub
	}
	static {
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/jsp_db?useSSL=true");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("12345687");
	};
	
	public static DriverManagerDataSource getInstance() {
		return driverManagerDataSource;
	}
}
