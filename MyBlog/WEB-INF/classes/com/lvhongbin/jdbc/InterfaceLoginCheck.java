/**
 * 
 */
package com.lvhongbin.jdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.lvhongbin.bean.User;

/**
 * @author hblvs
 *
 */
public interface InterfaceLoginCheck {
	
	public void insert(Connection conn, User user) throws SQLException;
	
	public void update(Connection conn, Long id, User user) throws SQLException;
	
	public void delete(Connection conn, User user) throws SQLException;
	
	public ResultSet get(Connection conn, User user) throws SQLException;
	
	public ResultSet getName(Connection conn, User user) throws SQLException;

}
