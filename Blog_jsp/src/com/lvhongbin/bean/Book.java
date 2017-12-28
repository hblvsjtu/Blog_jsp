package com.lvhongbin.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;


@Component(value="book1")
@Scope(value="singleton")
public class Book extends ActionSupport{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private double price;
	private int bookCount;
	private String author;
	private User user=null;
	private String pbookCount="";
	private String[] arr;
	private List<Object> list;
	private Map<String, Object> map;
	private Properties property;
	private Set<Object> set;
	private String str="";
	private String bookname;
	private String publicyear;
	
	
	public Book() {
	}
	
	public Book(double price) {
		this.price=price;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the bookCount
	 */
	public int getBookCount() {
		return bookCount;
	}

	/**
	 * @param bookCount the bookCount to set
	 */
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author){
		this.author = author;
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
	
	public void testSpring1() {
		System.out.println("add testSpring1 无参构造方法 successfully.....");
	}
	public void testSpring2() {
		System.out.println("add testSpring2 静态工厂 successfully.....");
	}
	public void testSpring3() {
		System.out.println("add testSpring3 实例工厂 successfully.....");
	}
	public void testSpring4() {
		System.out.println("add 注解属性注入 successfully.....");
	}
	public void testSpring5() {
		System.out.println("配置文件方式使用AspectJ的方法");
	}
	public void testSpring6() {
		System.out.println("注解方式使用AspectJ的方法");
	}

	/**
	 * @return the pbookCount
	 */
	public String getPbookCount() {
		return pbookCount;
	}

	/**
	 * @param pbookCount the pbookCount to set
	 */
	public void setPbookCount(String pbookCount) {
		this.pbookCount = pbookCount;
	}


	/**
	 * @return the set
	 */
	public Set<Object> getSet() {
		return set;
	}

	/**
	 * @param set the set to set
	 */
	public void setSet(Set<Object> set) {
		this.set = set;
	}

	/**
	 * @return the map
	 */
	public Map<String, Object> getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	/**
	 * @return the list
	 */
	public List<Object> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Object> list) {
		this.list = list;
	}

	/**
	 * @return the property
	 */
	public Properties getProperty() {
		return property;
	}

	/**
	 * @param property the property to set
	 */
	public void setProperty(Properties property) {
		this.property = property;
	}

	/**
	 * @return the arr
	 */
	public String[] getArr() {
		return arr;
	}

	/**
	 * @param arr the arr to set
	 */
	public void setArr(String[] arr) {
		this.arr = arr;
	}


	/**
	 * @return the str
	 */
	public String getStr() {
		return str;
	}

	/**
	 * @param str the str to set
	 */
	public void setStr(String str) {
		this.str = str;
	}

	/**
	 * @return the bookname
	 */
	public String getBookname() {
		return bookname;
	}

	/**
	 * @param bookname the bookname to set
	 */
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	/**
	 * @return the publicyear
	 */
	public String getPublicyear() {
		return publicyear;
	}

	/**
	 * @param publicyear the publicyear to set
	 */
	public void setPublicyear(String publicyear) {
		this.publicyear = publicyear;
	}

}
