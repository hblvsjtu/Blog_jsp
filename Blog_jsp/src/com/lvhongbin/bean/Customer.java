/**
 * 
 */
package com.lvhongbin.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hblvs
 *
 */
public class Customer {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", custName=" + custName + ", custLevel=" + custLevel + ", custSource="
				+ custSource + ", custPhone=" + custPhone + ", custMobile=" + custMobile + ", setLinkMan=" + setLinkMan
				+ "]";
	}
	private Integer cid;
	private String custName;
	private String custLevel;
	private String custSource;
	private String custPhone;
	private String custMobile;
	private Set<LinkMan> setLinkMan=new HashSet<LinkMan>();
	
	/**
	 * @return the cid
	 */
	public Integer getCid() {
		return cid;
	}
	/**
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}
	/**
	 * @return the custLevel
	 */
	public String getCustLevel() {
		return custLevel;
	}
	/**
	 * @return the custSource
	 */
	public String getCustSource() {
		return custSource;
	}
	/**
	 * @return the custPhone
	 */
	public String getCustPhone() {
		return custPhone;
	}
	/**
	 * @return the custMobile
	 */
	public String getCustMobile() {
		return custMobile;
	}
	/**
	 * @param cid the cid to set
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	/**
	 * @param string the custName to set
	 */
	public void setCustName(String string) {
		this.custName = string;
	}
	/**
	 * @param custLevel the custLevel to set
	 */
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	/**
	 * @param custSource the custSource to set
	 */
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	/**
	 * @param custPhone the custPhone to set
	 */
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	/**
	 * @param custMobile the custMobile to set
	 */
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	/**
	 * @return the setLinkMan
	 */
	public Set<LinkMan> getSetLinkMan() {
		return setLinkMan;
	}
	/**
	 * @param setLinkMan the setLinkMan to set
	 */
	public void setSetLinkMan(Set<LinkMan> setLinkMan) {
		this.setLinkMan = setLinkMan;
	}

	
	
	
}
