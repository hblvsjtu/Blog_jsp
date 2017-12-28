/**
 * 
 */
package com.lvhongbin.factory;

import com.lvhongbin.bean.Book;

/**
 * @author hblvs
 *
 */
public class TestSpringBookFactory {
	
	public static Book bookFactory() {
		System.out.println("使用静态工厂");
		return new Book();
	}
	
	public  Book bookFactory2() {
		System.out.println("使用实例工厂");
		return new Book();
	}
}
