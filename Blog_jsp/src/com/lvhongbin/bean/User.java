package com.lvhongbin.bean;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private String name="name";
	private String password="password";
	private String email="email";
	private String sex="sex"; 
	private Integer id=10000;
	private String date="date";
	private Set<Role> setRole=new HashSet<Role>();

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
		
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", sex=" + sex + "]";
	}
	/**
	 * @return the setRole
	 */
	public Set<Role> getSetRole() {
		return setRole;
	}
	/**
	 * @param setRole the setRole to set
	 */
	public void setSetRole(Set<Role> setRole) {
		this.setRole = setRole;
	}
}
