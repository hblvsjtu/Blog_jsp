package com.lvhongbin.service;

import java.sql.Connection;

import com.lvhongbin.util.ConnectionFactory;
import com.lvhongbin.bean.User;
import com.lvhongbin.jdbc.JDBCOperation;

public class ServiceSignUpInsert {
	
	private User user=null;
	
	public ServiceSignUpInsert() {
		
	}
	
	public ServiceSignUpInsert(User user) {
		this.user=user;
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
	
	public Boolean insert() {
		Connection conn=null;
		JDBCOperation jdbcoperation=new JDBCOperation();
		try {
			conn=ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			jdbcoperation.insert(conn, user);
		} catch (Exception e) {
			System.out.println("========= 注册失败，无法添加信息到数据库 =========");
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return false;
		}finally {
			try {
				conn.close();
			} catch (Exception e3) {
				e3.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	public Boolean insert(User user) {
		boolean isInsertSuccess=true;
		this.user = user;
		Connection conn=null;
		JDBCOperation jdbcoperation=new JDBCOperation();
		try {
			conn=ConnectionFactory.getInstance().makeConnection();
			//conn.setAutoCommit(false);
			jdbcoperation.insert(conn, user);		
		} catch (Exception e) {
			System.out.println("========= 注册失败，无法添加信息到数据库 =========");
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			isInsertSuccess= false;
		}finally {
			try {
				conn.close();
			} catch (Exception e3) {
				e3.printStackTrace();
				isInsertSuccess=false;
			}
		}
		return isInsertSuccess;
	}
	
}
