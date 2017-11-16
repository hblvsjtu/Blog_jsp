/**
 * 
 */
package com.lvhongbin.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.lvhongbin.bean.User;
import com.lvhongbin.jdbc.JDBCLoginCheck;

/**
 * @author hblvs
 *
 */
public class ServiceLoginCheck {
	
	private User user=null;
	
	public ServiceLoginCheck(){
		
	}
	public ServiceLoginCheck(User user){
		this.user = user;
	}
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	private JDBCLoginCheck jdbcLoginCheck =new JDBCLoginCheck();
	
	@SuppressWarnings("null")
	public boolean check() {
		Connection conn=null;
		try {
			//conn=ConnectionFactory.getInstance().makeConnection();
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jsp_db?useSSL=false";
			String jdbcname="root";
			String jdbcpassword="12345687";
			conn=DriverManager.getConnection(url, jdbcname, jdbcpassword);
			conn.setAutoCommit(false);
			ResultSet resultSet = jdbcLoginCheck.get(conn, user);
			System.out.println("======== jdbc登陆成功 ========");
			while(resultSet.next()){
				
				return true;
			}
		}catch (Exception e){
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try{
				conn.close();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}
		return false;
	}
}
