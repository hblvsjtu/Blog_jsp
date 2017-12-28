/**
 * 
 */
package com.lvhongbin.service;

import com.lvhongbin.bean.Book;
import com.lvhongbin.dao.SpringUserDao;

/**
 * @author hblvs
 *
 */
public class SpringUserService {

	private SpringUserDao springUserDao;

	/**
	 * @return the springUserDao
	 */
	public SpringUserDao getSpringUserDao() {
		return springUserDao;
	}

	/**
	 * @param springUserDao the springUserDao to set
	 */
	public void setSpringUserDao(SpringUserDao springUserDao) {
		this.springUserDao = springUserDao;
	}
	
	public String add(Book book) {
		return springUserDao.add(book);
	}
}
