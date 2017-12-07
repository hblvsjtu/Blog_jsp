package com.lvhongbin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StandardTime {
	
	SimpleDateFormat simpleDateFormat=null;
	Date currentTime=null;
	private String time;
	

	public StandardTime() {
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
		currentTime = new Date();    
		this.time = simpleDateFormat.format(currentTime).toString();
	}
	
	public StandardTime(String newSimpleDateFormat) {
		simpleDateFormat = new SimpleDateFormat(newSimpleDateFormat);    
		currentTime = new Date();    
		this.time = simpleDateFormat.format(currentTime).toString();
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
