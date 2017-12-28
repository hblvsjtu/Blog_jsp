/**
 * 
 */
package com.lvhongbin.dao;


import org.springframework.jdbc.core.JdbcTemplate;
import com.lvhongbin.bean.Book;

/**
 * @author hblvs
 *
 */
public class SpringUserDao {

	private JdbcTemplate jdbcTemplate;

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public String add(Book book) {
		String result="";
		try {
			Double price=book.getPrice();
			String price1=price.toString();
			String sql="insert tbl_book(bookname,author,price,publicyear) values (?,?,?,?);";
			int i=jdbcTemplate.update(sql, book.getBookname(),book.getAuthor(),price1,book.getPublicyear());
			System.out.println("SpringUserDao添加成功 "+i);
			result="SpringUserDao添加成功 ";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SpringUserDao添加失败 ");
			result="SpringUserDao添加失败 ";
		}finally {
		}
		return result;
	}
	
}
