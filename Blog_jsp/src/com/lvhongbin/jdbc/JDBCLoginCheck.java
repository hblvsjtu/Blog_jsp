/**
 * 
 */
package com.lvhongbin.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lvhongbin.bean.User;

/**
 * @author hblvs
 *
 */
public class JDBCLoginCheck implements InterfaceLoginCheck {

	/* (non-Javadoc)
	 * @see com.lvhongbin.jdbc.InterfaceLoginCheck#save(java.sql.Connection, com.lvhongbin.bean.User)
	 */
	@Override
	public void save(Connection conn, User user) throws SQLException {
		String saveSql="INSERT INTO tbl_user(name, password, email) VALUES(?,?,?)";
		PreparedStatement ps=conn.prepareStatement(saveSql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3,user.getEmail());
		ps.execute();
		System.out.println("======== 调用了JDBCLoginCheck的save()方法 ========");

	}

	/* (non-Javadoc)
	 * @see com.lvhongbin.jdbc.InterfaceLoginCheck#update(java.sql.Connection, java.lang.Long, com.lvhongbin.bean.User)
	 */
	@Override
	public void update(Connection conn, Long id, User user) throws SQLException {
		String updateSql="UPDATE tbl_user SET name=?, password=?, email=? WHERE id=?";
		PreparedStatement ps=conn.prepareStatement(updateSql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		//user.setId(id);
		//ps.setLong(4, user.getId());
		ps.setLong(4, id);
		ps.execute();
		System.out.println("======== 调用了JDBCLoginCheck的updata()方法 ========");
	}

	/* (non-Javadoc)
	 * @see com.lvhongbin.jdbc.InterfaceLoginCheck#delete(java.sql.Connection, com.lvhongbin.bean.User)
	 */
	@Override
	public void delete(Connection conn, User user) throws SQLException {
		String deleteSql="DELETE FROM tbl_user WHERE id=?";
		PreparedStatement ps=conn.prepareStatement(deleteSql);
		ps.setLong(4, user.getId());
		ps.execute();
		System.out.println("======== 调用了JDBCLoginCheck的delete()方法 ========");
	}

	/* (non-Javadoc)
	 * @see com.lvhongbin.jdbc.InterfaceLoginCheck#get(java.sql.Connection, com.lvhongbin.bean.User)
	 */
	@Override
	public ResultSet get(Connection conn, User user) throws SQLException {
		String resultSetSql="SELECT * From tbl_user WHERE name=? AND password=?";
		PreparedStatement ps=conn.prepareStatement(resultSetSql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		System.out.println("======== 调用了JDBCLoginCheck的get()方法 ========");
		return ps.executeQuery();
	}

}
