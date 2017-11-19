package com.lvhongbin.bean;

import java.io.Serializable;

public class EmailCheck implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//serialVersionUID值
    //private static final long serialV
    private String mailAdd;
    private boolean email=false;
    private String phoneAdd;
    private boolean phone=false;
    
	public EmailCheck(){
    }
    
    public EmailCheck(String mailAdd,String phoneAdd){
        this.mailAdd=mailAdd;
        this.phoneAdd=phoneAdd;
    }

    public boolean isEmail(){
        String regex ="\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        if (mailAdd.matches(regex)){
            email=true;
        }
        return email;
    }
    
    public boolean isPhone(){
        String regex ="^[1][3,4,5,7,8][0-9]{9}$";
        if (phoneAdd.matches(regex)){
            phone=true;
        }
        return phone;
    }

    public String getMailAdd() {
        return mailAdd;
    }

    public void setEmail(String mailAdd) {
        this. mailAdd =  mailAdd;
    }
    
    public String getPhoneAdd() {
		return phoneAdd;
	}

	public void setPhoneAdd(String phoneAdd) {
		this.phoneAdd = phoneAdd;
	}
}
