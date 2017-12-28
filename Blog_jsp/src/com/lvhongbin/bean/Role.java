package com.lvhongbin.bean;


import java.util.HashSet;
import java.util.Set;


public class Role {
	private Integer role_id;
	private String role_name;
	private String role_memo;
	private Set<User> setUser = new HashSet<User>(); 
	/**
	 * @return the role_id
	 */
	public Integer getRole_id() {
		return role_id;
	}
	/**
	 * @return the role_name
	 */
	public String getRole_name() {
		return role_name;
	}
	/**
	 * @return the role_memo
	 */
	public String getRole_memo() {
		return role_memo;
	}
	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	/**
	 * @param role_name the role_name to set
	 */
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	/**
	 * @param role_memo the role_memo to set
	 */
	public void setRole_memo(String role_memo) {
		this.role_memo = role_memo;
	}
	/**
	 * @return the setUser
	 */
	public Set<User> getSetUser() {
		return setUser;
	}
	/**
	 * @param setUser the setUser to set
	 */
	public void setSetUser(Set<User> setUser) {
		this.setUser = setUser;
	}
	
}
