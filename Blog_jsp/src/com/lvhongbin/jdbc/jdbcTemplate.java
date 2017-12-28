/**
 * 
 */
package com.lvhongbin.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author hblvs
 *
 */
public class jdbcTemplate {
	
	private ComboPooledDataSource comboPooledDataSource;

	/**
	 * @return the comboPooledDataSource
	 */
	public ComboPooledDataSource getComboPooledDataSource() {
		return comboPooledDataSource;
	}

	/**
	 * @param comboPooledDataSource the comboPooledDataSource to set
	 */
	public void setComboPooledDataSource(ComboPooledDataSource comboPooledDataSource) {
		this.comboPooledDataSource = comboPooledDataSource;
	}
	
}
