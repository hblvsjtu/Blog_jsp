/**
 * 
 */
package com.lvhongbin.service;

import java.sql.Connection;
import java.sql.ResultSet;
import com.lvhongbin.util.ConnectionFactory;
import com.lvhongbin.bean.User;
import com.lvhongbin.jdbc.JDBCOperation;

/**
 * @author hblvs
 *
 */
public class ServiceSignInAndUpCheck {
	
	private User user=null;
	
	public ServiceSignInAndUpCheck(){
		
	}
	public ServiceSignInAndUpCheck(User user){
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

	private JDBCOperation jdbcoperation =new JDBCOperation();
	
	public boolean check() {
		Connection conn=null;
		try {
			conn=ConnectionFactory.getInstance().makeConnection();
			System.out.println("========== JDBC连接状态："+conn.getAutoCommit()+" ==========");
			conn.setAutoCommit(false);
			ResultSet resultSet = jdbcoperation.get(conn, user);
			while(resultSet.next()){
				this.user.setName(resultSet.getString("name"));
				this.user.setDate(resultSet.getString("signUpTime"));
				return true;
			}
			System.out.println("======== 调用了ServiceSignInAndUpCheck的check()方法 ========");
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
	
	public boolean checkName() {
		Connection conn=null;
		try {
			conn=ConnectionFactory.getInstance().makeConnection();
			System.out.println("========== JDBC连接状态："+conn.getAutoCommit()+" ==========");
			conn.setAutoCommit(false);
			ResultSet resultSet = jdbcoperation.getName(conn, user);
			while(resultSet.next()){
				this.user.setName(resultSet.getString("name"));
				return true;
			}
			System.out.println("======== 调用了ServiceSignInAndUpCheck的checkName()方法 ========");
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
