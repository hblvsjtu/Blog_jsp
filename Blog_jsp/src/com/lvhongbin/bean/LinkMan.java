/**
 * 
 */
package com.lvhongbin.bean;

/**
 * @author hblvs
 *
 */
public class LinkMan {
	private Integer lkm_id;
	private String lkm_name;
	private String lkm_gender;
	private String lkm_phone;
	private Customer customer;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LinkMan [lkm_id=" + lkm_id + ", lkm_name=" + lkm_name + ", lkm_gender=" + lkm_gender + ", lkm_phone="
				+ lkm_phone + ", customer=" + customer + "]";
	}
	/**
	 * @return the lkm_id
	 */
	public Integer getLkm_id() {
		return lkm_id;
	}
	/**
	 * @return the lkm_name
	 */
	public String getLkm_name() {
		return lkm_name;
	}
	/**
	 * @return the lkm_gender
	 */
	public String getLkm_gender() {
		return lkm_gender;
	}
	/**
	 * @return the lkm_phone
	 */
	public String getLkm_phone() {
		return lkm_phone;
	}
	/**
	 * @param lkm_id the lkm_id to set
	 */
	public void setLkm_id(Integer lkm_id) {
		this.lkm_id = lkm_id;
	}
	/**
	 * @param lkm_name the lkm_name to set
	 */
	public void setLkm_name(String lkm_name) {
		this.lkm_name = lkm_name;
	}
	/**
	 * @param lkm_gender the lkm_gender to set
	 */
	public void setLkm_gender(String lkm_gender) {
		this.lkm_gender = lkm_gender;
	}
	/**
	 * @param lkm_phone the lkm_phone to set
	 */
	public void setLkm_phone(String lkm_phone) {
		this.lkm_phone = lkm_phone;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
