package com.lvhongbin.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;



@Component(value="book2")
@Scope(value="singleton")
@Aspect
public class Book2 extends ActionSupport{
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
	@Autowired
	private Book book1;
	@Resource(name="book1")
	private Book book11;
	private String str1="";
	private String str2="";
	private String str3="";
	@Resource(name="user")
	private User user1;
	
	
	
	public Book2() {
	}
	
	public Book2(double price) {
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
		System.out.println(this.user1.getName()+" add 注解创建对象 successfully.....");
		book1.setStr(this.user1.getName()+" 混合模式 add 注解创建对象 successfully.....");
		this.str1= book1.getStr();
	}
	public void testSpring5() {
		System.out.println(this.user1.getName()+" 混合模式 add 注解@Autowired属性注入 successfully.....");
		book1.setStr(this.user1.getName()+" 混合模式 add 注解@Autowired属性注入 successfully.....");
		this.str2= book1.getStr();
	}
	public void testSpring6() {
		System.out.println(this.user1.getName()+" 混合模式 add 注解@Resource属性注入 successfully.....");
		book11.setStr(this.user1.getName()+" 混合模式 add 注解@Resource属性注入 successfully.....");
		this.str3= book11.getStr();
	}
	public void before() {
			System.out.println("使用AspectJ前置增强的方法");
	}
	public void after() {
		System.out.println("使用AspectJ后置增强的方法");
	}
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("方法之前..........");
		proceedingJoinPoint.proceed();
		System.out.println("方法之后..........");
	}
	
	@Before(value="execution(* com.lvhongbin.bean.Book.testSpring6())")
	public void before1() {
		System.out.println("注解方式使用AspectJ前置增强的方法");
	}
	@AfterReturning(value="execution(* com.lvhongbin.bean.Book.testSpring6())")
	public void after1() {
		System.out.println("注解方式使用AspectJ后置增强的方法");
	}
	@Around(value="execution(* com.lvhongbin.bean.Book.testSpring6())")
	public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("注解方式方法之前..........");
		proceedingJoinPoint.proceed();
		System.out.println("注解方式方法之后..........");
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
	 * @return the str1
	 */
	public String getStr1() {
		return str1;
	}


	/**
	 * @return the str2
	 */
	public String getStr2() {
		return str2;
	}


	/**
	 * @return the str3
	 */
	public String getStr3() {
		return str3;
	}

	/**
	 * @set the str1
	 */
	public void setStr1(String str1) {
		this.str1=str1;
	}
	
	/**
	 * @set the str2
	 */
	public void setStr2(String str2) {
		this.str2=str2;
	}
	
	/**
	 * @set the str3
	 */
	public void setStr3(String str3) {
		this.str3=str3;
	}


}
